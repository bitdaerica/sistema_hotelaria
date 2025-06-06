package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.reserva;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.hospede.CadHospedeView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.reserva.CadReservaView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.HospedeDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.QuartoDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.ReservaDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.UsuarioDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Hospede;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Quarto;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Reserva;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Usuario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Conexao;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.ValidacaoException;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Validador;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Érica_Almeida
 */
public class CadReservaController {

    private CadReservaView view;
    private ReservaDAO reservaDAO;
    private HospedeDAO hospedeDAO;
    private QuartoDAO quartoDAO;
    private UsuarioDAO usuarioDAO;
    private JDialog popupSelecao;

    public CadReservaController(CadReservaView view) {
        this.view = view;
        try {
            Connection connection = Conexao.getConnection();
            this.reservaDAO = new ReservaDAO(connection);
            this.hospedeDAO = new HospedeDAO(connection);
            this.quartoDAO = new QuartoDAO(connection);
            this.usuarioDAO = new UsuarioDAO(connection);

            carregarComboboxes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void setPopupSelecao(JDialog popup) {
        this.popupSelecao = popup;
    }

    public void mostrar() {
        CadReservaView v = new CadReservaView();
        v.setVisible(true);
    }

    public void selecionarReservaDaTabela(JTable tabela) {
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
            try {
                int idReserva = (int) tabela.getValueAt(linhaSelecionada, 0);
                Reserva reserva = reservaDAO.buscarPorId(idReserva);

                preencherCampos(reserva);
                if (popupSelecao != null) {
                    popupSelecao.dispose();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Erro ao carregar reserva: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void preencherCampos(Reserva reserva) throws SQLException {
        view.getFmtDataentrada().setText(reserva.getDataentrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        view.getFmtDatasaida().setText(reserva.getDatasaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        view.getTxtValor().setText(reserva.getValor().toString());
        view.getTxtObservacoes().setText(reserva.getObservacoes());

        // Converter para String antes de selecionar nos ComboBox
        selecionarItemPorId(view.getCmbHospede(), hospedeDAO.selecionarPorId(reserva.getIdHospedes()));
        selecionarItemPorId(view.getCmbQuarto(), quartoDAO.selecionarPorId(reserva.getIdQuartos()));
        selecionarItemPorId(view.getCmbUsuario(), usuarioDAO.selecionarPorId(reserva.getIdUsuarios()));
    }

    private <T> void selecionarItemPorId(JComboBox<T> comboBox, T item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                comboBox.setSelectedIndex(i);
                return;
            }
        }
    }

    public void salvar() throws ValidacaoException {
        try {
            if (!validarCampos()) {
                throw new ValidacaoException("Validação falhou. Verifique os campos.");
            }

            Reserva reserva = construirReserva();

            if (reserva.getId() == null || reserva.getId() == 0) {
                reservaDAO.adicionar(reserva);
                JOptionPane.showMessageDialog(view, "Reserva cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                reservaDAO.atualizar(reserva);
                JOptionPane.showMessageDialog(view, "Reserva atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

            novo();
        } catch (SQLException e) {
            tratarErroSQL(e);
        } catch (DateTimeParseException e) {
            throw new ValidacaoException("Data inválida! Use o formato DD/MM/AAAA", e);
        } catch (NumberFormatException e) {
            throw new ValidacaoException("Valor inválido!", e);
        }
    }

    private Reserva construirReserva() throws DateTimeParseException, NumberFormatException, ValidacaoException {
        Reserva reserva = new Reserva();

        reserva.setDataentrada(LocalDate.parse(view.getFmtDataentrada().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        reserva.setDatasaida(LocalDate.parse(view.getFmtDatasaida().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        reserva.setValor(new BigDecimal(view.getTxtValor().getText()));
        reserva.setObservacoes(view.getTxtObservacoes().getText());

        // Verifica explicitamente a existência dos registros
        Hospede hospede = (Hospede) view.getCmbHospede().getSelectedItem();
        Quarto quarto = (Quarto) view.getCmbQuarto().getSelectedItem();
        Usuario usuario = (Usuario) view.getCmbUsuario().getSelectedItem();
        if (hospede == null || quarto == null || usuario == null) {
            throw new ValidacaoException("Registro não encontrado no banco de dados");
        }
        reserva.setIdHospedes(hospede.getId());
        reserva.setIdQuartos(quarto.getId());
        reserva.setIdUsuarios(usuario.getId());

        
        return reserva;
    }

    private int extrairIdDoComboBox(String itemSelecionado) throws ValidacaoException {
        if (itemSelecionado == null || itemSelecionado.trim().isEmpty()) {
            throw new ValidacaoException("Item não selecionado");
        }

        try {
            // Para casos onde o combobox mostra "1 - Meire" ou apenas "1"
            String[] partes = itemSelecionado.split("-");
            return Integer.parseInt(partes[0].trim());
        } catch (Exception e) {
            throw new ValidacaoException("Formato inválido no ComboBox: " + itemSelecionado);
        }
    }

    private boolean validarCampos() {
        if (!Validador.validarData(view.getFmtDataentrada(), "Data de Entrada")) {
            return false;
        }
        if (!Validador.validarData(view.getFmtDatasaida(), "Data de Saída")) {
            return false;
        }
        if (!Validador.validarCampoObrigatorio(view.getTxtValor(), "Valor")) {
            return false;
        }
        if (view.getCmbHospede().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(view, "Selecione um hóspede!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getCmbQuarto().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(view, "Selecione um quarto!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (view.getCmbUsuario().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(view, "Selecione um usuário!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        try {
            LocalDate entrada = LocalDate.parse(view.getFmtDataentrada().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate saida = LocalDate.parse(view.getFmtDatasaida().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            if (!saida.isAfter(entrada)) {
                JOptionPane.showMessageDialog(view, "Data de saída deve ser posterior à data de entrada!", "Atenção", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (DateTimeParseException e) {
            return false;
        }

        return true;
    }

    private void tratarErroSQL(SQLException e) {
        String mensagem;

        if (e.getErrorCode() == 1452) {
            mensagem = "Erro de referência: Verifique se o hóspede, quarto ou usuário existem no sistema.";
        } else {
            mensagem = "Erro ao salvar reserva: " + e.getMessage();
        }

        JOptionPane.showMessageDialog(view, mensagem, "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
    }

    public void novo() {
        view.limparCampos();
        carregarComboboxes();
        JOptionPane.showMessageDialog(null, "Pronto para nova reserva.");
    }

    public void novoHospede() {
        CadHospedeView tela = new CadHospedeView();
        tela.setVisible(true);
    }

    public void cancelar() {
        int resposta = JOptionPane.showConfirmDialog(
                view,
                "Deseja realmente cancelar o cadastro da reserva?",
                "Confirmar Cancelamento",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            view.dispose();
        }
    }

    public void carregarComboboxes() {
        try {
            carregarComboBoxHospedes();
            carregarComboBoxQuartos();
            carregarComboBoxUsuarios();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarComboBoxHospedes() throws SQLException {
        if (view.getCmbHospede() == null) {
            throw new IllegalStateException("ComboBox de hóspedes não foi inicializado na view");
        }

        List<Hospede> hospedes = hospedeDAO.listarTodos();
        DefaultComboBoxModel<Hospede> modelo = new DefaultComboBoxModel<>();
        for (Hospede h : hospedes) {
            modelo.addElement(h);
        }
        view.getCmbHospede().setModel(modelo);
    }

    private void carregarComboBoxQuartos() throws SQLException {
        List<Quarto> quartos = quartoDAO.listarTodos();
        DefaultComboBoxModel<Quarto> modelo = new DefaultComboBoxModel<>();
        for (Quarto q : quartos) {
            modelo.addElement(q);
        }
        view.getCmbQuarto().setModel(modelo);
    }

    private void carregarComboBoxUsuarios() throws SQLException {
        List<Usuario> usuarios = usuarioDAO.listarTodos();
        DefaultComboBoxModel<Usuario> modelo = new DefaultComboBoxModel<>();
        for (Usuario u : usuarios) {
            modelo.addElement(u);
        }
        view.getCmbUsuario().setModel(modelo);
    }

    // Método novo para popular a tabela de reservas
    public void popularTabela(JTable tabela) {
        try {
            List<Reserva> reservas = reservaDAO.listarTodas();
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0); // Limpa a tabela

            for (Reserva reserva : reservas) {
                Hospede hospede = hospedeDAO.selecionarPorId(reserva.getIdHospedes());
                Quarto quarto = quartoDAO.selecionarPorId(reserva.getIdQuartos());
                Usuario usuario = usuarioDAO.selecionarPorId(reserva.getIdUsuarios());

                model.addRow(new Object[]{
                    reserva.getDataentrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    reserva.getDatasaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    "R$ " + reserva.getValor(),
                    reserva.getObservacoes(),
                    hospede != null ? hospede.getNome() : "N/A",
                    quarto != null ? quarto.getNumero() : "N/A",
                    usuario != null ? usuario.getUsuario() : "N/A"
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar dados da reserva: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
