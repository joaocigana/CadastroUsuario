package com.joao.cadastrousuario.daos;

import com.joao.cadastrousuario.configuracoes.DBConnector;
import java.sql.SQLException;

public class DAOFactory {
    
    public static PessoaDAO createPessoaDAO() {
        return new PessoaDAO(DBConnector.startConnection());
    }
    
    public static UsuarioDAO createUsuarioDAO() {
        return new UsuarioDAO(DBConnector.startConnection());
    }
}
