package br.com.pratica.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Escola escola;
    @ManyToMany(mappedBy = "listaDeProfessores")
    private List<Disciplina> listaDeDisciplinas;
    @OneToOne
    @JoinColumn(nullable = false)
    private Endereco endereco;

    public Professor(ProfessorDTO professorDTO) {
        this.dtoParaProfessor(professorDTO);
    }

    public Professor(Long id, ProfessorDTO professorDTO) {
        this.id = id;
        this.dtoParaProfessor(professorDTO);
    }

    private void dtoParaProfessor(ProfessorDTO professorDTO) {
        this.nome = professorDTO.nome();
        this.email = professorDTO.email();
        this.telefone = professorDTO.telefone();
        this.escola = new Escola(professorDTO.escola().id());
        this.endereco = new Endereco(professorDTO.endereco().id());
    }
}
