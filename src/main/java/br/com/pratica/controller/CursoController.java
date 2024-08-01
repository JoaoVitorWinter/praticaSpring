package br.com.pratica.controller;

import br.com.pratica.model.Curso;
import br.com.pratica.model.CursoDTO;
import br.com.pratica.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/curso")
public class CursoController {
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> criarCurso(@RequestBody CursoDTO cursoDTO) {
        try {
            return ResponseEntity.ok(cursoService.criarCurso(cursoDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Curso>> buscarTodosCursos() {
        try {
            return ResponseEntity.ok(cursoService.buscarTodosCursos());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> editarCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        try {
            return ResponseEntity.ok(cursoService.editarCurso(id, cursoDTO));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarCurso(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(cursoService.buscarCurso(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCurso(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(cursoService.deletarCurso(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.badRequest().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
