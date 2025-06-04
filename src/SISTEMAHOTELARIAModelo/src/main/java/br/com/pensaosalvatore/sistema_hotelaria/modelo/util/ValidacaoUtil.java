package br.com.pensaosalvatore.sistema_hotelaria.modelo.util;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Quarto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Érica_Almeida
 */
public class ValidacaoUtil {

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

    public static boolean validarCPF(JFormattedTextField field) {
        String cpf = field.getText().replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            JOptionPane.showMessageDialog(null,
                    "CPF inválido! Deve conter 11 dígitos.",
                    "Validação",
                    JOptionPane.WARNING_MESSAGE);
            field.requestFocus();
            return false;
        }
        return true;
    }

    public static Quarto validar(String numeroStr, String tipo, String valorStr, String descricao)
            throws ValidacaoException {

        validarCampo(numeroStr, "Número do quarto");
        validarCampo(tipo, "Tipo do quarto");
        validarCampo(valorStr, "Valor do quarto");

        try {
            int numero = Integer.parseInt(numeroStr.trim());
            BigDecimal valor = new BigDecimal(valorStr.trim().replace(",", "."));

            if (numero <= 0) {
                throw new ValidacaoException("Número do quarto deve ser positivo");
            }

            if (valor.compareTo(BigDecimal.ZERO) <= 0) {
                throw new ValidacaoException("Valor do quarto deve ser positivo");
            }

            return new Quarto(null, numero, tipo.trim(), valor, descricao.trim());

        } catch (NumberFormatException e) {
            throw new ValidacaoException("Formato numérico inválido: " + e.getMessage());
        }
    }

    private static void validarCampo(String valor, String nomeCampo)
            throws ValidacaoException {
        if (valor == null || valor.trim().isEmpty()) {
            throw new ValidacaoException(nomeCampo + " é obrigatório");
        }
    }

    public static boolean validarForcaSenha(JPasswordField senhaField) {
        String senha = new String(senhaField.getPassword());

        if (senha.length() < 8) {
            JOptionPane.showMessageDialog(null,
                    "A senha deve ter no mínimo 8 caracteres!",
                    "Senha Fraca",
                    JOptionPane.WARNING_MESSAGE);
            senhaField.requestFocus();
            return false;
        }

        // Verificar se tem pelo menos um número
        if (!senha.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null,
                    "A senha deve conter pelo menos um número!",
                    "Senha Fraca",
                    JOptionPane.WARNING_MESSAGE);
            senhaField.requestFocus();
            return false;
        }

        // Verificar se tem pelo menos uma letra maiúscula
        if (!senha.matches(".*[A-Z].*")) {
            JOptionPane.showMessageDialog(null,
                    "A senha deve conter pelo menos uma letra maiúscula!",
                    "Senha Fraca",
                    JOptionPane.WARNING_MESSAGE);
            senhaField.requestFocus();
            return false;
        }

        return true;
    }

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
