package repositorio;

import entidade.Paciente;
import erro.EntidadeNaoEncontradaException;
import java.util.*;

/**
 * Implementação de repositório para a entidade Paciente utilizando HashMap como armazenamento.
 * Oferece operações básicas de CRUD com controle de IDs automático.
 */
public class PacienteRepository {

    // Estrutura de armazenamento: Mapa onde:
    // - Chave: Integer (ID do paciente)
    // - Valor: Objeto Paciente
    private Map<Integer, Paciente> pacientes = new HashMap<>();

    // Contador para geração sequencial de IDs
    // Inicia em 1 para evitar IDs zero (considerado como "não definido")
    private int idContador = 1;

    /**
     * Salva um paciente no repositório.
     * Se o paciente não possuir ID (ID = 0), gera um novo ID automaticamente.
     * Caso já possua ID, atualiza o registro existente.
     * @param paciente O paciente a ser salvo/atualizado
     * @return O paciente salvo, agora com ID válido
     */
    public Paciente salvar(Paciente paciente) {
        if (paciente.getId() == 0) { // Verifica se é um novo paciente
            paciente.setId(idContador++); // Atribui novo ID e incrementa contador
        }
        pacientes.put(paciente.getId(), paciente); // Insere ou atualiza no mapa
        return paciente;
    }

    /**
     * Atualiza um paciente existente no repositório.
     * Lança exceção se o paciente não for encontrado.
     * @param paciente O paciente com os dados atualizados
     * @return O paciente atualizado
     * @throws EntidadeNaoEncontradaException Se o paciente não existir
     */
    public Paciente atualizar(Paciente paciente) {
        if (!pacientes.containsKey(paciente.getId())) {
            throw new EntidadeNaoEncontradaException("Paciente com ID " + paciente.getId() + " não encontrado.");
        }
        pacientes.put(paciente.getId(), paciente); // Sobrescreve o paciente existente
        return paciente;
    }

    /**
     * Busca um paciente pelo seu ID.
     * @param id ID do paciente a ser buscado
     * @return Optional contendo o paciente encontrado ou vazio se não existir
     */
    public Optional<Paciente> buscarPorId(int id) {
        return Optional.ofNullable(pacientes.get(id)); // Retorna Optional para evitar null
    }

    /**
     * Retorna uma lista com todos os pacientes cadastrados.
     * @return Lista contendo todos os pacientes (cópia da coleção original)
     */
    public List<Paciente> buscarTodos() {
        return new ArrayList<>(pacientes.values()); // Retorna cópia para segurança
    }

    /**
     * Remove um paciente do repositório pelo seu ID.
     * Não lança exceção se o ID não existir (comportamento padrão do HashMap).
     * @param id ID do paciente a ser removido
     */
    public void deletar(int id) {
        pacientes.remove(id); // Remove se existir, caso contrário não faz nada
    }
}