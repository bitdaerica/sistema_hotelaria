

package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica_Almeida
 */
public class ConexaoDAO {
    
    public Connection conectaBD(){
        Connection conn = null;
    
        try {
            String url = "jdbc:mysql://localhost:3306/hotelaria?user=root%password=";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());
        }
        return conn;
    }
}
