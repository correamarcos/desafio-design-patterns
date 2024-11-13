package br.com.marcoscorrea.patterns.dto.endereco;

import org.springframework.lang.NonNull;

public record EnderecoRequestDTO(Long id, @NonNull String cep, Integer numero, String complemento) {
}
