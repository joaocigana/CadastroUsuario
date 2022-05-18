package com.joao.cadastrousuario.daos;

import com.joao.cadastrousuario.configuracoes.DBConnector;
import com.joao.cadastrousuario.enums.TipoDocumento;
import com.joao.cadastrousuario.exceptions.RegraDeNegocioVioladaException;
import com.joao.cadastrousuario.entities.Pessoa;
import com.joao.cadastrousuario.exceptions.DBException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.joao.cadastrousuario.daointerfaces.PessoaDAOInterface;

public class PessoaDAO implements PessoaDAOInterface {

    private Connection conn;

    public PessoaDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserirPessoa(Pessoa pessoa) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("insert into pessoa (");
            sb.append("firstname, lastname, document_type,");
            sb.append("document, birth_date, phone");
            sb.append(") values (");
            sb.append("?, ?, ?, ?, ?, ?)");
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sb.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, pessoa.getPrimeiroNome());
            pst.setString(2, pessoa.getSobrenome());
            pst.setString(3, pessoa.getTipoDocumento().name());
            pst.setString(4, pessoa.getDocumento());
            pst.setDate(5, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            pst.setString(6, pessoa.getTelefone());
            int linhasAfetadas = pst.executeUpdate();
            if (linhasAfetadas > 0) {
                conn.commit();
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    pessoa.setId(id);
                }
            } else {
                try {
                    conn.rollback();
                    throw new DBException("Erro inesperado, nenhuma linha afetada");
                } catch (SQLException ex) {
                    throw new DBException(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            throw new Exception("Erro inesperado ao cadastrar pessoa!", ex);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            DBConnector.closeStatement(pst);
        }
    }

    @Override
    public Pessoa buscarPessoaPeloID(Integer id) throws Exception {
        Pessoa pessoa = new Pessoa();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "select * from pessoa where id = ?";
        try {
            if (existePessoaPeloId(id)) {
                pst = conn.prepareStatement(query);
                pst.setInt(1, id);
                rs = pst.executeQuery();
                rs.next();
                pessoa.setId(rs.getInt("Id"));
                pessoa.setPrimeiroNome(rs.getString("firstname"));
                pessoa.setSobrenome(rs.getString("lastname"));
                pessoa.setTipoDocumento(TipoDocumento.valueOf(rs.getString("document_type")));
                pessoa.setDocumento(rs.getString("document"));
                pessoa.setDataNascimento(rs.getDate("birth_date"));
                pessoa.setTelefone(rs.getString("phone"));
                return pessoa;
            } else {
                throw new RegraDeNegocioVioladaException("Id inexistente!");
            }
        } catch (SQLException ex) {
            throw new Exception("Erro inesperado ao buscar pessoa!", ex);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        } finally {
            DBConnector.closeResultSet(rs);
            DBConnector.closeStatement(pst);
        }
    }

    @Override
    public boolean existePessoaPeloDocumento(TipoDocumento tipoDoc, String doc) throws Exception {
        boolean existe;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select document from pessoa where document_type = ? and document = ?");
            pst.setString(1, tipoDoc.name());
            pst.setString(2, doc);
            rs = pst.executeQuery();
            existe = rs.next();
            return existe;
        } catch (Exception ex) {
            throw new Exception("Erro inesperado ao consultar documento!", ex);
        } finally {
            DBConnector.closeResultSet(rs);
            DBConnector.closeStatement(pst);
        }
    }

    @Override
    public void deletarPessoa(Integer id) throws Exception {
        PreparedStatement pst = null;
        try {
            conn.setAutoCommit(false);
            pst = conn.prepareStatement("delete from pessoa where Id = ?");
            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                conn.commit();
            } else {
                try {
                    conn.rollback();
                    throw new DBException("Erro: não foi possível concluir a deleção!");
                } catch (SQLException ex) {
                    throw new DBException(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            throw new DBException(ex.getMessage());
        } catch (Exception ex) {
            throw new Exception("Erro inesperado ao deletar pessoa!", ex);
        } finally {
            DBConnector.closeStatement(pst);
        }
    }

    @Override
    public List<Pessoa> listarPessoas() throws Exception {
        List<Pessoa> pessoasList = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        String query = "select * from pessoa order by firstname";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                pessoasList.add(buscarPessoaPeloID(rs.getInt("Id")));
            }
            return pessoasList;
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
    public boolean existePessoaPeloId(Integer id) throws Exception {
        boolean existe;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from pessoa where Id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            existe = rs.next();
        } catch (Exception ex) {
            throw new Exception("Erro inesperado ao consultar pessoa!", ex);
        } finally {
            DBConnector.closeResultSet(rs);
            DBConnector.closeStatement(pst);
        }
        return existe;
    }

    @Override
    public void atualizarPessoa(Pessoa pessoa) throws Exception {
        PreparedStatement pst = null;
        String query = "update pessoa set firstname = ?, "
                + "lastname = ?, document_type = ?, "
                + "document = ?, phone = ? "
                + "where Id = ?";
        try {
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(query);
            pst.setString(1, pessoa.getPrimeiroNome());
            pst.setString(2, pessoa.getSobrenome());
            pst.setString(3, pessoa.getTipoDocumento().toString());
            pst.setString(4, pessoa.getDocumento());
            pst.setString(5, pessoa.getTelefone());
            pst.setInt(6, pessoa.getId());
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                conn.commit();
            } else {
                try {
                    conn.rollback();
                    throw new DBException("Erro ao atualizar Pessoa");
                } catch (SQLException ex) {
                    throw new DBException(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new Exception("Erro inesperado ao atualizar pessoa!");
        } finally {
            DBConnector.closeStatement(pst);
        }
    }
}
