package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import java.util.Date;

/**
 *
 * @author 202412170006
 */
public class Hospede {
    private Integer id;
    
    private String nome;
    
    private String sobrenome;
    
    private Genero genero;
    
    //private ? cpf;
    
    private Date datadenascimento;
    
    //private ? estadocivil;
    
    private String naturalidade;
       
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
        
}
