package com.joao.cadastrousuario.configuracoes;

import com.joao.cadastrousuario.exceptions.DBException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnector {
    
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/bancousuarios";
    public static final String DB_USER = "postgres";
    public static final String DB_PASS = "postgres";
    
    private static Connection conn;

    public static Connection startConnection() {
            try{
            conn = DriverManager.getConnection(
                    DBConnector.DB_URL,
                    DBConnector.DB_USER,
                    DBConnector.DB_PASS);
            }
            catch (SQLException ex){
                throw new DBException ("Erro inesperado ao iniciar conexão com o banco de dados!");
            }
        return conn;
    }
    
    public static void closeConnection(Connection conn) throws SQLException{
        if(conn != null);
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new DBException("Erro inesperado ao encerrar conexão com o banco de dados!");
        }
    }
    
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                throw new DBException(ex.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw new DBException(ex.getMessage());
        }
    }
    
}
