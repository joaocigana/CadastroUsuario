package com.joao.cadastrousuario.services;

import com.joao.cadastrousuario.entities.Usuario;
import com.joao.cadastrousuario.exceptions.DBException;
import com.joao.cadastrousuario.exceptions.RegraDeNegocioVioladaException;
import com.joao.cadastrousuario.repository.UsuarioRepositoryInterface;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private UsuarioRepositoryInterface usuarioDAO;

    public UsuarioService(UsuarioRepositoryInterface usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void cadastrarUsuario(Usuario usuario) throws Exception {
        try{
            if(usuarioDAO.existeUsuarioPeloEmail(usuario.getEmail())){
                throw new RegraDeNegocioVioladaException("Já existe um usuario cadastrado com este email!");
            } else{
                usuarioDAO.inserirUsuario(usuario);
            }
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage(), ex);
        }
    }

    public Usuario buscarUsuarioPeloId(Integer id) throws Exception {
        try{
            if(usuarioDAO.existeUsuarioPeloId(id)){
                return usuarioDAO.buscarUsuarioPeloID(id);
            } else {
                throw new RegraDeNegocioVioladaException("Não existe usuario com Id: " + id);
            }
        } 
        catch (Exception ex){
            throw new Exception(ex.getMessage(), ex);
        }
    }

    public void deletarUsuario(Integer id) throws Exception {
        try{
            if(usuarioDAO.existeUsuarioPeloId(id)){
                usuarioDAO.deletarUsuario(id);
            } else{
                throw new RegraDeNegocioVioladaException("Impossível deletar: não existe usuario com id " + id + "!");
            }
        } catch (Exception ex){
            throw new Exception(ex.getMessage(), ex);
        }
    }

    public List<Usuario> listarUsuarios() throws Exception {
        try{
            return usuarioDAO.listarUsuarios();
        } catch (Exception ex){
            throw new Exception(ex.getMessage(), ex);
        }
    }

    public void atualizarUsuario(Usuario usuario) throws Exception {
        try{
            if(usuarioDAO.existeUsuarioPeloEmail(usuario.getEmail())){
                throw new RegraDeNegocioVioladaException("O email informado ja está em uso!");
            } else {
                usuarioDAO.atualizarUsuario(usuario);
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

}
