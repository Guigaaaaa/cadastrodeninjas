package br.com.guiga.CadastroDeNinjas.missoes;

import br.com.guiga.CadastroDeNinjas.ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {
    private long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninjas;
}
