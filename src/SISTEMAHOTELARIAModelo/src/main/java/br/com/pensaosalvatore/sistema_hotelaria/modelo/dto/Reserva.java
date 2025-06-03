package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Érica_Almeida
 */
public class Reserva {

    private Integer id;
    private Hospede hospede;
    private Quarto quarto;
    private Date data_entrada;
    private Date data_saida;
    private BigDecimal valor;
    private String observacoes;

    public Reserva() {
    }

    public Reserva(Integer id, Hospede hospede, Quarto quarto, BigDecimal valor, String data_entrada, String data_saida) {
        this.id = id;
        this.hospede = hospede;
        this.quarto = quarto;
        this.valor = valor;
        try {
            this.data_entrada = new SimpleDateFormat("dd/MM/yyyy").parse(data_entrada);
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.data_saida = new SimpleDateFormat("dd/MM/yyyy").parse(data_saida);
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getDataEntradaFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy").format(data_entrada);
    }

    public String getDataSaidaFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy").format(data_saida);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
