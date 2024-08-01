package br.com.pratica.model;

import java.util.List;

public record DisciplinaPutDTO (String nome, List<DependenciaDTO> listaDeProfessores){
}
