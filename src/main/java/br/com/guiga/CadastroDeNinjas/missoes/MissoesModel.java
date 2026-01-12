package br.com.guiga.CadastroDeNinjas.missoes;

import br.com.guiga.CadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;


@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;
    @OneToMany(mappedBy = "missoes") // PODE TER VARIOS NINJAS EM UMA MISSÃO
    private NinjaModel ninjas;

    public MissoesModel() {}

    public MissoesModel(String nome, String dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

}
