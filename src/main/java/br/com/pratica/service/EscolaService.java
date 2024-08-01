package br.com.pratica.service;

import br.com.pratica.model.Escola;
import br.com.pratica.model.EscolaDTO;
import br.com.pratica.repository.EscolaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EscolaService implements EscolaServiceInterface {
    private EscolaRepository repository;

    @Override
    public Escola criarEscola(EscolaDTO escolaDTO) {
        Escola escola = new Escola(escolaDTO);
        return repository.save(escola);
    }

    @Override
    public List<Escola> buscarTodasEscolas() {
        return repository.findAll();
    }

    @Override
    public Escola editarEscola(Long id, EscolaDTO escolaDTO) {
        Escola escola = new Escola(id, escolaDTO);
        return repository.save(escola);
    }

    @Override
    public Escola buscarEscola(Long id) throws NoSuchElementException {
        Optional<Escola> escolaOptional = repository.findById(id);
        return escolaOptional.get();
    }

    @Override
    public String deletarEscola(Long id) throws NoSuchElementException {
        Optional<Escola> escolaOptional = repository.findById(id);
        if (escolaOptional.isPresent()) {
            repository.deleteById(id);
            return "Deletado";
        }

        throw new NoSuchElementException();
    }
}
