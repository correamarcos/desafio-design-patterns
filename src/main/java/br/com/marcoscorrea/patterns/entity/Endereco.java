package br.com.marcoscorrea.patterns.entity;

import br.com.marcoscorrea.patterns.dto.endereco.EnderecoResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public Endereco(EnderecoResponseDTO dto) {
        this.id = dto.id();
        this.cep = dto.cep();
        this.numero = dto.numero();
        this.complemento = dto.logradouro();
    }
}
