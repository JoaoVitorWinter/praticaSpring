package br.com.pratica.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    private String nome;
    @ManyToMany
    @JoinTable(name = "disciplina_professor",
            joinColumns = @JoinColumn(nullable = false, name = "disciplina_id"),
    inverseJoinColumns = @JoinColumn(nullable = false, name = "professor_id"))
    private List<Professor> listaDeProfessores;

    public Disciplina(DisciplinaPostDTO disciplinaDTO) {
        this.nome = disciplinaDTO.nome();
    }

    public Disciplina(Long id, DisciplinaPutDTO disciplinaDTO) {
        this.id = id;
        this.nome = disciplinaDTO.nome();
        this.listaDeProfessores = disciplinaDTO.listaDeProfessores().stream().map(dependenciaDTO -> {
            return new Professor(dependenciaDTO.id());
        }).toList();
    }
}
