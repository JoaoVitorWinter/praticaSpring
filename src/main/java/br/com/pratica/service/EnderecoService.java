package br.com.pratica.service;

import br.com.pratica.model.Endereco;
import br.com.pratica.model.EnderecoDTO;
import br.com.pratica.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EnderecoService implements EnderecoServiceInterface {
    private EnderecoRepository repository;

    @Override
    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        return repository.save(endereco);
    }

    @Override
    public List<Endereco> buscarTodosEnderecos() {
        return repository.findAll();
    }

    @Override
    public Endereco editarEndereco(Long id, EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(id, enderecoDTO);
        return repository.save(endereco);
    }

    @Override
    public Endereco buscarEndereco(Long id) throws NoSuchElementException {
        Optional<Endereco> enderecoOptional = repository.findById(id);
        return enderecoOptional.get();
    }

    @Override
    public String deletarEndereco(Long id) throws NoSuchElementException {
        Optional<Endereco> enderecoOptional = repository.findById(id);
        if (enderecoOptional.isPresent()) {
            repository.deleteById(id);
            return "Deletado";
        }

        throw new NoSuchElementException();
    }
}
