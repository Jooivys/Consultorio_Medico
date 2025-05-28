import servico.*;
import template.Menu;

/**
 * Classe principal que inicializa o sistema de gerenciamento de consultório médico.
 *
 * Esta classe cria as instâncias dos serviços necessários para gerir pacientes, médicos
 * e consultas, além de iniciar o menu de interação com o usuário.
 *
 * A execução do programa começa pelo método {@code main}, que instancia os serviços,
 * configura as dependências e chama o método {@code exibir()} do menu para iniciar
 * a interação com o usuário.
 */
public class Main {

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Instanciando os serviços de paciente, médico e consulta
        PacienteService pacienteService = new PacienteService();
        MedicoService medicoService = new MedicoService();
        ConsultaService consultaService = new ConsultaService(pacienteService, medicoService);

        // Criando o menu passando as dependências (injeção manual)
        Menu menu = new Menu(pacienteService, medicoService, consultaService);

        // Iniciando o menu
        menu.exibir();
    }
}
