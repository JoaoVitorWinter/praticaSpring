package br.com.pratica.controller;

import br.com.pratica.model.Escola;
import br.com.pratica.model.EscolaDTO;
import br.com.pratica.service.EscolaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/escola")
public class EscolaController {
    private EscolaService escolaService;

    @PostMapping
    public ResponseEntity<Escola> criarEscola(@RequestBody EscolaDTO escolaDTO) {
        try {
            return ResponseEntity.ok(escolaService.criarEscola(escolaDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Escola>> buscarTodasEscolas() {
        try {
            return ResponseEntity.ok(escolaService.buscarTodasEscolas());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escola> editarEscola(@PathVariable Long id, @RequestBody EscolaDTO escolaDTO) {
        try {
            return ResponseEntity.ok(escolaService.editarEscola(id, escolaDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escola> buscarEscola(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(escolaService.buscarEscola(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEscola(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(escolaService.deletarEscola(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
