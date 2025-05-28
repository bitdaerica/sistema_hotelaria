package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.GraudeAcesso;

/**
 *
 * @author 202412170006
 */
public class UsuarioDTO extends PessoaDTO {

    private String senha;
    private GraudeAcesso graudeacesso;

    public UsuarioDTO(int par, String nome, String senha) {
    }

    public UsuarioDTO(String senha, GraudeAcesso graudeacesso, Integer id, String nome, Genero genero, String cpf, String email, String celular, Boolean whatsapp, EnderecoDTO endereco) {
        super(id, nome, genero, cpf, email, celular, whatsapp, endereco);
        this.senha = senha;
        this.graudeacesso = graudeacesso;
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
