package br.com.pratica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
    private String bairro;
    private Long cep;

    public Endereco(EnderecoDTO enderecoDTO) {
        this.dtoParaEndereco(enderecoDTO);
    }

    public Endereco(Long id, EnderecoDTO enderecoDTO) {
        this.id = id;
        this.dtoParaEndereco(enderecoDTO);
    }

    private void dtoParaEndereco(EnderecoDTO enderecoDTO) {
        this.rua = enderecoDTO.rua();
        this.numero = enderecoDTO.numero();
        this.cidade = enderecoDTO.cidade();
        this.estado = enderecoDTO.estado();
        this.bairro = enderecoDTO.bairro();
        this.cep = enderecoDTO.cep();
    }
}
