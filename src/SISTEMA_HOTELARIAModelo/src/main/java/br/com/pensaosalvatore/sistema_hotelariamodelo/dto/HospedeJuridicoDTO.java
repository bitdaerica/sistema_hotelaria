/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Estado;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.FormadePagamento;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.PrazodeFaturamento;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusHospede;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.TipodeContrato;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Érica_Almeida
 */
public class HospedeJuridicoDTO extends PessoaDTO {
    private Integer id;
    
    private String razaosocial;
    
    private String cnpj;
    
    private String inscricaoestadual;
    
    private StatusHospede status;
    
    private TipodeContrato tipodecontrato; 
    
    private Date datadecadastro;
       
    private String preferenciadecontato;
    
    private String responsavelpeloofaturamento;
        
    private String notasinternas;
    
    private FormadePagamento formadepagamento;
    
    private PrazodeFaturamento prazodefaturamento;
    
    private BigDecimal limetedecredito;
    
    private String interesses;

    
    public HospedeJuridicoDTO() {
    }

    public HospedeJuridicoDTO(Integer id, String razaosocial, String cnpj, String inscricaoestadual, StatusHospede status, TipodeContrato tipodecontrato, Date datadecadastro,
            String preferenciadecontato, String responsavelpeloofaturamento, String notasinternas, FormadePagamento formadepagamento, PrazodeFaturamento prazodefaturamento, BigDecimal limetedecredito, String interesses, Integer idPessoa, String email, String fixo, String celular, Boolean whatsapp, String observacoes, Integer idEndereco, String rua, String numero, String complemento, String bairro, String cidade, Estado estado, String cep) {
        super(idPessoa, email, fixo, celular, whatsapp, observacoes, idEndereco, rua, numero, complemento, bairro, cidade, estado, cep);
        this.id = id;
        this.razaosocial = razaosocial;
        this.cnpj = cnpj;
        this.inscricaoestadual = inscricaoestadual;
        this.status = status;
        this.tipodecontrato = tipodecontrato;
        this.datadecadastro = datadecadastro;
        this.preferenciadecontato = preferenciadecontato;
        this.responsavelpeloofaturamento = responsavelpeloofaturamento;
        this.notasinternas = notasinternas;
        this.formadepagamento = formadepagamento;
        this.prazodefaturamento = prazodefaturamento;
        this.limetedecredito = limetedecredito;
        this.interesses = interesses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public StatusHospede getStatus() {
        return status;
    }

    public void setStatus(StatusHospede status) {
        this.status = status;
    }

    public TipodeContrato getTipodecontrato() {
        return tipodecontrato;
    }

    public void setTipodecontrato(TipodeContrato tipodecontrato) {
        this.tipodecontrato = tipodecontrato;
    }

    public Date getDatadecadastro() {
        return datadecadastro;
    }

    public void setDatadecadastro(Date datadecadastro) {
        this.datadecadastro = datadecadastro;
    }

    public String getPreferenciadecontato() {
        return preferenciadecontato;
    }

    public void setPreferenciadecontato(String preferenciadecontato) {
        this.preferenciadecontato = preferenciadecontato;
    }

    public String getResponsavelpeloofaturamento() {
        return responsavelpeloofaturamento;
    }

    public void setResponsavelpeloofaturamento(String responsavelpeloofaturamento) {
        this.responsavelpeloofaturamento = responsavelpeloofaturamento;
    }

    public String getNotasinternas() {
        return notasinternas;
    }

    public void setNotasinternas(String notasinternas) {
        this.notasinternas = notasinternas;
    }

    public FormadePagamento getFormadepagamento() {
        return formadepagamento;
    }

    public void setFormadepagamento(FormadePagamento formadepagamento) {
        this.formadepagamento = formadepagamento;
    }

    public PrazodeFaturamento getPrazodefaturamento() {
        return prazodefaturamento;
    }

    public void setPrazodefaturamento(PrazodeFaturamento prazodefaturamento) {
        this.prazodefaturamento = prazodefaturamento;
    }

    public BigDecimal getLimetedecredito() {
        return limetedecredito;
    }

    public void setLimetedecredito(BigDecimal limetedecredito) {
        this.limetedecredito = limetedecredito;
    }

    public String getInteresses() {
        return interesses;
    }

    public void setInteresses(String interesses) {
        this.interesses = interesses;
    }

    @Override
    public Integer getIdPessoa() {
        return idPessoa;
    }

    @Override
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getFixo() {
        return fixo;
    }

    @Override
    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    @Override
    public String getCelular() {
        return celular;
    }

    @Override
    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public Boolean getWhatsapp() {
        return whatsapp;
    }

    @Override
    public void setWhatsapp(Boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    @Override
    public String getObservacoes() {
        return observacoes;
    }

    @Override
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public Integer getIdEndereco() {
        return idEndereco;
    }

    @Override
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String getRua() {
        return rua;
    }

    @Override
    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getComplemento() {
        return complemento;
    }

    @Override
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String getBairro() {
        return bairro;
    }

    @Override
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String getCidade() {
        return cidade;
    }

    @Override
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public Estado getEstado() {
        return estado;
    }

    @Override
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String getCep() {
        return cep;
    }

    @Override
    public void setCep(String cep) {
        this.cep = cep;
    }

    
    
    
    
    
    
    
}


