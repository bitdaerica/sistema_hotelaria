

import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Conexao;
import java.sql.Connection;



/**
 *
 * @author Érica_Almeida
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConnection()) {
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            System.err.println("Falha na conexão: " + e.getMessage());
        }
    }

}
