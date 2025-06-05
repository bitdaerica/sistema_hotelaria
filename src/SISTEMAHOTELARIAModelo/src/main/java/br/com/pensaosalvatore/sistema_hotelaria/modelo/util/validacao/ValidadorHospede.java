
package br.com.pensaosalvatore.sistema_hotelaria.modelo.util.validacao;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Érica_Almeida
 */
public class ValidadorHospede {
    public static boolean validarEmail(JTextField emailField) {
        String email = emailField.getText().trim();
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        if (!email.matches(regex)) {
            JOptionPane.showMessageDialog(null,
                    "E-mail inválido! Por favor, insira um e-mail válido.",
                    "E-mail Inválido",
                    JOptionPane.WARNING_MESSAGE);
            emailField.requestFocus();
            return false;
        }
        return true;
    }
    
    
    
}
