package br.com.pratica.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    private String nome;
    @OneToOne
    @JoinColumn(nullable = false)
    private Endereco endereco;
    private String email;
    @OneToMany(mappedBy = "escola")
    private List<Professor> listaDeProfessores;
    @ManyToMany
    @JoinTable(name = "escola_curso",
    joinColumns = @JoinColumn(nullable = false, name = "escola_id"),
    inverseJoinColumns = @JoinColumn(nullable = false, name = "curso_id"))
    private List<Curso> listaDeCursos;

    public Escola(EscolaDTO escolaDTO) {
        this.dtoParaEscola(escolaDTO);
    }

    public Escola(Long id, EscolaDTO escolaDTO) {
        this.id = id;
        this.dtoParaEscola(escolaDTO);
    }

    private void dtoParaEscola(EscolaDTO escolaDTO) {
        this.nome = escolaDTO.nome();
        this.email = escolaDTO.email();
        this.endereco = new Endereco(escolaDTO.endereco().id());
        this.listaDeCursos = escolaDTO.listaDeCursos().stream().map(dependenciaDTO -> {
            return new Curso(dependenciaDTO.id());
        }).toList();
    }

}
