package br.com.modelo;

import java.sql.SQLException;

public class TestandoBanco {
    public static void main(String[] args) throws SQLException {
        DAO cx = new DAO();
        cx.abrirBanco();
    }
    
}
