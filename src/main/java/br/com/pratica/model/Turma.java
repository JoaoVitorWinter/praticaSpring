package br.com.pratica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Escola escola;
    @OneToMany
    @JoinColumn(nullable = true, name = "turma_id")
    private List<Aluno> listaDeAlunos;

    public Turma(TurmaDTO turmaDTO) {
        this.dtoParaTurma(turmaDTO);
    }

    public Turma(Long id, TurmaDTO turmaDTO) {
        this.id = id;
        this.dtoParaTurma(turmaDTO);
    }

    private void dtoParaTurma(TurmaDTO turmaDTO) {
        this.nome = turmaDTO.nome();
        this.escola = new Escola(turmaDTO.escola().id());
        this.listaDeAlunos = turmaDTO.listaDeAlunos().stream().map(dependenciaDTO -> {
            return new Aluno(dependenciaDTO.id());
        }).toList();
    }
}
