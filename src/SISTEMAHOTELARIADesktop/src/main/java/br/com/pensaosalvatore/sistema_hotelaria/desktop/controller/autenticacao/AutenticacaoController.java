package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.autenticacao;

impor

/**
 *
 * @author Érica_Almeida
 */
public class AutenticacaoController {

    private final AutenticacaoView view;

    public AutenticacaoController(AutenticacaoView view) {
        this.view = view;
    }

    public void entrarNoSistema() {
        System.out.println("Busquei algo do banco de dados");
        
        this.view.exibeMensagem("Entrando");
    }

    
  //  public void buscarUsuario(){
    
    
  //  }

}
