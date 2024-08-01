package br.com.pratica.service;

import br.com.pratica.model.Professor;
import br.com.pratica.model.ProfessorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface ProfessorServiceInterface {
    Professor criarProfessor(ProfessorDTO professorDTO);

    List<Professor> buscarTodosProfessores();

    Professor editarProfessor(Long id, ProfessorDTO professorDTO);

    Professor buscarProfessor(Long id) throws NoSuchElementException;

    String deletarProfessor(Long id) throws NoSuchElementException;
}
