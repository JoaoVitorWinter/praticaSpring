package br.com.pratica.model;

import java.util.List;

public record EscolaDTO(String nome, DependenciaDTO endereco, String email, List<DependenciaDTO> listaDeCursos) {
}
