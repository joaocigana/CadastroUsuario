package com.joao.cadastrousuario.daos;

import com.joao.cadastrousuario.configuracoes.DBConnector;
import com.joao.cadastrousuario.entities.Pessoa;
import com.joao.cadastrousuario.entities.Usuario;
import com.joao.cadastrousuario.enums.TipoDocumento;
import com.joao.cadastrousuario.exceptions.DBException;
import com.joao.cadastrousuario.exceptions.RegraDeNegocioVioladaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.joao.cadastrousuario.daointerfaces.UsuarioDAOInterface;

public class UsuarioDAO implements UsuarioDAOInterface {

    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserirUsuario(Usuario usuario) throws Exception {
        PreparedStatement st = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO usuario ");
        sb.append("(username, email, senha, pessoa_id) ");
        sb.append("VALUES (?, ?, ?, ?)");
        try {
            st = conn.prepareStatement(sb.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, usuario.getUsername());
            st.setString(2, usuario.getEmail());
            st.setString(3, usuario.getSenha());
            st.setInt(4, usuario.getPessoa().getId());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    usuario.setId(id);
                }
            } else {
                throw new DBException("Erro inesperado, nenhuma linha afetada!");
            }
        } catch (SQLException ex) {
            throw new DBException(ex.getMessage());
        } finally {
            DBConnector.closeResultSet(rs);
            DBConnector.closeStatement(st);
        }
    }

    @Override
    public void atualizarUsuario(Usuario usuario) throws Exception {
        PreparedStatement st = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE usuario SET username = ?, ");
        sb.append("email = ?, senha = ?, pessoa_id = ? ");
        sb.append("where Id = ?");
        try {
            conn.setAutoCommit(false);
            st = conn.prepareStatement(sb.toString());
            st.setString(1, usuario.getUsername());
            st.setString(2, usuario.getEmail());
            st.setString(3, usuario.getSenha());
            st.setInt(4, usuario.getPessoa().getId());
            st.setInt(5, usuario.getId());
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                conn.commit();
            } else {
                try {
                    conn.rollback();
                    throw new DBException("Erro ao atualizar pessoa!");
                } catch (SQLException ex) {
                    throw new DBException(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            throw new DBException(ex.getMessage());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        } finally {
            DBConnector.closeResultSet(rs);
            DBConnector.closeStatement(st);
        }
    }

    @Override
    public void deletarUsuario(Integer id) throws Exception {
        PreparedStatement pst = null;
        try {
            conn.setAutoCommit(false);
            pst = conn.prepareStatement("delete from usuario where Id = ?");
            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            if(rowsAffected > 0){
                conn.commit();
            }
            else{
                try{
                    conn.rollback();
                    throw new DBException("Erro ao deletar Usuario");
                } catch (SQLException ex){
                    throw new DBException(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            throw new DBException(ex.getMessage());
        } catch (Exception ex) {
            throw new Exception("Erro inesperado ao deletar usuario!", ex);
        } finally {
            DBConnector.closeStatement(pst);
        }
    }

    @Override
    public Usuario buscarUsuarioPeloID(Integer id) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT usuario.*, pessoa.firstname, pessoa.lastname, ");
        sb.append("pessoa.document_type, pessoa.document, pessoa.birth_date, pessoa.phone ");
        sb.append("FROM usuario INNER JOIN pessoa ");
        sb.append("ON usuario.pessoa_id = pessoa.Id WHERE usuario.Id = ?");
        try {
            if (existeUsuarioPeloId(id)) {
                pst = conn.prepareStatement(sb.toString());
                pst.setInt(1, id);
                rs = pst.executeQuery();
                rs.next();
                return instanciarUsuario(rs, instanciarPessoa(rs));
            } else {
                throw new RegraDeNegocioVioladaException("Id inexistente!");
            }
        } catch (SQLException ex) {
            throw new Exception("Erro inesperado ao buscar usuario!", ex);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        } finally {
            DBConnector.closeResultSet(rs);
            DBConnector.closeStatement(pst);
        }
    }

    @Override
    public boolean existeUsuarioPeloEmail(String email) throws Exception {
        boolean existe;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select email from usuario where email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            existe = rs.next();
            return existe;
        } catch (Exception ex) {
            throw new Exception("Erro inesperado ao consultar email!", ex);
        } finally {
            DBConnector.closeResultSet(rs);
            DBConnector.closeStatement(pst);
        }
    }

    @Override
    public boolean existeUsuarioPeloId(Integer id) throws Exception {
        boolean existe;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from usuario where Id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            existe = rs.next();
        } catch (Exception ex) {
            throw new Exception("Erro inesperado ao consultar usuario!", ex);
        } finally {
            DBConnector.closeResultSet(rs);
            DBConnector.closeStatement(pst);
        }
        return existe;
    }

    @Override
    public List<Usuario> listarUsuarios() throws Exception {
        List<Usuario> usuariosList = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        String query = "select * from usuario order by username";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                usuariosList.add(buscarUsuarioPeloID(rs.getInt("Id")));
            }
            return usuariosList;
        } catch (SQLException ex) {
            throw new Exception("Erro inesperado ao listar pessoas!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        } finally {
            DBConnector.closeResultSet(rs);
            DBConnector.closeStatement(st);
        }
    }

    private Pessoa instanciarPessoa(ResultSet rs) throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(rs.getInt("pessoa_id"));
        pessoa.setPrimeiroNome(rs.getString("firstname"));
        pessoa.setSobrenome(rs.getString("lastname"));
        pessoa.setTipoDocumento(TipoDocumento.valueOf(rs.getString("document_type")));
        pessoa.setDocumento(rs.getString("document"));
        pessoa.setTelefone(rs.getString("phone"));
        return pessoa;
    }

    private Usuario instanciarUsuario(ResultSet rs, Pessoa pessoa) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("Id"));
        usuario.setUsername(rs.getString("username"));
        usuario.setEmail(rs.getString("email"));
        usuario.setSenha(rs.getString("senha"));
        usuario.setPessoa(pessoa);
        return usuario;
    }

}
