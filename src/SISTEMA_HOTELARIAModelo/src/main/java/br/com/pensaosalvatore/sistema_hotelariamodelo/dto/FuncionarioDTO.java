/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Estado;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.EstadoCivil;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.GraudeAcesso;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.RegimedeContratacao;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusFuncionario;
import java.util.Date;

/**
 *
 * @author 202412170006
 */
public class FuncionarioDTO extends EnderecoDTO{
    private Integer id;
    
    private String nome;
    
    private String sobrenome;
    
    private Date datadenascimento;
    
    private String cpf;
    
    private Integer rg;
    
    private EstadoCivil estadocivil;

    private String naturalidade;
    
    private Genero genero;
    
    private String nomedamae;
    
    private String nomedopai;
    
    private String cep;
    
    private String rua;
    
    private Integer numero;
    
    private String complemento;
    
    private String bairro;
    
    private Estado estado;
    
    private String email;
    
    private String celular;
    
    //private ? whatsapp;
    
    private String fixo;
    
    private Integer matricula;
    
    //private ? cargo;
    
    //private ? departamento;
    
    private Date datadeadmissao;
    
    private String jornadadetrabalho;
    
    private RegimedeContratacao regimedecontratacao;
    
    private StatusFuncionario status;
    
    private Integer salariobase;
    
    private String numerodopis;
    
    private String ctps;
    
    private String observacoesgerais;
    
    private String historico;
    
    private String comentariosdagestao;
    
    private String nomeusuario;
    
    private String senha;
    
    private GraudeAcesso graudeacesso;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Integer id, String nome, String sobrenome, Date datadenascimento, String cpf, Integer rg, EstadoCivil estadocivil, String naturalidade, Genero genero, String nomedamae, String nomedopai, String cep, String rua, Integer numero, String complemento, String bairro, Estado estado, String email, String celular, String fixo, Integer matricula, Date datadeadmissao, String jornadadetrabalho, RegimedeContratacao regimedecontratacao, StatusFuncionario status, Integer salariobase, String numerodopis, String ctps, String observacoesgerais, String historico, String comentariosdagestao, String nomeusuario, String senha, GraudeAcesso graudeacesso) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.datadenascimento = datadenascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.estadocivil = estadocivil;
        this.naturalidade = naturalidade;
        this.genero = genero;
        this.nomedamae = nomedamae;
        this.nomedopai = nomedopai;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
        this.email = email;
        this.celular = celular;
        this.fixo = fixo;
        this.matricula = matricula;
        this.datadeadmissao = datadeadmissao;
        this.jornadadetrabalho = jornadadetrabalho;
        this.regimedecontratacao = regimedecontratacao;
        this.status = status;
        this.salariobase = salariobase;
        this.numerodopis = numerodopis;
        this.ctps = ctps;
        this.observacoesgerais = observacoesgerais;
        this.historico = historico;
        this.comentariosdagestao = comentariosdagestao;
        this.nomeusuario = nomeusuario;
        this.senha = senha;
        this.graudeacesso = graudeacesso;
    }
    
    
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDatadenascimento() {
        return datadenascimento;
    }

    public void setDatadenascimento(Date datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public EstadoCivil getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(EstadoCivil estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNomedamae() {
        return nomedamae;
    }

    public void setNomedamae(String nomedamae) {
        this.nomedamae = nomedamae;
    }

    public String getNomedopai() {
        return nomedopai;
    }

    public void setNomedopai(String nomedopai) {
        this.nomedopai = nomedopai;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Date getDatadeadmissao() {
        return datadeadmissao;
    }

    public void setDatadeadmissao(Date datadeadmissao) {
        this.datadeadmissao = datadeadmissao;
    }

    public String getJornadadetrabalho() {
        return jornadadetrabalho;
    }

    public void setJornadadetrabalho(String jornadadetrabalho) {
        this.jornadadetrabalho = jornadadetrabalho;
    }

    public RegimedeContratacao getRegimedecontratacao() {
        return regimedecontratacao;
    }

    public void setRegimedecontratacao(RegimedeContratacao regimedecontratacao) {
        this.regimedecontratacao = regimedecontratacao;
    }

    public StatusFuncionario getStatus() {
        return status;
    }

    public void setStatus(StatusFuncionario status) {
        this.status = status;
    }

    public Integer getSalariobase() {
        return salariobase;
    }

    public void setSalariobase(Integer salariobase) {
        this.salariobase = salariobase;
    }

    public String getNumerodopis() {
        return numerodopis;
    }

    public void setNumerodopis(String numerodopis) {
        this.numerodopis = numerodopis;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getObservacoesgerais() {
        return observacoesgerais;
    }

    public void setObservacoesgerais(String observacoesgerais) {
        this.observacoesgerais = observacoesgerais;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getComentariosdagestao() {
        return comentariosdagestao;
    }

    public void setComentariosdagestao(String comentariosdagestao) {
        this.comentariosdagestao = comentariosdagestao;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public GraudeAcesso getGraudeacesso() {
        return graudeacesso;
    }

    public void setGraudeacesso(GraudeAcesso graudeacesso) {
        this.graudeacesso = graudeacesso;
    }
    
    
}
