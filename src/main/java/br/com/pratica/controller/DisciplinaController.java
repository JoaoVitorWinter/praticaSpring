package br.com.pratica.controller;

import br.com.pratica.model.*;
import br.com.pratica.service.DisciplinaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    private DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<Disciplina> criarDisciplina(@RequestBody DisciplinaPostDTO disciplinaDTO) {
        try {
            return ResponseEntity.ok(disciplinaService.criarDisciplina(disciplinaDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> buscarTodasDisciplinas() {
        try {
            return ResponseEntity.ok(disciplinaService.buscarTodasDisciplinas());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> editarDisciplina(@PathVariable Long id, @RequestBody DisciplinaPutDTO disciplinaDTO) {
        try {
            return ResponseEntity.ok(disciplinaService.editarDisciplina(id, disciplinaDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarDisciplina(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(disciplinaService.buscarDisciplina(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarDisciplina(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(disciplinaService.deletarDisciplina(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
