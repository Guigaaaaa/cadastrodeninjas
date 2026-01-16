package br.com.guiga.CadastroDeNinjas.missoes;

import br.com.guiga.CadastroDeNinjas.ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "tb_missoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes") // PODE TER VARIOS NINJAS EM UMA MISSÃO
    @JsonIgnore
    private List<NinjaModel> ninjas;

}
