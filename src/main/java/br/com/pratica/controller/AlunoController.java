package br.com.pratica.controller;

import br.com.pratica.model.Aluno;
import br.com.pratica.model.AlunoDTO;
import br.com.pratica.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody AlunoDTO alunoDTO) {
        try {
            return ResponseEntity.ok(alunoService.criarAluno(alunoDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> buscarTodosAlunos() {
        try {
            return ResponseEntity.ok(alunoService.buscarTodosAlunos());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> editarAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        try {
            return ResponseEntity.ok(alunoService.editarAluno(id, alunoDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAluno(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(alunoService.buscarAluno(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAluno(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(alunoService.deletarAluno(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
