

package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica_Almeida
 */
public class ConnectionFactoryDAO {
    
    public Connection conectaBD(){
        Connection conn = null;
    
        try {
            String url = "jdbc:mysql://localhost:3306/hotelaria";
            String user = "root";
            String password = "";
            
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());
        }
        return conn;
    }

    
}
