package br.com.marcoscorrea.patterns.controller;

import br.com.marcoscorrea.patterns.dto.aluno.AlunoRequestDTO;
import br.com.marcoscorrea.patterns.dto.aluno.AlunoResponseDTO;
import br.com.marcoscorrea.patterns.service.Implementations.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/aluno")
public class AlunoRestController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> obterTodos() {
        return ResponseEntity.ok(StreamSupport.stream(alunoService.getAll().spliterator(), true)
                .map(AlunoResponseDTO::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(new AlunoResponseDTO(alunoService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> inserir(@RequestBody AlunoRequestDTO aluno) {
        return ResponseEntity.ok(alunoService.criarAluno(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizar(@PathVariable Long id, @RequestBody AlunoRequestDTO aluno) {
        return ResponseEntity.ok(alunoService.atualizarAluno(id, aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
