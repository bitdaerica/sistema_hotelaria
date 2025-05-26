

package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Estado;

/**
 *
 * @author Érica_Almeida
 */
public class PessoaDTO extends EnderecoDTO{
    private Integer id;
    private String email;
    private String fixo;
    private String celular;
    private Boolean whatsapp;
    private String observacoes;
    private EnderecoDTO endereco;

    public PessoaDTO(Integer id, String email, String fixo, String celular, Boolean whatsapp, String observacoes, EnderecoDTO endereco) {
        this.id = id;
        this.email = email;
        this.fixo = fixo;
        this.celular = celular;
        this.whatsapp = whatsapp;
        this.observacoes = observacoes;
        this.endereco = endereco;
    }
    
    

    

    
    
}
