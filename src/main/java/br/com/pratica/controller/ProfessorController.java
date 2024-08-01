package br.com.pratica.controller;

import br.com.pratica.model.Professor;
import br.com.pratica.model.ProfessorDTO;
import br.com.pratica.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Professor> criarProfessor(@RequestBody ProfessorDTO professorDTO) {
        try {
            return ResponseEntity.ok(professorService.criarProfessor(professorDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Professor>> buscarTodosProfessores() {
        try {
            return ResponseEntity.ok(professorService.buscarTodosProfessores());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> editarProfessor(@PathVariable Long id, @RequestBody ProfessorDTO ProfessorDTO) {
        try {
            return ResponseEntity.ok(professorService.editarProfessor(id, ProfessorDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessor(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(professorService.buscarProfessor(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProfessor(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(professorService.deletarProfessor(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
