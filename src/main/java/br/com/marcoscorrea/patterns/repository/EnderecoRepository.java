package br.com.marcoscorrea.patterns.repository;

import br.com.marcoscorrea.patterns.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("SELECT e from Endereco e WHERE e.cep = :cep")
    Optional<Endereco> findAddressByCep(String cep);
}
