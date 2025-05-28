package template;

import entidade.*;
import servico.*;
import erro.EntidadeNaoEncontradaException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Classe responsável pela interface de usuário do sistema médico.
 * Oferece um menu interativo para gestão de pacientes, médicos e consultas.
 */
public class Menu {
    final Scanner sc = new Scanner(System.in);

    private PacienteService pacienteService;
    private MedicoService medicoService;
    private ConsultaService consultaService;

    /**
     * Construtor que inicializa os serviços necessários.
     *
     * @param pacienteService Serviço de gerenciamento de pacientes.
     * @param medicoService   Serviço de gerenciamento de médicos.
     * @param consultaService Serviço de gerenciamento de consultas.
     */
    public Menu(PacienteService pacienteService, MedicoService medicoService, ConsultaService consultaService) {
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
        this.consultaService = consultaService;
    }

    /**
     * Exibe o menu principal do sistema e executa as operações selecionadas.
     */
    public void exibir() {
        int opcao;
        do {
            // Menu de opções
            System.out.println("\n========= MENU =========");
            System.out.println("1  Cadastrar Paciente");
            System.out.println("2  Cadastrar Médico");
            System.out.println("3  Agendar Consulta");
            System.out.println("4  Atualizar Status da Consulta");
            System.out.println("5  Listar Pacientes");
            System.out.println("6  Listar Médicos");
            System.out.println("7  Listar Consultas");
            System.out.println("8  Deletar Paciente");
            System.out.println("9  Deletar Médico");
            System.out.println("10 Deletar Consulta");
            System.out.println("11 Atualizar Médico");
            System.out.println("12 Atualizar Paciente");
            System.out.println("0  Sair");

            // Leitura da opção do usuário
            opcao = lerInteiro(sc, "Escolha uma opção: ");

            // Execução da operação escolhida
            switch (opcao) {
                case 1:
                    // Cadastrar paciente
                    System.out.print("Nome do paciente: ");
                    String nomePaciente = sc.nextLine();
                    System.out.print("Telefone do paciente: ");
                    String telefone = sc.nextLine();
                    Paciente paciente = pacienteService.cadastrarPaciente(nomePaciente, telefone);
                    System.out.println("Paciente cadastrado: " + paciente);
                    break;

                case 2:
                    // Cadastrar médico
                    System.out.print("Nome do médico: ");
                    String nomeMedico = sc.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidade = sc.nextLine();
                    Medico medico = medicoService.cadastrarMedico(nomeMedico, especialidade);
                    System.out.println("Médico cadastrado: " + medico);
                    break;

                case 3:
                    // Agendar consulta
                    int idPaciente = lerInteiro(sc, "ID do paciente: ");
                    int idMedico = lerInteiro(sc, "ID do médico: ");
                    System.out.print("Data e hora (yyyy-MM-dd HH:mm): ");
                    String dataHoraStr = sc.nextLine();
                    try {
                        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                        Consulta consulta = consultaService.agendarConsulta(idPaciente, idMedico, dataHora);
                        System.out.println("Consulta agendada: " + consulta);
                    } catch (EntidadeNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Data e hora inválida. Formato correto: yyyy-MM-dd HH:mm");
                    }
                    break;

                case 4:
                    // Atualizar status da consulta
                    int idConsulta = lerInteiro(sc, "ID da consulta: ");
                    System.out.println("Status (1- AGENDADA, 2- REALIZADA, 3- CANCELADA): ");
                    int opcaoStatus = lerInteiro(sc, "Escolha o status: ");
                    try {
                        Consulta.Status status = switch (opcaoStatus) {
                            case 1 -> Consulta.Status.AGENDADA;
                            case 2 -> Consulta.Status.REALIZADA;
                            case 3 -> Consulta.Status.CANCELADA;
                            default -> throw new IllegalArgumentException("Status inválido.");
                        };
                        consultaService.atualizarStatusConsulta(idConsulta, status);
                        System.out.println("Status atualizado.");
                    } catch (EntidadeNaoEncontradaException | IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 5:
                    // Listar pacientes
                    System.out.println("\n--- Pacientes ---");
                    if (pacienteService.listarPacientes().isEmpty()) {
                        System.out.println("Nenhum paciente cadastrado.");
                    } else {
                        pacienteService.listarPacientes().forEach(System.out::println);
                    }
                    break;

                case 6:
                    // Listar médicos
                    System.out.println("\n--- Médicos ---");
                    if (medicoService.listarMedicos().isEmpty()) {
                        System.out.println("Nenhum médico cadastrado.");
                    } else {
                        medicoService.listarMedicos().forEach(System.out::println);
                    }
                    break;

                case 7:
                    // Listar consultas
                    System.out.println("\n--- Consultas ---");
                    if (consultaService.listarConsultas().isEmpty()) {
                        System.out.println("Nenhuma consulta cadastrada.");
                    } else {
                        consultaService.listarConsultas().forEach(System.out::println);
                    }
                    break;

                case 8:
                    // Deletar paciente
                    int idPacienteDeletar = lerInteiro(sc, "ID do paciente a deletar: ");
                    try {
                        pacienteService.deletarPaciente(idPacienteDeletar);
                        System.out.println("Paciente deletado.");
                    } catch (EntidadeNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 9:
                    // Deletar médico
                    int idMedicoDeletar = lerInteiro(sc, "ID do médico a deletar: ");
                    try {
                        medicoService.deletarMedico(idMedicoDeletar);
                        System.out.println("Médico deletado.");
                    } catch (EntidadeNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 10:
                    // Deletar consulta
                    int idConsultaDeletar = lerInteiro(sc, "ID da consulta a deletar: ");
                    try {
                        consultaService.deletarConsulta(idConsultaDeletar);
                        System.out.println("Consulta deletada.");
                    } catch (EntidadeNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 11:
                    // Atualizar médico
                    int idMedicoAtualizar = lerInteiro(sc, "ID do médico a atualizar: ");
                    System.out.print("Novo nome do médico: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Nova especialidade: ");
                    String novaEspecialidade = sc.nextLine();
                    try {
                        medicoService.atualizarMedico(idMedicoAtualizar, novoNome, novaEspecialidade);
                        System.out.println("Médico atualizado.");
                    } catch (EntidadeNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 12:
                    // Atualizar paciente
                    int idPacienteAtualizar = lerInteiro(sc, "ID do paciente a atualizar: ");
                    System.out.print("Novo nome do paciente: ");
                    String novoNomePaciente = sc.nextLine();
                    System.out.print("Novo telefone do paciente: ");
                    String novoTelefone = sc.nextLine();
                    try {
                        pacienteService.atualizarPaciente(idPacienteAtualizar, novoNomePaciente, novoTelefone);
                        System.out.println("Paciente atualizado.");
                    } catch (EntidadeNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 0:
                    // Encerrar o programa
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }

    /**
     * Método auxiliar para ler valores inteiros de forma segura.
     *
     * @param sc       Scanner utilizado para entrada de dados.
     * @param mensagem Mensagem exibida para o usuário.
     * @return Um número inteiro válido.
     */
    public static int lerInteiro(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }
}
