
package br.com.pensaosalvatore.sistema_hotelaria.modelo.util;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author 202412170006
 */
public class DocumentoUtil {
    
    // Novo: Validação de CPF 
    public static boolean validarCPF(JFormattedTextField campoCPF) {
        String cpf = campoCPF.getText().replaceAll("[^0-9]", "");
        
        if (cpf.length() != 11 || cpf.matches(cpf.charAt(0) + "{11}")) {
            mostrarErro("CPF inválido!", campoCPF);
            return false;
        }
        
        // Cálculo dos dígitos verificadores (opcional)
        try {
            int[] numeros = cpf.chars().map(Character::getNumericValue).toArray();
            
            // Primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += numeros[i] * (10 - i);
            }
            int resto = 11 - (soma % 11);
            int digito1 = resto > 9 ? 0 : resto;
            
            // Segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += numeros[i] * (11 - i);
            }
            resto = 11 - (soma % 11);
            int digito2 = resto > 9 ? 0 : resto;
            
            if (digito1 != numeros[9] || digito2 != numeros[10]) {
                mostrarErro("CPF inválido!", campoCPF);
                return false;
            }
            
        } catch (Exception e) {
            mostrarErro("Erro ao validar CPF!", campoCPF);
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
