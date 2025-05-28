package repositorio;

import entidade.Consulta;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositório responsável pelo armazenamento e gerenciamento de consultas médicas.
 * Implementa operações básicas de CRUD (Create, Read, Update, Delete) em memória.
 */
public class ConsultaRepository {

    // Lista em memória para armazenar todas as consultas
    private List<Consulta> consultas = new ArrayList<>();

    // Contador para gerar IDs únicos e sequenciais para novas consultas
    private int idContador = 1;

    /**
     * Armazena uma nova consulta no repositório.
     * Atribui automaticamente um ID e adiciona à lista de consultas.
     * @param consulta A consulta a ser cadastrada (sem ID definido)
     */
    public void salvar(Consulta consulta) {
        consulta.setId(idContador++); // Atribui ID e incrementa o contador
        consultas.add(consulta);      // Adiciona à lista de consultas
    }

    /**
     * Retorna uma lista com todas as consultas cadastradas.
     * @return Cópia da lista de consultas (para evitar modificações externas)
     */
    public List<Consulta> listarTodos() {
        return new ArrayList<>(consultas); // Retorna cópia defensiva
    }

    /**
     * Busca uma consulta pelo seu ID.
     * @param id ID da consulta a ser localizada
     * @return A consulta encontrada ou null se não existir
     */
    public Consulta buscarPorId(int id) {
        return consultas.stream()           // Converte para Stream
                .filter(c -> c.getId() == id) // Filtra pelo ID
                .findFirst()                // Pega a primeira ocorrência
                .orElse(null);              // Retorna null se não encontrar
    }

    /**
     * Atualiza os dados de uma consulta existente.
     * @param consultaAtualizada Consulta com os novos dados (deve conter ID válido)
     */
    public void atualizar(Consulta consultaAtualizada) {
        for (int i = 0; i < consultas.size(); i++) {
            if (consultas.get(i).getId() == consultaAtualizada.getId()) {
                consultas.set(i, consultaAtualizada); // Substitui a consulta
                return; // Encerra após encontrar e atualizar
            }
        }
    }

    /**
     * Remove uma consulta do repositório.
     * @param consulta Consulta a ser removida (identificada pelo ID)
     */
    public void deletar(Consulta consulta) {
        consultas.removeIf(c -> c.getId() == consulta.getId()); // Remove por ID
    }
}