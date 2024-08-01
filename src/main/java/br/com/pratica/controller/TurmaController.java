package br.com.pratica.controller;

import br.com.pratica.model.Escola;
import br.com.pratica.model.EscolaDTO;
import br.com.pratica.model.Turma;
import br.com.pratica.model.TurmaDTO;
import br.com.pratica.service.EscolaService;
import br.com.pratica.service.TurmaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/turma")
public class TurmaController {
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<Turma> criarTurma(@RequestBody TurmaDTO turmaDTO) {
        try {
            return ResponseEntity.ok(turmaService.criarTurma(turmaDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Turma>> buscarTodasTurmas() {
        try {
            return ResponseEntity.ok(turmaService.buscarTodasTurmas());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> editarEscola(@PathVariable Long id, @RequestBody TurmaDTO turmaDTO) {
        try {
            return ResponseEntity.ok(turmaService.editarTurma(id, turmaDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarTurma(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(turmaService.buscarTurma(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarTurma(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(turmaService.deletarTurma(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
