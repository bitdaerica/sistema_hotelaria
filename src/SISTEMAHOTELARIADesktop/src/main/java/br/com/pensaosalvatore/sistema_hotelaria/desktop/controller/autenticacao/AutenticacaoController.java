package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.autenticacao;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.autenticacao.AutenticacaoView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.principal.PrincipalView;
import java.sql.SQLException;

/**
 *
 * @author Érica_Almeida
 */
public class AutenticacaoController {

    private final AutenticacaoView view;

    public AutenticacaoController(AutenticacaoView view) {
        this.view = view;
    }



       

    public void entarnoSistema() throws SQLException {
    }

    public void fizTarefa() {
        System.out.println("Busquei algo do banco de dados");

        this.view.exibeMensagem("Seja Bem-vindo!");
    }
    
    
    public void mostrar(){
           PrincipalView tela = new PrincipalView();
           tela.setVisible(true);

    }

    //  public void buscarUsuario(){
    //  }
}
