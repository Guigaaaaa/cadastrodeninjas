package br.com.guiga.CadastroDeNinjas.missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissao(@PathVariable Long id) {
        MissoesDTO missoesDTO = missoesService.listarMissoesPorId(id);

        if (missoesDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com o ID (" + id + ") não encontrado");
        }

        return ResponseEntity.ok(missoesDTO);
    }

    @PostMapping("criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO missaoNova = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão criada com o ID (" + missaoNova.getId() + ")");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO) {
        if (missoesService.listarMissoesPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com o ID (" + id + ") não encontrada");
        }
        MissoesDTO missaoAtualizada = missoesService.atualizarMissao(id, missoesDTO);
        return ResponseEntity.ok("Missão com o ID (" + id + ") atualizada com sucesso");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        if (missoesService.listarMissoesPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com o ID (" + id + ") não encontrada");
        }

        missoesService.deletarMissaoPorId(id);
        return ResponseEntity.ok("Missão com o ID (" + id + ") deletada com sucesso");
    }
}
