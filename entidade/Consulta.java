package entidade;

import java.time.LocalDateTime;

/**
 * Representa uma consulta médica no sistema.
 * Contém informações sobre paciente, médico, data/hora e status da consulta.
 */
public class Consulta {

    /**
     * Define os possíveis estados de uma consulta médica.
     */
    public enum Status {
        AGENDADA,    // Consulta marcada mas não realizada
        REALIZADA,    // Consulta concluída
        CANCELADA     // Consulta cancelada
    }

    // Atributos da entidade
    private int id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;
    private Status status;

    /**
     * Construtor para criação de novas consultas.
     * O status é automaticamente definido como AGENDADA.
     *
     * @param paciente Paciente da consulta
     * @param medico   Médico responsável
     * @param dataHora Data e hora agendadas
     */
    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.status = Status.AGENDADA;  // Status padrão
    }

    // ============= MÉTODOS DE ACESSO (GETTERS) =============

    /**
     * @return ID único da consulta
     */
    public int getId() {
        return id;
    }

    /**
     * @return Data e hora agendadas
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * @return Paciente atendido
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @return Status atual da consulta
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @return Médico responsável
     */
    public Medico getMedico() {
        return medico;
    }

    // ============= MÉTODOS DE MODIFICAÇÃO (SETTERS) =============

    /**
     * Altera o paciente da consulta.
     *
     * @param paciente Novo paciente
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Altera o médico responsável.
     *
     * @param medico Novo médico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Reagenda a data/hora da consulta.
     *
     * @param dataHora Nova data/hora
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Define o ID da consulta (usado pelo repositório).
     *
     * @param id Novo ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atualiza o status da consulta.
     *
     * @param status Novo status (AGENDADA, REALIZADA ou CANCELADA)
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    // ============= REPRESENTAÇÃO TEXTUAL =============

    /**
     * Retorna os dados da consulta formatados como string.
     *
     * @return String formatada com informações da consulta
     */
    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", paciente=" + paciente.getNome() +
                ", medico=" + medico.getNome() +
                ", dataHora=" + dataHora +
                ", status=" + status +
                '}';
    }
}
