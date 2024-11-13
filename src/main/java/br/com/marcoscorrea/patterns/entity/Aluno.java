package br.com.marcoscorrea.patterns.entity;

import br.com.marcoscorrea.patterns.dto.aluno.AlunoRequestDTO;
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
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @ManyToOne
    private Endereco endereco;

    public Aluno (AlunoRequestDTO dto){
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.endereco = new Endereco(dto.endereco());
    }
}
