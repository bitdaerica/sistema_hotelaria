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
    private JComboBox<Hospede> comboHospede;
    private JComboBox<Quarto> comboQuarto;
    private JComboBox<Usuario> comboUsuario;

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
        // Preencher datas e valores
        view.getFmtDataentrada().setText(reserva.getDataentrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        view.getFmtDatasaida().setText(reserva.getDatasaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        view.getTxtValor().setText(reserva.getValor().toString());
        view.getTxtObservacoes().setText(reserva.getObservacoes());

        // Preencher ComboBoxes com nomes
        Hospede hospede = hospedeDAO.selecionarPorId(reserva.getIdHospedes());
        if (hospede != null) {
            view.getCmbHospede().setSelectedItem(hospede.getNome());
        }

        Quarto quarto = quartoDAO.selecionarPorId(reserva.getIdQuartos());
        if (quarto != null) {
            view.getCmbQuarto().setSelectedItem(String.valueOf(quarto.getNumero()));
        }

        Usuario usuario = usuarioDAO.selecionarPorId(reserva.getIdUsuarios());
        if (usuario != null) {
            view.getCmbUsuario().setSelectedItem(usuario.getNome());
        }
    }

    private <T> void selecionarItemPorId(JComboBox<String> comboBox, T item) {
        if (item != null) {
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBox.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                if (model.getElementAt(i).equals(item.toString())) {
                    comboBox.setSelectedIndex(i);
                    break;
                }
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

    private Reserva construirReserva() throws ValidacaoException {
        try {
            Reserva reserva = new Reserva();

            // Obter valores selecionados
            String nomeHospede = (String) view.getCmbHospede().getSelectedItem();
            String numeroQuarto = (String) view.getCmbQuarto().getSelectedItem();
            String nomeUsuario = (String) view.getCmbUsuario().getSelectedItem();

            // Obter IDs
            int idHospede = extrairIdDoComboBox(nomeHospede, "hóspede");
            int idQuarto = extrairIdDoComboBox(numeroQuarto, "quarto");
            int idUsuario = extrairIdDoComboBox(nomeUsuario, "usuário");

            // Verificar se os IDs são válidos
            if (idHospede == -1 || idQuarto == -1 || idUsuario == -1) {
                throw new ValidacaoException("Registro não encontrado no banco");
            }

            // Setar valores na reserva
            reserva.setIdHospedes(idHospede);
            reserva.setIdQuartos(idQuarto);
            reserva.setIdUsuarios(idUsuario);

            // ... resto do método
            return reserva;
        } catch (SQLException e) {
            throw new ValidacaoException("Erro ao acessar o banco: " + e.getMessage());
        }
    }

    private int extrairIdDoComboBox(String itemSelecionado, String tipo) throws ValidacaoException, SQLException {
        if (itemSelecionado == null || itemSelecionado.trim().isEmpty()) {
            throw new ValidacaoException("Selecione um " + tipo);
        }

        try {
            switch (tipo) {
                case "hóspede":
                    Hospede hospede = (Hospede) hospedeDAO.listarPorNome(itemSelecionado);
                    return hospede != null ? hospede.getId() : -1;

                case "quarto":
                    Quarto quarto = quartoDAO.buscarPorNumero(Integer.parseInt(itemSelecionado));
                    return quarto != null ? quarto.getId() : -1;
                case "usuário":
                    Usuario usuario = (Usuario) usuarioDAO.listarPorNome(itemSelecionado);
                    return usuario != null ? usuario.getId() : -1;
                default:
                    throw new ValidacaoException("Tipo inválido");
            }
        } catch (NumberFormatException e) {
            throw new ValidacaoException("Número de quarto inválido");
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
        List<Hospede> hospedes = hospedeDAO.listarTodos();
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (Hospede h : hospedes) {
            modelo.addElement(h.getNome());  // Apenas o nome
        }
        view.getCmbHospede().setModel(modelo);
    }

    private void carregarComboBoxQuartos() throws SQLException {
        List<Quarto> quartos = quartoDAO.listarTodos();
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (Quarto q : quartos) {
            modelo.addElement(String.valueOf(q.getNumero()));  // Apenas o número
        }
        view.getCmbQuarto().setModel(modelo);
    }

    private void carregarComboBoxUsuarios() throws SQLException {
        List<Usuario> usuarios = usuarioDAO.listarTodos();
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (Usuario u : usuarios) {
            modelo.addElement(u.getNome());  // Apenas o nome
        }
        view.getCmbUsuario().setModel(modelo);
    }

    // 🔥 Método novo para popular a tabela de reservas
    public void popularTabela(JTable tabela) {
        try {
            List<Reserva> reservas = reservaDAO.listarTodas();
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0);

            for (Reserva reserva : reservas) {
                Hospede hospede = hospedeDAO.selecionarPorId(reserva.getIdHospedes());
                Quarto quarto = quartoDAO.selecionarPorId(reserva.getIdQuartos());
                Usuario usuario = usuarioDAO.selecionarPorId(reserva.getIdUsuarios());

                model.addRow(new Object[]{
                    reserva.getDataentrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    reserva.getDatasaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    "R$ " + reserva.getValor(),
                    hospede != null ? hospede.getNome() : "N/A",
                    quarto != null ? quarto.getNumero() : "N/A",
                    usuario != null ? usuario.getNome() : "N/A"
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view,
                    "Erro ao carregar reservas: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
