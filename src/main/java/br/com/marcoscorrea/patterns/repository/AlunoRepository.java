package br.com.marcoscorrea.patterns.repository;

import br.com.marcoscorrea.patterns.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    boolean existsByCpf(String cpf);
}
