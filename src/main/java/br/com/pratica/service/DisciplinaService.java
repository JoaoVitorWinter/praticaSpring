package br.com.pratica.service;

import br.com.pratica.model.Disciplina;
import br.com.pratica.model.DisciplinaPostDTO;
import br.com.pratica.model.DisciplinaPutDTO;
import br.com.pratica.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DisciplinaService implements DisciplinaServiceInterface {
    private DisciplinaRepository repository;
    @Override
    public Disciplina criarDisciplina(DisciplinaPostDTO disciplinaDTO) {
        Disciplina disciplina = new Disciplina(disciplinaDTO);
        return repository.save(disciplina);
    }

    @Override
    public List<Disciplina> buscarTodasDisciplinas() {
        return repository.findAll();
    }

    @Override
    public Disciplina editarDisciplina(Long id, DisciplinaPutDTO disciplinaDTO) {
        Disciplina disciplina = new Disciplina(id, disciplinaDTO);
        return repository.save(disciplina);
    }

    @Override
    public Disciplina buscarDisciplina(Long id) throws NoSuchElementException {
        Optional<Disciplina> disciplinaOptional = repository.findById(id);
        return disciplinaOptional.get();
    }

    @Override
    public String deletarDisciplina(Long id) throws NoSuchElementException {
        Optional<Disciplina> disciplinaOptional = repository.findById(id);
        if (disciplinaOptional.isPresent()) {
            repository.deleteById(id);
            return "Deletado";
        }

        throw new NoSuchElementException();
    }
}
