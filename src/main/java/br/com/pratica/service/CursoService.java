package br.com.pratica.service;

import br.com.pratica.model.Curso;
import br.com.pratica.model.CursoDTO;
import br.com.pratica.model.Endereco;
import br.com.pratica.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CursoService implements CursoServiceInterface {
    private CursoRepository repository;

    @Override
    public Curso criarCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso(cursoDTO);
        return repository.save(curso);
    }

    @Override
    public List<Curso> buscarTodosCursos() {
        return repository.findAll();
    }

    @Override
    public Curso editarCurso(Long id, CursoDTO cursoDTO) {
        Curso curso = new Curso(id, cursoDTO);
        return repository.save(curso);
    }

    @Override
    public Curso buscarCurso(Long id) throws NoSuchElementException {
        Optional<Curso> cursoOptional = repository.findById(id);
        return cursoOptional.get();
    }

    @Override
    public String deletarCurso(Long id) throws NoSuchElementException {
        Optional<Curso> cursoOptional = repository.findById(id);
        if (cursoOptional.isPresent()) {
            repository.deleteById(id);
            return "Deletado";
        }

        throw new NoSuchElementException();
    }
}
