
package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.CargoFuncionario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.DerpatamentoFuncionario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Estado;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.EstadoCivil;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.GraudeAcesso;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.RegimedeContratacao;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusFuncionario;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author 202412170006
 */
public class FuncionarioDTO extends PessoaDTO{
    
    private Integer idFuncionario;    
    private String nome;    
    private String sobrenome;    
    private Date datadenascimento;
    private String cpf;
    private String rg;    
    private EstadoCivil estadocivil;
    private String naturalidade;    
    private Genero genero;    
    private String nomedamae;    
    private String nomedopai;   
    private String foto;
    private Integer matricula;
    private CargoFuncionario cargo;
    private DerpatamentoFuncionario departamento;
    private Date datadeadmissao;    
    private Integer jornadadetrabalho;    
    private RegimedeContratacao regimedecontratacao;    
    private StatusFuncionario status;    
    private BigDecimal salariobase;    
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

    public FuncionarioDTO(Integer idFuncionario, String nome, String sobrenome, Date datadenascimento, String cpf, String rg, EstadoCivil estadocivil, String naturalidade, Genero genero, String nomedamae, String nomedopai, String foto, Integer matricula, CargoFuncionario cargo, DerpatamentoFuncionario departamento, Date datadeadmissao, Integer jornadadetrabalho, RegimedeContratacao regimedecontratacao, StatusFuncionario status, BigDecimal salariobase, String numerodopis, String ctps, String observacoesgerais, String historico, String comentariosdagestao, String nomeusuario, String senha, GraudeAcesso graudeacesso, Integer idPessoa, String email, String fixo, String celular, Boolean whatsapp, String observacoes, Integer idEndereco, String rua, String numero, String complemento, String bairro, String cidade, Estado estado, String cep) {
        super(idPessoa, email, fixo, celular, whatsapp, observacoes, idEndereco, rua, numero, complemento, bairro, cidade, estado, cep);
        this.idFuncionario = idFuncionario;
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
        this.foto = foto;
        this.matricula = matricula;
        this.cargo = cargo;
        this.departamento = departamento;
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

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public CargoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(CargoFuncionario cargo) {
        this.cargo = cargo;
    }

    public DerpatamentoFuncionario getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DerpatamentoFuncionario departamento) {
        this.departamento = departamento;
    }

    public Date getDatadeadmissao() {
        return datadeadmissao;
    }

    public void setDatadeadmissao(Date datadeadmissao) {
        this.datadeadmissao = datadeadmissao;
    }

    public Integer getJornadadetrabalho() {
        return jornadadetrabalho;
    }

    public void setJornadadetrabalho(Integer jornadadetrabalho) {
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

    public BigDecimal getSalariobase() {
        return salariobase;
    }

    public void setSalariobase(BigDecimal salariobase) {
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

    public void setCep(String cep) {
        this.cep = cep;
    }

}
