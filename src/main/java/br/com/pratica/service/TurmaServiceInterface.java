package br.com.pratica.service;

import br.com.pratica.model.Turma;
import br.com.pratica.model.TurmaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface TurmaServiceInterface {
    Turma criarTurma(TurmaDTO turmaDTO);

    List<Turma> buscarTodasTurmas();

    Turma editarTurma(Long id, TurmaDTO turmaDTO);

    Turma buscarTurma(Long id) throws NoSuchElementException;

    String deletarTurma(Long id) throws NoSuchElementException;
}
