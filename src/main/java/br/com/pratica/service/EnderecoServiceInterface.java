package br.com.pratica.service;

import br.com.pratica.model.Endereco;
import br.com.pratica.model.EnderecoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface EnderecoServiceInterface {
    Endereco criarEndereco(EnderecoDTO enderecoDTO);

    List<Endereco> buscarTodosEnderecos();

    Endereco editarEndereco(Long id, EnderecoDTO enderecoDTO);

    Endereco buscarEndereco(Long id) throws NoSuchElementException;

    String deletarEndereco(Long id) throws NoSuchElementException;
}
