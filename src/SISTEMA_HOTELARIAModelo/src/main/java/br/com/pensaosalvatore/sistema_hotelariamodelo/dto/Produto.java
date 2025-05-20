
package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Categoria;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusProduto;
import java.util.Date;

/**
 *
 * @author 202412170006
 */
public class Produto {
    private Integer id;
    
    private String nome;
    
    private String descricao;
    
    private Categoria categoria;
    
    private String marca;
    
    private Integer codbarra;
    
    private Integer qtdemestoque;
    
    private Integer qtdestoqueminimo;
    
    private Integer qtdestoquemaximo;
    
    private String localizacaonoestoque;
    
    private Double precocusto;
    
    private Double precovenda;
    
    private Double desconto;
    
    private Double margemdelucro;
    
    //private ? fornecedor;
    
    private Date datadefabricacao;
    
    private Date datadevalidade;
    
    private Double garantia;
    
    private StatusProduto status;
    
    private String observacoes;
    
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
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

    public Double getPrecocusto() {
        return precocusto;
    }

    public void setPrecocusto(Double precocusto) {
        this.precocusto = precocusto;
    }

    public Double getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(Double precovenda) {
        this.precovenda = precovenda;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getMargemdelucro() {
        return margemdelucro;
    }

    public void setMargemdelucro(Double margemdelucro) {
        this.margemdelucro = margemdelucro;
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

    public StatusProduto getStatus() {
        return status;
    }

    public void setStatus(StatusProduto status) {
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
}
