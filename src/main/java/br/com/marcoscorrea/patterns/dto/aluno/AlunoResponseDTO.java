package br.com.marcoscorrea.patterns.dto.aluno;

import br.com.marcoscorrea.patterns.dto.endereco.EnderecoResponseDTO;
import br.com.marcoscorrea.patterns.entity.Aluno;

public record AlunoResponseDTO(Long id, String nome, String cpf, String email, String telefone, EnderecoResponseDTO endereco) {
    public AlunoResponseDTO(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getEmail(),
                aluno.getTelefone(), new EnderecoResponseDTO(aluno.getEndereco()));
    }
}
