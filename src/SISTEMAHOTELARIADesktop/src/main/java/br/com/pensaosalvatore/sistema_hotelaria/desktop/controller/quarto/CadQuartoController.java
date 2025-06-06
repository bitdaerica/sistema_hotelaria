package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.quarto;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.quarto.CadQuartoView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.QuartoDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Quarto;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
            popularTabela(view.getjTable1(), quartos); // Assuming you have a way to access the JTable
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao carregar quartos: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void popularTabela(JTable tabela, List<Quarto> quartos) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setRowCount(0); // Limpa a tabela

        for (Quarto quarto : quartos) { // Iterate over quartos list, not the table
            model.addRow(new Object[]{
                quarto.getId(),
                quarto.getNumero(),
                quarto.getTipo(),
                quarto.getValor()
            });
        }
    }

    public void limparFormulario() {
        view.limparCampos();
        JOptionPane.showMessageDialog(null, "Pronto para novo cadastro.");
    }

    public void cancelar() {
        int resposta = JOptionPane.showConfirmDialog(
                view,
                "Deseja realmente cancelar o cadastro?",
                "Confirmar Cancelamento",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            view.dispose(); // Fechar a janela
        }
    }
}
