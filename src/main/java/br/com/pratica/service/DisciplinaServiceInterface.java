package br.com.pratica.service;

import br.com.pratica.model.Disciplina;
import br.com.pratica.model.DisciplinaPostDTO;
import br.com.pratica.model.DisciplinaPutDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface DisciplinaServiceInterface {
    Disciplina criarDisciplina(DisciplinaPostDTO disciplinaDTO);

    List<Disciplina> buscarTodasDisciplinas();

    Disciplina editarDisciplina(Long id, DisciplinaPutDTO disciplinaDTO);

    Disciplina buscarDisciplina(Long id) throws NoSuchElementException;

    String deletarDisciplina(Long id) throws NoSuchElementException;
}
