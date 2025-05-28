package servico;

import entidade.*;
import erro.EntidadeNaoEncontradaException;
import repositorio.ConsultaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Serviço responsável pela lógica de negócios relacionada a consultas médicas.
 * Coordena operações entre PacienteService, MedicoService e ConsultaRepository.
 */
public class ConsultaService {

    // Dependências necessárias para o serviço
    private ConsultaRepository consultaRepository = new ConsultaRepository();
    private PacienteService pacienteService;
    private MedicoService medicoService;

    /**
     * Construtor com injeção de dependências.
     *
     * @param pacienteService Serviço de pacientes
     * @param medicoService   Serviço de médicos
     */
    public ConsultaService(PacienteService pacienteService, MedicoService medicoService) {
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
    }

    /**
     * Agenda uma nova consulta médica.
     * Valida a existência do paciente e médico antes do agendamento.
     *
     * @param idPaciente ID do paciente
     * @param idMedico   ID do médico
     * @param dataHora   Data e hora da consulta
     * @return A consulta agendada
     * @throws EntidadeNaoEncontradaException Se paciente ou médico não existirem
     */
    public Consulta agendarConsulta(int idPaciente, int idMedico, LocalDateTime dataHora) {
        // Valida existência das entidades relacionadas
        Paciente paciente = pacienteService.buscarPacientePorId(idPaciente);
        Medico medico = medicoService.buscarMedicoPorId(idMedico);

        // Cria e persiste a nova consulta
        Consulta consulta = new Consulta(paciente, medico, dataHora);
        consultaRepository.salvar(consulta);
        return consulta;
    }

    /**
     * Atualiza o status de uma consulta existente.
     *
     * @param idConsulta ID da consulta a ser atualizada
     * @param status     Novo status da consulta
     * @throws EntidadeNaoEncontradaException Se a consulta não for encontrada
     */
    public void atualizarStatusConsulta(int idConsulta, Consulta.Status status) {
        Consulta consulta = buscarConsultaPorId(idConsulta);
        consulta.setStatus(status);
        consultaRepository.atualizar(consulta);
    }

    /**
     * Busca uma consulta pelo seu ID.
     *
     * @param id ID da consulta
     * @return A consulta encontrada
     * @throws EntidadeNaoEncontradaException Se a consulta não existir
     */
    public Consulta buscarConsultaPorId(int id) {
        Consulta consulta = consultaRepository.buscarPorId(id);
        if (consulta == null) {
            throw new EntidadeNaoEncontradaException("Consulta com ID " + id + " não encontrada.");
        }
        return consulta;
    }

    /**
     * Retorna todas as consultas agendadas.
     *
     * @return Lista de consultas
     */
    public List<Consulta> listarConsultas() {
        return consultaRepository.listarTodos();
    }

    /**
     * Remove uma consulta do sistema.
     *
     * @param id ID da consulta a ser removida
     * @throws EntidadeNaoEncontradaException Se a consulta não for encontrada
     */
    public void deletarConsulta(int id) {
        Consulta consulta = buscarConsultaPorId(id);
        consultaRepository.deletar(consulta);
    }
}