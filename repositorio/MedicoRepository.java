package repositorio;

import entidade.Medico;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por armazenar e gerenciar os dados dos médicos em memória.
 * Implementa operações básicas de CRUD (Create, Read, Update, Delete).
 */
public class MedicoRepository {

    // Lista em memória para armazenar os médicos cadastrados
    private List<Medico> medicos = new ArrayList<>();

    // Contador para gerar IDs únicos e sequenciais
    private int idContador = 1;

    /**
     * Salva um novo médico no repositório.
     * Atribui um ID automático e adiciona à lista.
     * @param medico O médico a ser cadastrado (sem ID)
     */
    public void salvar(Medico medico) {
        medico.setId(idContador++); // Atribui um novo ID e incrementa o contador
        medicos.add(medico); // Adiciona o médico à lista
    }

    /**
     * Busca um médico pelo seu ID
     * @param id O ID do médico a ser encontrado
     * @return O médico encontrado ou null se não existir
     */
    public Medico buscarPorId(int id) {
        return medicos.stream() // Converte a lista em um Stream para operações funcionais
                .filter(m -> m.getId() == id) // Filtra médicos com o ID especificado
                .findFirst() // Pega o primeiro resultado (se existir)
                .orElse(null); // Retorna null caso não encontre
    }

    /**
     * Retorna uma lista com todos os médicos cadastrados.
     * @return Uma cópia da lista de médicos (para evitar modificações externas)
     */
    public List<Medico> listarTodos() {
        return new ArrayList<>(medicos); // Retorna uma cópia para evitar alterações indesejadas
    }

    /**
     * Atualiza os dados de um médico existente
     * @param medico O médico com os novos dados (deve conter um ID válido)
     */
    public void atualizar(Medico medico) {
        Medico existente = buscarPorId(medico.getId()); // Busca o médico pelo ID

        // Se encontrou, atualiza nome e especialidade
        if (existente != null) {
            existente.setNome(medico.getNome());
            existente.setEspecialidade(medico.getEspecialidade());
        }
    }

    /**
     * Remove um médico da lista.
     * @param medico O médico a ser removido (identificado pelo ID)
     */
    public void deletar(Medico medico) {
        medicos.removeIf(m -> m.getId() == medico.getId()); // Remove se o ID corresponder
    }
}