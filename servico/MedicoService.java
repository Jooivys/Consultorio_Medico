package servico;

import entidade.Medico;
import erro.EntidadeNaoEncontradaException;
import repositorio.MedicoRepository;

import java.util.List;

/**
 * Serviço responsável pelas operações e regras de negócio relacionadas a médicos.
 * Atua como intermediário entre a camada de apresentação e o repositório.
 */
public class MedicoService {

    // Injeção de dependência do repositório
    private MedicoRepository medicoRepository = new MedicoRepository();

    /**
     * Cadastra um novo médico no sistema.
     *
     * @param nome          Nome completo do médico
     * @param especialidade Área de atuação do médico
     * @return O médico cadastrado com ID gerado
     */
    public Medico cadastrarMedico(String nome, String especialidade) {
        Medico medico = new Medico(nome, especialidade);
        medicoRepository.salvar(medico);
        return medico;
    }

    /**
     * Busca um médico pelo seu ID.
     *
     * @param id ID do médico a ser localizado
     * @return O médico encontrado
     * @throws EntidadeNaoEncontradaException Se o médico não existir
     */
    public Medico buscarMedicoPorId(int id) {
        Medico medico = medicoRepository.buscarPorId(id);
        if (medico == null) {
            throw new EntidadeNaoEncontradaException("Médico com ID " + id + " não encontrado.");
        }
        return medico;
    }

    /**
     * Retorna todos os médicos cadastrados.
     *
     * @return Lista contendo todos os médicos
     */
    public List<Medico> listarMedicos() {
        return medicoRepository.listarTodos();
    }

    /**
     * Atualiza os dados de um médico existente.
     *
     * @param id            ID do médico a ser atualizado
     * @param nome          Novo nome do médico
     * @param especialidade Nova especialidade
     * @throws EntidadeNaoEncontradaException Se o médico não existir
     */
    public void atualizarMedico(int id, String nome, String especialidade) {
        Medico medico = buscarMedicoPorId(id);
        medico.setNome(nome);
        medico.setEspecialidade(especialidade);
        medicoRepository.atualizar(medico);
    }

    /**
     * Remove um médico do sistema.
     *
     * @param id ID do médico a ser removido
     * @throws EntidadeNaoEncontradaException Se o médico não existir
     */
    public void deletarMedico(int id) {
        Medico medico = buscarMedicoPorId(id);
        medicoRepository.deletar(medico);
    }
}