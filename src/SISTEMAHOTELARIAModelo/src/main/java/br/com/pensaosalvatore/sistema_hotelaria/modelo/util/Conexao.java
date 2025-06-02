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

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotelaria";
            String user = "root";
            String password = "";

            return DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: " + erro.getMessage());
            throw new RuntimeException(erro);
        }
    }
}
