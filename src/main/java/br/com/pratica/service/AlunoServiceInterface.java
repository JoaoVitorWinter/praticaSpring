package br.com.pratica.service;

import br.com.pratica.model.Aluno;
import br.com.pratica.model.AlunoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface AlunoServiceInterface {
    Aluno criarAluno(AlunoDTO alunoDTO);

    List<Aluno> buscarTodosAlunos();

    Aluno editarAluno(Long id, AlunoDTO alunoDTO);

    Aluno buscarAluno(Long id) throws NoSuchElementException;

    String deletarAluno(Long id) throws NoSuchElementException;
}
