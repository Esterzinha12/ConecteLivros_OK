package br.senai.sc.livros.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String url = "jdbc:mysql://localhost:3306/editora";
    private String username = "root";
    private String password = "root";
    public Connection conectaBD() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
