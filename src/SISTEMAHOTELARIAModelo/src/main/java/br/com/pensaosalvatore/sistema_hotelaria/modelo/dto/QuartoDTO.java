package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.TipoQuarto;
import java.math.BigDecimal;

/**
 *
 * @author Érica_Almeida
 */
public class QuartoDTO {

    private Integer id;
    private Integer numero;
    private TipoQuarto tipo;
    private BigDecimal valor;
    private String descricao;

    public QuartoDTO() {
    }

    public QuartoDTO(Integer id, Integer numero, TipoQuarto tipo, BigDecimal valor, String descricao) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoQuarto getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuarto tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
