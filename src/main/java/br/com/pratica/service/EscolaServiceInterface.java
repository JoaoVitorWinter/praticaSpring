package br.com.pratica.service;

import br.com.pratica.model.Escola;
import br.com.pratica.model.EscolaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface EscolaServiceInterface {
    Escola criarEscola(EscolaDTO escolaDTO);

    List<Escola> buscarTodasEscolas();

    Escola editarEscola(Long id, EscolaDTO escolaDTO);

    Escola buscarEscola(Long id) throws NoSuchElementException;

    String deletarEscola(Long id) throws NoSuchElementException;
}
