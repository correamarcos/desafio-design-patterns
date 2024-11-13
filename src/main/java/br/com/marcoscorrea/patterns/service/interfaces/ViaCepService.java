package br.com.marcoscorrea.patterns.service.interfaces;

import br.com.marcoscorrea.patterns.entity.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Endereco searchCep(@PathVariable("cep") String cep);
}
