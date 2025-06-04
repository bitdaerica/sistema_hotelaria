package br.com.pensaosalvatore.sistema_hotelaria.modelo.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Érica_Almeida
 */
public class SecurityUtil {

    public static String hashPassword(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public static boolean verificarSenha(String senhaDigitada, String senhaHash) {
        return BCrypt.checkpw(senhaDigitada, senhaHash);
    }
}
