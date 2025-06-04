package br.com.pensaosalvatore.sistema_hotelaria.modelo.util;

/**
 *
 * @author Érica_Almeida
 */
public class ValidacaoException extends Exception {

    public ValidacaoException(String message) {
        super(message);
    }
    
    public ValidacaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
