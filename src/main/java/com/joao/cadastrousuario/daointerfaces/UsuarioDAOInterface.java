package com.joao.cadastrousuario.daointerfaces;

import com.joao.cadastrousuario.entities.Pessoa;
import com.joao.cadastrousuario.entities.Usuario;
import java.util.List;

public interface UsuarioDAOInterface {
    
    public void inserirUsuario(Usuario usuario) throws Exception;
    
    public void atualizarUsuario(Usuario usuario) throws Exception;
    
    public void deletarUsuario (Integer id)throws Exception;
    
    public Usuario buscarUsuarioPeloID (Integer id) throws Exception;
    
    public boolean existeUsuarioPeloEmail (String email) throws Exception;
    
    public boolean existeUsuarioPeloId(Integer id) throws Exception;
    
    public List<Usuario> listarUsuarios() throws Exception;
    
}
