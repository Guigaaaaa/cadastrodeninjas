package br.com.guiga.CadastroDeNinjas.ninjas;

import br.com.guiga.CadastroDeNinjas.missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private MissoesModel missoes;
    private String rank;
}
