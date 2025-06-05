package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 *
 * @author Érica_Almeida
 */
public class Reserva {

    private Integer id;
    private LocalDate dataentrada;
    private LocalDate datasaida;
    private BigDecimal valor;
    private String observacoes;
    private int idHospedes;
    private int idQuartos;
    private int idUsuarios;

    public Reserva() {
    }

    public Reserva(Integer id, LocalDate dataentrada, LocalDate datasaida, BigDecimal valor, String observacoes, int idHospedes, int idQuartos, int idUsuarios) {
        this.id = id;
        this.dataentrada = dataentrada;
        this.datasaida = datasaida;
        this.valor = valor;
        this.observacoes = observacoes;
        this.idHospedes = idHospedes;
        this.idQuartos = idQuartos;
        this.idUsuarios = idUsuarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(LocalDate dataentrada) {
        this.dataentrada = dataentrada;
    }

    public LocalDate getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(LocalDate datasaida) {
        this.datasaida = datasaida;
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

    public int getIdHospedes() {
        return idHospedes;
    }

    public void setIdHospedes(int idHospedes) {
        this.idHospedes = idHospedes;
    }

    public int getIdQuartos() {
        return idQuartos;
    }

    public void setIdQuartos(int idQuartos) {
        this.idQuartos = idQuartos;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    
    

}
