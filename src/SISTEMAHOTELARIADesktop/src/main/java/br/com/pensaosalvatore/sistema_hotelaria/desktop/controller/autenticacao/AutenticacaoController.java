package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.autenticacao;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.helper.AutenticacaoHelper;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.autenticacao.AutenticacaoView;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dtoo.UsuarioDTO;

/**
 *
 * @author Érica_Almeida
 */
public class AutenticacaoController {

    private final AutenticacaoView view;
    private AutenticacaoHelper helper;

    public AutenticacaoController(AutenticacaoView view) {
        this.view = view;
        this.helper = new AutenticacaoHelper(view);
    }

    public void entarnoSistema() {
        UsuarioDTO usuario = helper.obterModelo();

    }

    public void fizTarefa() {
        System.out.println("Busquei algo do banco de dados");

        this.view.exibeMensagem("Seja Bem-vindo!");
    }

    //  public void buscarUsuario(){
    //  }
}
