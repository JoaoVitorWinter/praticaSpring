package br.com.pratica.service;

import br.com.pratica.model.Professor;
import br.com.pratica.model.ProfessorDTO;
import br.com.pratica.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProfessorService implements ProfessorServiceInterface{
    private ProfessorRepository repository;

    @Override
    public Professor criarProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor(professorDTO);
        return repository.save(professor);
    }

    @Override
    public List<Professor> buscarTodosProfessores() {
        return repository.findAll();
    }

    @Override
    public Professor editarProfessor(Long id, ProfessorDTO professorDTO) {
        Professor professor = new Professor(id, professorDTO);
        return repository.save(professor);
    }

    @Override
    public Professor buscarProfessor(Long id) throws NoSuchElementException {
        Optional<Professor> professorOptional = repository.findById(id);
        return professorOptional.get();
    }

    @Override
    public String deletarProfessor(Long id) throws NoSuchElementException {
        Optional<Professor> professorOptional = repository.findById(id);
        if (professorOptional.isPresent()) {
            repository.deleteById(id);
            return "Deletado";
        }

        throw new NoSuchElementException();
    }
}
