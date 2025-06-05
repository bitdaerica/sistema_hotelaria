package br.com.pensaosalvatore.sistema_hotelaria.modelo.util.validadores;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Validador;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author 202412170006
 */
public class ValidadorUsuario extends Validador {

    // Constantes para configuração
    private static final int TAMANHO_MINIMO_SENHA = 8;
    private static final String ERRO_TAMANHO_SENHA
            = "A senha deve ter no mínimo " + TAMANHO_MINIMO_SENHA + " caracteres!";
    private static final String ERRO_SENHA_SEM_NUMERO
            = "A senha deve conter pelo menos um número!";
    private static final String ERRO_SENHA_SEM_MAIUSCULA
            = "A senha deve conter pelo menos uma letra maiúscula!";

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

    public static boolean validarSenha(JPasswordField campoSenha) {
        String senha = new String(campoSenha.getPassword());

        if (senha.length() < TAMANHO_MINIMO_SENHA) {
            mostrarErro(ERRO_TAMANHO_SENHA, campoSenha);
            return false;
        }

        if (!senha.matches(".*\\d.*")) {
            mostrarErro(ERRO_SENHA_SEM_NUMERO, campoSenha);
            return false;
        }

        if (!senha.matches(".*[A-Z].*")) {
            mostrarErro(ERRO_SENHA_SEM_MAIUSCULA, campoSenha);
            return false;
        }

        return true;
    }
    
    // Método auxiliar para exibir mensagens de erro
    private static void mostrarErro(String mensagem, JComponent componente) {
        JOptionPane.showMessageDialog(
            null,
            mensagem,
            "Validação",
            JOptionPane.WARNING_MESSAGE
        );
        componente.requestFocus();
    }

}
