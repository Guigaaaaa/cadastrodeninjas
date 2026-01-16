package br.com.guiga.CadastroDeNinjas.ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    @GetMapping("/todos")
    public String mostrarTodosOsNinjas() {
        return "Mostrar Ninja";
    }

    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId() {
        return "Mostrar Ninja por Id";
    }

    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar Ninja por id";
    }

    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado por id";
    }

}
