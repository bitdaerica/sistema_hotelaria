package br.com.pensaosalvatore.sistema_hotelaria.modelo.util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Érica_Almeida
 */
public class Validador {

    public static boolean validarCampoObrigatorio(JComponent componente, String nomeCampo) {
        if (componente instanceof JTextField field) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "O campo " + nomeCampo + " é obrigatório!",
                        "Validação",
                        JOptionPane.WARNING_MESSAGE);
                field.requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean validarData(JFormattedTextField field, String nomeCampo) {
        try {
            LocalDate.parse(field.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null,
                    "Data inválida no campo " + nomeCampo + "! Use o formato DD/MM/AAAA",
                    "Validação",
                    JOptionPane.WARNING_MESSAGE);
            field.requestFocus();
            return false;
        }
    }


}
