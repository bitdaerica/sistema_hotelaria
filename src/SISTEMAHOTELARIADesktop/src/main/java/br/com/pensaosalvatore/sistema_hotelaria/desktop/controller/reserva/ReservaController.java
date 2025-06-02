package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.reserva;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.reserva.ReservaView;

/**
 *
 * @author Érica_Almeida
 */
public class ReservaController {

    private ReservaView view;

    public ReservaController(ReservaView view) {
        this.view = view;
    }

    /**    public void salvarReserva() {
        try {
            String nome = view.getCampoNome().getText();
            if (ValidaHelper.campoVazio(nome)) {
                MensagemHelper.erro("Nome é obrigatório.");
                return;
            }

            ReservaDTO reserva = new ReservaDTO();
            reserva.setHospede(view.getHospedeSelecionado());
            reserva.setQuarto(view.getQuartoSelecionado());
            reserva.setDatadeentrada(DateHelper.stringParaData(view.getCampoEntrada().getText()));
            reserva.setDatadesaida(DateHelper.stringParaData(view.getCampoSaida().getText()));
            reserva.setValor(new BigDecimal(view.getCampoValor().getText()));

            new ReservaDAO().create(reserva);

            MensagemHelper.sucesso("Reserva salva com sucesso!");

        } catch (Exception e) {
            MensagemHelper.erro("Erro ao salvar reserva: " + e.getMessage());
        }
    }
    
    public void atualizaTabela(){
    ReservaDAO reservaDAO = new ReservaDAO();
    ArrayList<ReservaDTO> reservas = reservaDAO.selectALL();
    
    helper.preencherTabela(reservas);
    }
    
    public void atualizaHospede(){
    HospedeDAO hospedeDAO = new HospedeDAO();
    ArrayList<HospedeDTO> hospedes = hospedeDAO.selectALL();
    
    helper.preencherHospede(hospedes);
    
    }
    
    public void atualizaQuarto(){
    QuartoDAO quartoDAO = QuartoDAO();
    ArrayList<QuartoDTO> quartos = quartoDAO.selectALL();
    
    helper.preencherQuartos(quartos);
    }
    
    public void atualizaValor(){
    QuartoDTO quarto = helper.obterQuarto();
    helper.setarValor(quartoDTO.getValor());
     
    }
    
    
    //salvar a reserva
    public void reservar(){
    ReservaDTO reserva = helper.obterModelo();
    new ReservaDAO().insert(reserva);
    
    atualizaTabela();
    helper.limparTela();
    }
    
     


*/ 
}
