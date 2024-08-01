package br.com.pratica.model;

import java.util.List;

public record CursoDTO(String nome, List<DependenciaDTO> listaDeDisciplinas) {
}
