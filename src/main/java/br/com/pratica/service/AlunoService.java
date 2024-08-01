package br.com.pratica.service;

import br.com.pratica.model.Aluno;
import br.com.pratica.model.AlunoDTO;
import br.com.pratica.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AlunoService implements AlunoServiceInterface {
    private AlunoRepository repository;

    @Override
    public Aluno criarAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO);
        return repository.save(aluno);
    }

    @Override
    public List<Aluno> buscarTodosAlunos() {
        return repository.findAll();
    }

    @Override
    public Aluno editarAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(id, alunoDTO);
        return repository.save(aluno);
    }

    @Override
    public Aluno buscarAluno(Long id) throws NoSuchElementException {
        Optional<Aluno> alunoOptional = repository.findById(id);
        return alunoOptional.get();
    }

    @Override
    public String deletarAluno(Long id) throws NoSuchElementException {
        Optional<Aluno> alunoOptional = repository.findById(id);
        if (alunoOptional.isPresent()) {
            repository.deleteById(id);
            return "Deletado";
        }

        throw new NoSuchElementException();
    }
}
