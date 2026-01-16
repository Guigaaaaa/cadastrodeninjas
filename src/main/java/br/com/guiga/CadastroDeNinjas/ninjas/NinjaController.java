package br.com.guiga.CadastroDeNinjas.ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);

        if (ninja == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID (" + id + ") não encontrado");
        }

        return ResponseEntity.ok(ninja);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.listarNinjasPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID (" + id + ") não encontrado");
        }

        NinjaDTO ninjaAlterado = ninjaService.atualizarNinja(id, ninjaAtualizado);
        return ResponseEntity.ok("Ninja com o ID (" + id + ") alterado com sucesso");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID (" + id + ") deletado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID (" + id + ") não encontrado");
    }

}
