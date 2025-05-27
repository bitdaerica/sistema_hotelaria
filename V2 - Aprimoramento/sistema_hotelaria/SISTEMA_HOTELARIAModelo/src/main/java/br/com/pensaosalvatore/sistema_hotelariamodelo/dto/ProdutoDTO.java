
package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Categoria;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Status;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author 202412170006
 */
public class ProdutoDTO {
    private Integer idProduto;    
    private String nome;    
    private String descricao;    
    private Categoria categoria;    
    private String marca;    
    private Integer codbarra;    
    private Integer qtdemestoque;    
    private Integer qtdestoqueminimo;    
    private Integer qtdestoquemaximo;    
    private String localizacaonoestoque;    
    private BigDecimal precocusto;    
    private BigDecimal precovenda;    
    private BigDecimal desconto;      
    private String fornecedor;    
    private Date datadefabricacao;    
    private Date datadevalidade;    
    private Double garantia;    
    private Status status;    
    private String observacoes;
    
    public ProdutoDTO() {
    }

    public ProdutoDTO(Integer idProduto, String nome, String descricao, Categoria categoria, String marca, Integer codbarra, Integer qtdemestoque, Integer qtdestoqueminimo, Integer qtdestoquemaximo, String localizacaonoestoque, BigDecimal precocusto, BigDecimal precovenda, BigDecimal desconto, String fornecedor, Date datadefabricacao, Date datadevalidade, Double garantia, Status status, String observacoes) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.marca = marca;
        this.codbarra = codbarra;
        this.qtdemestoque = qtdemestoque;
        this.qtdestoqueminimo = qtdestoqueminimo;
        this.qtdestoquemaximo = qtdestoquemaximo;
        this.localizacaonoestoque = localizacaonoestoque;
        this.precocusto = precocusto;
        this.precovenda = precovenda;
        this.desconto = desconto;
        this.fornecedor = fornecedor;
        this.datadefabricacao = datadefabricacao;
        this.datadevalidade = datadevalidade;
        this.garantia = garantia;
        this.status = status;
        this.observacoes = observacoes;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCodbarra() {
        return codbarra;
    }

    public void setCodbarra(Integer codbarra) {
        this.codbarra = codbarra;
    }

    public Integer getQtdemestoque() {
        return qtdemestoque;
    }

    public void setQtdemestoque(Integer qtdemestoque) {
        this.qtdemestoque = qtdemestoque;
    }

    public Integer getQtdestoqueminimo() {
        return qtdestoqueminimo;
    }

    public void setQtdestoqueminimo(Integer qtdestoqueminimo) {
        this.qtdestoqueminimo = qtdestoqueminimo;
    }

    public Integer getQtdestoquemaximo() {
        return qtdestoquemaximo;
    }

    public void setQtdestoquemaximo(Integer qtdestoquemaximo) {
        this.qtdestoquemaximo = qtdestoquemaximo;
    }

    public String getLocalizacaonoestoque() {
        return localizacaonoestoque;
    }

    public void setLocalizacaonoestoque(String localizacaonoestoque) {
        this.localizacaonoestoque = localizacaonoestoque;
    }

    public BigDecimal getPrecocusto() {
        return precocusto;
    }

    public void setPrecocusto(BigDecimal precocusto) {
        this.precocusto = precocusto;
    }

    public BigDecimal getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(BigDecimal precovenda) {
        this.precovenda = precovenda;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDatadefabricacao() {
        return datadefabricacao;
    }

    public void setDatadefabricacao(Date datadefabricacao) {
        this.datadefabricacao = datadefabricacao;
    }

    public Date getDatadevalidade() {
        return datadevalidade;
    }

    public void setDatadevalidade(Date datadevalidade) {
        this.datadevalidade = datadevalidade;
    }

    public Double getGarantia() {
        return garantia;
    }

    public void setGarantia(Double garantia) {
        this.garantia = garantia;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}