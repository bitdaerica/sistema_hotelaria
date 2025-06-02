package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.usuario;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.usuario.CadUsuarioView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.UsuarioDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.DataUtils;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Endereco;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Pessoa;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Usuario;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica_Almeida
 */
public class CadUsuarioController {

    private final CadUsuarioView view;
    private final UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private Pessoa pessoa;
    private Endereco endereco;
    private Connection Connection;
    private Usuario Usuario;

    
    public CadUsuarioController(CadUsuarioView view, UsuarioDAO usuarioDAO1) throws SQLException {
        this.view = view;
        this.usuarioDAO = new UsuarioDAO();
        this.usuario = new Usuario();
        this.pessoa = new Pessoa();
        this.endereco = new Endereco();
    }

    
    public void salvar() {
        try {
            preencherDadosDoFormulario();

            if (usuario.getId() == null) {
                usuarioDAO.inserirUsuario(usuario);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            } else {
                usuarioDAO.alterarUsuario(usuario);
                JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
            }

            limparCampos();
            novo();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar usuário: " + ex.getMessage());
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }

    
    public void novo() {
        usuario = new Usuario();
        pessoa = new Pessoa();
        endereco = new Endereco();
        limparCampos();
        JOptionPane.showMessageDialog(null, "Pronto para novo cadastro.");
    }

    
    public void cancelar() {
        limparCampos();
        JOptionPane.showMessageDialog(null, "Operação cancelada.");
        view.dispose();
    }

   
    public void limparCampos() {
        view.getTxtNome().setText("");
        view.getTxtUsuario().setText("");
        view.getSenha().setText("");
        view.getTxtEmail2().setText("");
        view.getFmtCpf().setText("");
        view.getFmtCelular().setText("");
        view.getFmtFixo().setText("");
        view.getFmtDatanascimento().setText("");
        view.getTxtGenero().setText("");
        view.getBtnWhatsapp().setSelected(false);
        view.getTxtObservacoes().setText("");
        view.getFmtCep().setText("");
        view.getTxtRua().setText("");
        view.getTxtNumero().setText("");
        view.getTxtBairro().setText("");
        view.getTxtCidade().setText("");
        view.getTxtEstado().setText("");
        view.getTxtComplemento().setText("");
    }

    // para pegar dados da view e preencher os objetos
    private void preencherDadosDoFormulario() {

        // Pessoa
        pessoa.setNome(view.getTxtNome().getText());
        pessoa.setEmail(view.getTxtEmail2().getText());
        pessoa.setCpf(view.getFmtCpf().getText());
        pessoa.setCelular(view.getFmtCelular().getText());
        pessoa.setFixo(view.getFmtFixo().getText());
        pessoa.setDataNascimento(DataUtils.stringParaLocalDate(view.getFmtDatanascimento().getText()));
        pessoa.setGenero(view.getTxtGenero().getText());
        pessoa.setWhatsapp(view.getBtnWhatsapp().isSelected());
        pessoa.setObservacoes(view.getTxtObservacoes().getText());

        // Endereço
        endereco.setCep(view.getFmtCep().getText());
        endereco.setRua(view.getTxtRua().getText());
        endereco.setNumero(view.getTxtNumero().getText());
        endereco.setBairro(view.getTxtBairro().getText());
        endereco.setCidade(view.getTxtCidade().getText());
        endereco.setEstado(view.getTxtEstado().getText());
        endereco.setComplemento(view.getTxtComplemento().getText());

        // Usuário
        usuario.setUsuario(view.getTxtUsuario().getText());
        usuario.setSenha(new String(view.getSenha().getPassword()));
    }
}
