package erro;

/**
 * Exceção personalizada para indicar que uma entidade não foi encontrada no sistema.
 *
 * Esta exceção é utilizada quando uma operação tenta acessar uma entidade
 * (como Paciente, Médico ou Consulta) que não existe no repositório
 */
public class EntidadeNaoEncontradaException extends RuntimeException {

    /**
     * Construtor que recebe uma mensagem personalizada para a exceção.
     *
     * @param msg Mensagem explicando qual entidade não foi encontrada.
     */
    public EntidadeNaoEncontradaException(String msg) {
        super(msg);
    }
}
