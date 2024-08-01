package br.com.pratica.service;

import br.com.pratica.model.Turma;
import br.com.pratica.model.TurmaDTO;
import br.com.pratica.repository.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TurmaService implements TurmaServiceInterface {
    private TurmaRepository repository;

    @Override
    public Turma criarTurma(TurmaDTO turmaDTO) {
        Turma turma = new Turma(turmaDTO);
        return repository.save(turma);
    }

    @Override
    public List<Turma> buscarTodasTurmas() {
        return repository.findAll();
    }

    @Override
    public Turma editarTurma(Long id, TurmaDTO turmaDTO) {
        Turma turma = new Turma(id, turmaDTO);
        return repository.save(turma);
    }

    @Override
    public Turma buscarTurma(Long id) throws NoSuchElementException {
        Optional<Turma> turmaOptional = repository.findById(id);
        return turmaOptional.get();
    }

    @Override
    public String deletarTurma(Long id) throws NoSuchElementException {
        Optional<Turma> turmaOptional = repository.findById(id);
        if (turmaOptional.isPresent()) {
            repository.deleteById(id);
            return "Deletado";
        }

        throw new NoSuchElementException();
    }
}
