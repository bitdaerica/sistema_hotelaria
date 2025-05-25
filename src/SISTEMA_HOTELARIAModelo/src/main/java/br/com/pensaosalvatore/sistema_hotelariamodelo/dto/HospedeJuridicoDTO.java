/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Estado;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusHospede;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.TipodeContrato;
import java.util.Date;

/**
 *
 * @author Érica_Almeida
 */
public class HospedeJuridicoDTO {
    private Integer id;
    
    private String razaosocial;
    
    private String cnpj;
    
    private String inscricaoestadual;
    
    private StatusHospede status;
    
    private TipodeContrato tipodecontrato; 
    
    private Date datadecadastro;
    
    private String obsevacoes;
    
    private String cep;
    
    private String rua;
    
    private Integer numero;
    
    private String complemento;
    
    private String bairro;
    
    private Estado estado;
    
    private String emailcorporativo;
    
    private String fixo;
    
    private String preferenciadecontato;
    
    private String responsavelpeloofaturamento;
        
    private String celular;
    
    //private ? whatsapp;
    
    private String notasinternas;
    
    //private ? formadepaagmento;
    
    //private ? prazodefaturamento;
    
    private String limetedecredito;
    
    private String interesses;

    public HospedeJuridicoDTO() {
    }

    public HospedeJuridicoDTO(Integer id, String razaosocial, String cnpj, String inscricaoestadual, StatusHospede status, TipodeContrato tipodecontrato, Date datadecadastro, String obsevacoes, String cep, String rua, Integer numero, String complemento, String bairro, Estado estado, String emailcorporativo, String fixo, String preferenciadecontato, String responsavelpeloofaturamento, String celular, String notasinternas, String limetedecredito, String interesses) {
        this.id = id;
        this.razaosocial = razaosocial;
        this.cnpj = cnpj;
        this.inscricaoestadual = inscricaoestadual;
        this.status = status;
        this.tipodecontrato = tipodecontrato;
        this.datadecadastro = datadecadastro;
        this.obsevacoes = obsevacoes;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
        this.emailcorporativo = emailcorporativo;
        this.fixo = fixo;
        this.preferenciadecontato = preferenciadecontato;
        this.responsavelpeloofaturamento = responsavelpeloofaturamento;
        this.celular = celular;
        this.notasinternas = notasinternas;
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

    public String getObsevacoes() {
        return obsevacoes;
    }

    public void setObsevacoes(String obsevacoes) {
        this.obsevacoes = obsevacoes;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getEmailcorporativo() {
        return emailcorporativo;
    }

    public void setEmailcorporativo(String emailcorporativo) {
        this.emailcorporativo = emailcorporativo;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNotasinternas() {
        return notasinternas;
    }

    public void setNotasinternas(String notasinternas) {
        this.notasinternas = notasinternas;
    }

    public String getLimetedecredito() {
        return limetedecredito;
    }

    public void setLimetedecredito(String limetedecredito) {
        this.limetedecredito = limetedecredito;
    }

    public String getInteresses() {
        return interesses;
    }

    public void setInteresses(String interesses) {
        this.interesses = interesses;
    }
    
    
    
    
            
            
}
