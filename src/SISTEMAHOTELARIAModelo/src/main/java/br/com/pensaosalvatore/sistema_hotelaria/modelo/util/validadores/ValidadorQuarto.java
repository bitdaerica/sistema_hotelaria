
package br.com.pensaosalvatore.sistema_hotelaria.modelo.util.validadores;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Quarto;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.ValidacaoException;
import java.math.BigDecimal;

/**
 *
 * @author 202412170006
 */
public class ValidadorQuarto {
    public static Quarto validar(String numeroStr, String tipo, String valorStr, String descricao) 
        throws ValidacaoException {
        
        validarCampoObrigatorio(numeroStr, "Número do quarto");
        validarCampoObrigatorio(tipo, "Tipo do quarto");
        validarCampoObrigatorio(valorStr, "Valor do quarto");
        
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
    
    private static void validarCampoObrigatorio(String valor, String nomeCampo) 
        throws ValidacaoException {
        if (valor == null || valor.trim().isEmpty()) {
            throw new ValidacaoException(nomeCampo + " é obrigatório");
        }
    }

}
