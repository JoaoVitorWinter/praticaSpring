package br.com.pratica.model;

import java.util.List;

public record TurmaDTO(String nome, DependenciaDTO escola, List<DependenciaDTO> listaDeAlunos) {
}
