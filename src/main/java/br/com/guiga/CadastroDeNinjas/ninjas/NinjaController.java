package br.com.guiga.CadastroDeNinjas.ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listarID")
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
