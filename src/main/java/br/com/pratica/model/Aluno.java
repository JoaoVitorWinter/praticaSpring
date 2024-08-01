package br.com.pratica.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @OneToOne
    @JoinColumn(nullable = false)
    private Endereco endereco;

    public Aluno(AlunoDTO alunoDTO) {
        this.dtoParaAluno(alunoDTO);
    }

    public Aluno(Long id, AlunoDTO alunoDTO) {
        this.id = id;
        this.dtoParaAluno(alunoDTO);
    }

    private void dtoParaAluno(AlunoDTO alunoDTO) {
        this.nome = alunoDTO.nome();
        this.email = alunoDTO.email();
        this.telefone = alunoDTO.telefone();
        this.endereco = new Endereco(alunoDTO.endereco().id());
    }
}
