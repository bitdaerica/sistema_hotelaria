
package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.CategoriaProduto;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.FormadePagamento;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.PrazodeFaturamento;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Status;
import br.com.pensaosalvatore.sistema_hotelariamodelo.dao.EnderecoDAO;

/**
 *
 * @author 202412170006
 */
public class FornecedorDTO extends EnderecoDAO {
    private Integer idFornecedor;
    private String razaosocial;
    private String cnpj;
    private String inscricaoestadual;
    private Status statusfornecedor;
    private CategoriaProduto categoriaproduto;
    private String datacadastro;
    private String preferenciadecontato;
    private String nomerepresentante;
    private String site;
    private String notasinternas;
    private FormadePagamento formapagamento;
    private PrazodeFaturamento prazodefaturamento;

    public FornecedorDTO() {
    }
    
    

    public FornecedorDTO(Integer idFornecedor, String razaosocial, String cnpj, String inscricaoestadual, Status statusfornecedor, CategoriaProduto categoriaproduto, String datacadastro, String preferenciadecontato, String nomerepresentante, String site, String notasinternas, FormadePagamento formapagamento, PrazodeFaturamento prazodefaturamento) {
        this.idFornecedor = idFornecedor;
        this.razaosocial = razaosocial;
        this.cnpj = cnpj;
        this.inscricaoestadual = inscricaoestadual;
        this.statusfornecedor = statusfornecedor;
        this.categoriaproduto = categoriaproduto;
        this.datacadastro = datacadastro;
        this.preferenciadecontato = preferenciadecontato;
        this.nomerepresentante = nomerepresentante;
        this.site = site;
        this.notasinternas = notasinternas;
        this.formapagamento = formapagamento;
        this.prazodefaturamento = prazodefaturamento;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public Status getStatusfornecedor() {
        return statusfornecedor;
    }

    public void setStatusfornecedor(Status statusfornecedor) {
        this.statusfornecedor = statusfornecedor;
    }

    public CategoriaProduto getCategoriaproduto() {
        return categoriaproduto;
    }

    public void setCategoriaproduto(CategoriaProduto categoriaproduto) {
        this.categoriaproduto = categoriaproduto;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getPreferenciadecontato() {
        return preferenciadecontato;
    }

    public void setPreferenciadecontato(String preferenciadecontato) {
        this.preferenciadecontato = preferenciadecontato;
    }

    public String getNomerepresentante() {
        return nomerepresentante;
    }

    public void setNomerepresentante(String nomerepresentante) {
        this.nomerepresentante = nomerepresentante;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNotasinternas() {
        return notasinternas;
    }

    public void setNotasinternas(String notasinternas) {
        this.notasinternas = notasinternas;
    }

    public FormadePagamento getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(FormadePagamento formapagamento) {
        this.formapagamento = formapagamento;
    }

    public PrazodeFaturamento getPrazodefaturamento() {
        return prazodefaturamento;
    }

    public void setPrazodefaturamento(PrazodeFaturamento prazodefaturamento) {
        this.prazodefaturamento = prazodefaturamento;
    }

    
    
    
    
        
}
