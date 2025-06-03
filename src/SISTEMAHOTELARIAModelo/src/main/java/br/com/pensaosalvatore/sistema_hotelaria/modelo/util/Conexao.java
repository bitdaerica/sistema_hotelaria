package br.com.pensaosalvatore.sistema_hotelaria.modelo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica_Almeida
 */
public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/hotelaria";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: " + erro.getMessage());
            throw new RuntimeException("Erro na conexão com o banco de dados", erro);
        }
    }
}

