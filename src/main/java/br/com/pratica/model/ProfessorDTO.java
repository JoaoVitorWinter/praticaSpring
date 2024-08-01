package br.com.pratica.model;

public record ProfessorDTO(String nome, String email, String telefone, DependenciaDTO escola, DependenciaDTO endereco) {
}
