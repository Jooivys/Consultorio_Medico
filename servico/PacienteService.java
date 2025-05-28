package servico;

import entidade.Paciente;
import erro.EntidadeNaoEncontradaException;
import repositorio.PacienteRepository;

import java.util.List;

/**
 * Serviço responsável pelas operações e regras de negócio relacionadas a pacientes.
 * Coordena o acesso ao repositório de pacientes e aplica validações necessárias.
 */
public class PacienteService {

    // Repositório injetado para persistência dos dados
    private final PacienteRepository repository = new PacienteRepository();

    /**
     * Cadastra um novo paciente no sistema.
     *
     * @param nome     Nome completo do paciente
     * @param telefone Telefone para contato
     * @return Paciente cadastrado com ID gerado automaticamente
     */
    public Paciente cadastrarPaciente(String nome, String telefone) {
        Paciente p = new Paciente(nome, telefone);
        return repository.salvar(p);
    }

    /**
     * Busca um paciente pelo ID.
     *
     * @param id ID do paciente a ser localizado
     * @return Paciente encontrado
     * @throws EntidadeNaoEncontradaException Se o paciente não existir
     */
    public Paciente buscarPacientePorId(int id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Paciente não encontrado com ID: " + id));
    }

    /**
     * Retorna todos os pacientes cadastrados.
     *
     * @return Lista contendo todos os pacientes
     */
    public List<Paciente> listarPacientes() {
        return repository.buscarTodos();
    }

    /**
     * Atualiza os dados de um paciente existente.
     *
     * @param id           ID do paciente a ser atualizado
     * @param novoNome     Novo nome do paciente
     * @param novoTelefone Novo telefone do paciente
     * @return Paciente atualizado
     * @throws EntidadeNaoEncontradaException Se o paciente não existir
     */
    public Paciente atualizarPaciente(int id, String novoNome, String novoTelefone) {
        Paciente paciente = buscarPacientePorId(id);
        paciente.setNome(novoNome);
        paciente.setTelefone(novoTelefone);
        return repository.salvar(paciente);
    }

    /**
     * Remove um paciente do sistema.
     *
     * @param id ID do paciente a ser removido
     * @throws EntidadeNaoEncontradaException Se o paciente não existir
     */
    public void deletarPaciente(int id) {
        if (!repository.buscarPorId(id).isPresent()) {
            throw new EntidadeNaoEncontradaException("Paciente não encontrado com ID: " + id);
        }
        repository.deletar(id);
    }
}