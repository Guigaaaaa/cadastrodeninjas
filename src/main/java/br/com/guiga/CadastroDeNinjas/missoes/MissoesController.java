package br.com.guiga.CadastroDeNinjas.missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarMissao() {
        return missoesService.listarMissoes();
    }

    @PostMapping("criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao) {
        return missoesService.criarMissao(missao);
    }

    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        return missoesService.atualizarMissao(id, missaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
       missoesService.deletarMissaoPorId(id);
    }
}
