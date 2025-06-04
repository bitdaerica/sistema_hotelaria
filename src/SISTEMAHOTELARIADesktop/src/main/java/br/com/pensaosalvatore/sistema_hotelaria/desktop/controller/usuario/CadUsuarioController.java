package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.usuario;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.usuario.CadUsuarioView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.UsuarioDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.ValidacaoUtil;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Endereco;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Usuario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.ValidacaoException;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica_Almeida
 */
public class CadUsuarioController {

    private final CadUsuarioView view;
    private final UsuarioDAO usuarioDAO;

    public CadUsuarioController(CadUsuarioView view, UsuarioDAO usuarioDAO) {
          if (view == null || usuarioDAO == null) {
            throw new IllegalArgumentException("Dependências não podem ser nulas");
        }
        this.view = view;
        this.usuarioDAO = usuarioDAO;
    }

    public void salvar() throws ValidacaoException {
        try {
            // Validação de campos obrigatórios
            if (!validarCampos()) {
                throw new ValidacaoException("Validação falhou. Verifique os campos.");
            }

            // Criar objeto Usuario com os dados da view
            Usuario usuario = new Usuario();
            usuario.setNome(view.getTxtNome().getText());
            usuario.setGenero(view.getTxtGenero().getText());

            // Converter data de nascimento
            String datanascimentoStr = view.getFmtDatanascimento().getText();
            LocalDate datanascimento = LocalDate.parse(datanascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            usuario.setDatanascimento(datanascimento);

            usuario.setCpf(view.getFmtCpf().getText().replaceAll("[^0-9]", ""));
            usuario.setEmail(view.getTxtEmail2().getText());
            usuario.setFixo(view.getFmtFixo().getText());
            usuario.setCelular(view.getFmtCelular().getText());
            usuario.setWhatsapp(view.getBtnWhatsapp().isSelected());
            usuario.setObservacoes(view.getTxtObservacoes().getText());
            usuario.setUsuario(view.getTxtUsuario().getText());
            usuario.setSenha(new String(view.getSenha().getPassword()));

            // Criar e configurar endereço
            Endereco endereco = new Endereco();
            endereco.setRua(view.getTxtRua().getText());
            endereco.setNumero(view.getTxtNumero().getText());
            endereco.setComplemento(view.getTxtComplemento().getText());
            endereco.setBairro(view.getTxtBairro().getText());
            endereco.setCidade(view.getTxtCidade().getText());
            endereco.setEstado(view.getTxtEstado().getText());
            endereco.setCep(view.getFmtCep().getText().replaceAll("[^0-9]", ""));

            usuario.setEndereco(endereco);

            // Verificar se é um novo usuário ou uma atualização
            if (usuario.getId() == null) {
                usuarioDAO.inserir(usuario);
                JOptionPane.showMessageDialog(view, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                usuarioDAO.alterar(usuario);
                JOptionPane.showMessageDialog(view, "Usuário atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

            novo(); // Limpar campos após salvar

        } catch (SQLException e) {
            throw new ValidacaoException("Erro no banco de dados", e);
        } catch (DateTimeParseException e) {
            throw new ValidacaoException("Data de nascimento inválida! Use o formato DD/MM/AAAA", e);
        } catch (ValidacaoException | HeadlessException e) {
            throw new ValidacaoException("Erro inesperado", e);
        }
    }

    private boolean validarCampos() {
        // Validação dos campos obrigatórios
        if (!ValidacaoUtil.validarCampoObrigatorio(view.getTxtNome(), "Nome")) {
            return false;
        }
        if (!ValidacaoUtil.validarCampoObrigatorio(view.getTxtGenero(), "Gênero")) {
            return false;
        }
        if (!ValidacaoUtil.validarData(view.getFmtDatanascimento(), "Data de Nascimento")) {
            return false;
        }
        if (!ValidacaoUtil.validarCPF(view.getFmtCpf())) {
            return false;
        }
        if (!ValidacaoUtil.validarEmail(view.getTxtEmail2())) {
            return false;
        }
        if (!ValidacaoUtil.validarCampoObrigatorio(view.getTxtUsuario(), "Usuário")) {
            return false;
        }
        if (!ValidacaoUtil.validarForcaSenha(view.getSenha())) {
            return false;
        }
        if (!ValidacaoUtil.validarCampoObrigatorio(view.getTxtRua(), "Rua")) {
            return false;
        }
        if (!ValidacaoUtil.validarCampoObrigatorio(view.getTxtNumero(), "Número")) {
            return false;
        }
        if (!ValidacaoUtil.validarCampoObrigatorio(view.getTxtBairro(), "Bairro")) {
            return false;
        }
        if (!ValidacaoUtil.validarCampoObrigatorio(view.getTxtCidade(), "Cidade")) {
            return false;
        }
        if (!ValidacaoUtil.validarCampoObrigatorio(view.getTxtEstado(), "Estado")) {
            return false;
        }
        if (!ValidacaoUtil.validarCampoObrigatorio(view.getFmtCep(), "CEP")) {
            return false;
        }

        return true;
    }

    private void tratarErroSQL(SQLException e) {
        String mensagem;

        // Verificar códigos de erro específicos
        if (e.getErrorCode() == 1062) { // Código de erro para entrada duplicada no MySQL
            if (e.getMessage().contains("usuario.usuario")) {
                mensagem = "Nome de usuário já existe! Escolha outro.";
                view.getTxtUsuario().requestFocus();
            } else if (e.getMessage().contains("pessoa.cpf")) {
                mensagem = "CPF já cadastrado!";
                view.getFmtCpf().requestFocus();
            } else {
                mensagem = "Dado duplicado: " + e.getMessage();
            }
        } else {
            mensagem = "Erro ao acessar o banco de dados: " + e.getMessage();
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
