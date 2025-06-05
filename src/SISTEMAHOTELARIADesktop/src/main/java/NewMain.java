
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.QuartoDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Quarto;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Conexao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author 202412170006
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConnection()){
            System.out.println("Conexao OK!");
            QuartoDAO dao = new QuartoDAO(conn);
            Quarto teste = new Quarto(null, 101, "Simples", new BigDecimal("150"), "Quarto teste");
            dao.inserir(teste);
            conn.commit();
            System.out.println("Quarto salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
       
        }
    }
    
}
