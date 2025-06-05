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
    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private Conexao() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(true); // Desativa o auto-commit para controlar transações manualmente
                return connection;
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                        "Driver JDBC não encontrado: " + e.getMessage(),
                        "Erro de Conexão",
                        JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException("Driver JDBC não encontrado", e);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao conectar ao banco de dados: " + e.getMessage(),
                        "Erro de Conexão",
                        JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException("Erro ao conectar ao banco de dados", e);
            }
        }
        return connection;
    }
    
    public static void fecharConexao() {
        if (connection != null) {
            try {
                connection.close();
                connection = null; // Para garantir que uma nova conexão seja criada se necessário
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao fechar conexão: " + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void commit() throws SQLException {
        if (connection != null) {
            connection.commit();
        }
    }

    public static void rollback() {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao fazer rollback: " + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
