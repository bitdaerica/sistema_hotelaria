

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
public class ReservaDTO {
    private Integer id;
    private HospedeDTO hospede;
    private QuartoDTO quarto;
    private Date datadeentrada;
    private Date datadesaida;
    private BigDecimal valor;
    private String observacoes;

    public ReservaDTO() {
    }

    

    public ReservaDTO(Integer id, HospedeDTO hospede, QuartoDTO quarto,  BigDecimal valor, String datadeentrada, String datadesaida) {
        this.id = id;
        this.hospede = hospede;
        this.quarto = quarto;
        this.valor = valor;
        try {
            this.datadeentrada = new SimpleDateFormat("dd/MM/yyyy").parse(datadeentrada);
        } catch (ParseException ex) {
            Logger.getLogger(ReservaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.datadesaida = new SimpleDateFormat("dd/MM/yyyy").parse(datadesaida);
        } catch (ParseException ex) {
            Logger.getLogger(ReservaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HospedeDTO getHospede() {
        return hospede;
    }

    public void setHospede(HospedeDTO hospede) {
        this.hospede = hospede;
    }

    public QuartoDTO getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoDTO quarto) {
        this.quarto = quarto;
    }

    public Date getDatadeentrada() {
        return datadeentrada;
    }

    public void setDatadeentrada(Date datadeentrada) {
        this.datadeentrada = datadeentrada;
    }

    public Date getDatadesaida() {
        return datadesaida;
    }

    public void setDatadesaida(Date datadesaida) {
        this.datadesaida = datadesaida;
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
