package br.com.pratica.service;

import br.com.pratica.model.Curso;
import br.com.pratica.model.CursoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface CursoServiceInterface {
    Curso criarCurso(CursoDTO cursoDTO);

    List<Curso> buscarTodosCursos();

    Curso editarCurso(Long id, CursoDTO cursoDTO);

    Curso buscarCurso(Long id) throws NoSuchElementException;

    String deletarCurso(Long id) throws NoSuchElementException;
}
