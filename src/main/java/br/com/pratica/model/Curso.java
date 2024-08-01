package br.com.pratica.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    private String nome;
    @ManyToMany
    @JoinTable(name = "curso_disciplina",
            joinColumns = @JoinColumn(nullable = false, name = "curso_id"),
    inverseJoinColumns = @JoinColumn(nullable = false, name ="disciplina_id"))
    private List<Disciplina> listaDeDisciplinas;

    public Curso(CursoDTO cursoDTO) {
        this.dtoParaCurso(cursoDTO);
    }

    public Curso(Long id, CursoDTO cursoDTO) {
        this.id = id;
        this.dtoParaCurso(cursoDTO);
    }

    private void dtoParaCurso(CursoDTO cursoDTO) {
        this.nome = cursoDTO.nome();
        this.listaDeDisciplinas = cursoDTO.listaDeDisciplinas().stream().map(dependenciaDTO -> {
            return new Disciplina(dependenciaDTO.id());
        }).toList();

    }

}
