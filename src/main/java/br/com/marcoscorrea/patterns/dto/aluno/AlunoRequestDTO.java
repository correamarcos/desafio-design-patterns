package br.com.marcoscorrea.patterns.dto.aluno;

import br.com.marcoscorrea.patterns.dto.endereco.EnderecoResponseDTO;
import lombok.NonNull;

public record AlunoRequestDTO(String nome, String cpf, String email, String telefone, @NonNull EnderecoResponseDTO endereco) {
}
