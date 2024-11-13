package br.com.marcoscorrea.patterns.dto.endereco;

import br.com.marcoscorrea.patterns.entity.Endereco;

public record EnderecoResponseDTO(Long id, String cep, String logradouro, Integer numero,
                                  String complemento, String bairro, String localidade, String uf) {
    public EnderecoResponseDTO(Endereco endereco){
        this(endereco.getId(), endereco.getCep(), endereco.getLogradouro(), endereco.getNumero(),
                endereco.getComplemento(), endereco.getBairro(), endereco.getLocalidade(), endereco.getUf());
    }
}
