package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.hospede;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.hospede.CadHospedeView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.HospedeDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Validador;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Endereco;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Hospede;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Conexao;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.DocumentoUtil;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.ValidacaoException;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.validacao.ValidadorHospede;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica_Almeida
 */
public class CadHospedeController {

    private final CadHospedeView view;
    private HospedeDAO hospedeDAO;

    public CadHospedeController(CadHospedeView view) {

        this.view = view;
        try {
            Connection connection = Conexao.getConnection();
            this.hospedeDAO = new HospedeDAO(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void mostrar() {
        CadHospedeView v = new CadHospedeView();
        v.setVisible(true);
    }

    public void salvar() throws ValidacaoException {
        try {
            // Validação de campos obrigatórios
            if (!validarCampos()) {
                throw new ValidacaoException("Validação falhou. Verifique os campos.");
            }

            // Criar objeto Hospede com os dados da view
            Hospede hospede = new Hospede();
            hospede.setNome(view.getTxtNome().getText());
            hospede.setGenero(view.getTxtGenero().getText());

            // Converter data de nascimento
            String datanascimentoStr = view.getFmtDatanascimento().getText();
            LocalDate datanascimento = LocalDate.parse(datanascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            hospede.setDatanascimento(datanascimento);

            hospede.setCpf(view.getFmtCpf().getText().replaceAll("[^0-9]", ""));
            hospede.setEmail(view.getTxtEmail2().getText());
            hospede.setFixo(view.getFmtFixo().getText());
            hospede.setCelular(view.getFmtCelular().getText());
            hospede.setWhatsapp(view.getBtnWhatsapp().isSelected());
            hospede.setObservacoes(view.getTxtObservacoes().getText());
            hospede.setNacionalidade(view.getTxtNacionalidade().getText());
            hospede.setProfissao(view.getTxtProfissao().getText());

            String datacadastroStr = view.getFmtDatacadastro().getText();
            LocalDate datacadastro = LocalDate.parse(datacadastroStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            hospede.setDatacadastro(datacadastro);

            // Criar e configurar endereço
            Endereco endereco = new Endereco();
            endereco.setRua(view.getTxtRua().getText());
            endereco.setNumero(view.getTxtNumero().getText());
            endereco.setComplemento(view.getTxtComplemento().getText());
            endereco.setBairro(view.getTxtBairro().getText());
            endereco.setCidade(view.getTxtCidade().getText());
            endereco.setEstado(view.getTxtEstado().getText());
            endereco.setCep(view.getFmtCep().getText().replaceAll("[^0-9]", ""));

            hospede.setEndereco(endereco);

            // Verificar se é um novo hospede ou uma atualização
            if (hospede.getId() == null) {
                hospedeDAO.inserir(hospede);
                JOptionPane.showMessageDialog(view, "Hospede cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                hospedeDAO.alterar(hospede);
                JOptionPane.showMessageDialog(view, "Hospede atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

            novo(); // Limpar campos após salvar

        } catch (SQLException e) {
            tratarErroSQL(e);
        } catch (DateTimeParseException e) {
            throw new ValidacaoException("Data de nascimento inválida! Use o formato DD/MM/AAAA", e);
        }
    }

    private boolean validarCampos() {
        // Validação dos campos obrigatórios
        if (!Validador.validarCampoObrigatorio(view.getTxtNome(), "Nome")) {
            return false;
        }
        if (!Validador.validarCampoObrigatorio(view.getTxtGenero(), "Gênero")) {
            return false;
        }
        if (!Validador.validarData(view.getFmtDatanascimento(), "Data de Nascimento")) {
            return false;
        }
        if (!DocumentoUtil.validarCPF(view.getFmtCpf())) {
            return false;
        }
        if (!ValidadorHospede.validarEmail(view.getTxtEmail2())) {
            return false;
        }
        if (!Validador.validarData(view.getFmtDatacadastro(), "Data de Cadastro")) {
            return false;
        }
        if (!Validador.validarCampoObrigatorio(view.getTxtNacionalidade(), "Nacionalidade")) {
            return false;
        }
        if (!Validador.validarCampoObrigatorio(view.getTxtProfissao(), "Profissão")) {
            return false;
        }
        if (!Validador.validarCampoObrigatorio(view.getTxtRua(), "Rua")) {
            return false;
        }
        if (!Validador.validarCampoObrigatorio(view.getTxtNumero(), "Número")) {
            return false;
        }
        if (!Validador.validarCampoObrigatorio(view.getTxtBairro(), "Bairro")) {
            return false;
        }
        if (!Validador.validarCampoObrigatorio(view.getTxtCidade(), "Cidade")) {
            return false;
        }
        if (!Validador.validarCampoObrigatorio(view.getTxtEstado(), "Estado")) {
            return false;
        }
        if (!Validador.validarCampoObrigatorio(view.getFmtCep(), "CEP")) {
            return false;
        }

        return true;
    }

    private void tratarErroSQL(SQLException e) {
        String mensagem;

        // Verificar códigos de erro específicos
        if (e.getErrorCode() == 1062) { // Código de erro para entrada duplicada no MySQL
            if (e.getMessage().contains("hospede.hospede")) {
                mensagem = "Nome de hospede já existe! Escolha outro.";
                view.getTxtNome().requestFocus();
            } else if (e.getMessage().contains("pessoa.cpf")) {
                mensagem = "CPF já cadastrado!";
                view.getFmtCpf().requestFocus();
            } else {
                mensagem = "Dado duplicado: " + e.getMessage();
            }
        } else {
            mensagem = "Erro ao tratar: " + e.getMessage();
        }

        JOptionPane.showMessageDialog(view, mensagem, "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
    }

    public void novo() {
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
