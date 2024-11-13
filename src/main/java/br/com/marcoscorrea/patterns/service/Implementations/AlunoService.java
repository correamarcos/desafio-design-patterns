package br.com.marcoscorrea.patterns.service.Implementations;

import br.com.marcoscorrea.patterns.dto.aluno.AlunoRequestDTO;
import br.com.marcoscorrea.patterns.dto.aluno.AlunoResponseDTO;
import br.com.marcoscorrea.patterns.handler.EntityNotFoundException;
import br.com.marcoscorrea.patterns.entity.Endereco;
import br.com.marcoscorrea.patterns.entity.Aluno;
import br.com.marcoscorrea.patterns.repository.EnderecoRepository;
import br.com.marcoscorrea.patterns.repository.AlunoRepository;
import br.com.marcoscorrea.patterns.service.interfaces.BaseService;
import br.com.marcoscorrea.patterns.service.interfaces.ViaCepService;
import org.springframework.stereotype.Service;

@Service
public class AlunoService implements BaseService<Aluno> {

    private final AlunoRepository alunoRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    public AlunoService(AlunoRepository alunoRepository,
                        EnderecoRepository enderecoRepository,
                        ViaCepService viaCepService) {
        this.alunoRepository = alunoRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public Iterable<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno getById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado."));
    }

    @Override
    public void create(Aluno aluno) {
        aluno.setEndereco(resolveStudentAddress(aluno));
        alunoRepository.save(aluno);
    }

    @Override
    public void update(Long id, Aluno aluno) {
        Aluno existingAluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado."));

        aluno.setId(existingAluno.getId());
        aluno.setEndereco(resolveStudentAddress(aluno));
        alunoRepository.save(aluno);
    }

    @Override
    public void delete(Long id) {
        if (!alunoRepository.existsById(id))
            throw new EntityNotFoundException("Aluno não encontrado.");

        alunoRepository.deleteById(id);
    }

    private Endereco resolveStudentAddress(Aluno aluno) {
        Long idEndereco = aluno.getEndereco().getId();
        if (idEndereco != null)
            return enderecoRepository.getReferenceById(idEndereco);

        String cep = aluno.getEndereco().getCep();
        return enderecoRepository.findAddressByCep(cep)
                .orElseGet(() -> {
                    Endereco novoEndereco = viaCepService.searchCep(cep);
                    if(aluno.getEndereco().getNumero() != null) novoEndereco.setNumero(aluno.getEndereco().getNumero());
                    if(aluno.getEndereco().getComplemento() != null) novoEndereco.setComplemento(aluno.getEndereco().getComplemento());

                    return enderecoRepository.save(novoEndereco);
                });
    }

    public AlunoResponseDTO criarAluno(AlunoRequestDTO novoAluno){
        if (alunoRepository.existsByCpf(novoAluno.cpf()))
            throw new RuntimeException("Aluno já cadastrado na base de dados.");

        Aluno aluno = new Aluno(novoAluno);
        create(aluno);
        return new AlunoResponseDTO(aluno);
    }

    public AlunoResponseDTO atualizarAluno(Long id, AlunoRequestDTO alunoAntigo){
        Aluno aluno = new Aluno(alunoAntigo);
        update(id, aluno);
        return new AlunoResponseDTO(aluno);
    }
}

