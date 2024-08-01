package br.com.pratica.controller;

import br.com.pratica.model.Endereco;
import br.com.pratica.model.EnderecoDTO;
import br.com.pratica.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        try {
            return ResponseEntity.ok(enderecoService.criarEndereco(enderecoDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodosEnderecos() {
        try {
            return ResponseEntity.ok(enderecoService.buscarTodosEnderecos());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> editarEndereco(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
        try {
            return ResponseEntity.ok(enderecoService.editarEndereco(id, enderecoDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(enderecoService.buscarEndereco(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEndereco(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(enderecoService.deletarEndereco(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
