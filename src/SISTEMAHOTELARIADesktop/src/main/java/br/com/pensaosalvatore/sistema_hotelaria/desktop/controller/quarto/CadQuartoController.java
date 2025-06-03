package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.quarto;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.quarto.CadQuartoView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.QuartoDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Quarto;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica_Almeida
 */
public class CadQuartoController {

    private CadQuartoView view;
    private QuartoDAO quartoDAO;

    public CadQuartoController(CadQuartoView view) {
        this.view = view;
        try {
            Connection connection = Conexao.getConnection();
            this.quartoDAO = new QuartoDAO(connection);
            this.carregarQuartos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Método para salvar um quarto
   public void salvar(Quarto quarto) {
        try {
            if (quarto.getId() == null) {
                quartoDAO.inserir(quarto);
                JOptionPane.showMessageDialog(view, "Quarto cadastrado com sucesso!");
            } else {
                quartoDAO.alterar(quarto);
                JOptionPane.showMessageDialog(view, "Quarto atualizado com sucesso!");
            }
            carregarQuartos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, 
                "Erro ao salvar quarto: " + e.getMessage(), 
                "Erro no banco de dados", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluirQuarto(int id) {
        try {
            quartoDAO.excluir(id);
            carregarQuartos();
            JOptionPane.showMessageDialog(view, "Quarto excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, 
                "Erro ao excluir quarto: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public Quarto buscarPorId(int id) {
        try {
            return quartoDAO.selecionarPorId(id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, 
                "Erro ao buscar quarto: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void carregarQuartos() {
        try {
            List<Quarto> quartos = quartoDAO.listarTodos();
            view.popularTabela(quartos);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, 
                "Erro ao carregar quartos: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limparFormulario() {
        view.limparCampos();
    }
}
