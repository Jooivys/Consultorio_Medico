package entidade;

/**
 * Representa um paciente no sistema de saúde.
 * Armazena informações básicas e de contato do paciente.
 */
public class Paciente {

    // ========== ATRIBUTOS ==========
    private int id;           // Identificador único
    private String nome;      // Nome completo
    private String telefone;  // Contato principal

    // ========== CONSTRUTOR ==========

    /**
     * Cria uma nova instância de Paciente.
     * O ID é inicializado como 0 e deve ser definido posteriormente pelo repositório.
     *
     * @param nome     Nome completo do paciente (não pode ser vazio)
     * @param telefone Número para contato (formato livre)
     */
    public Paciente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // ========== GETTERS ==========

    /**
     * @return ID único do paciente (gerado pelo sistema)
     */
    public int getId() {
        return id;
    }

    /**
     * @return Nome completo do paciente
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return Número de telefone para contato
     */
    public String getTelefone() {
        return telefone;
    }

    // ========== SETTERS ==========

    /**
     * Define o ID do paciente (uso restrito ao repositório).
     *
     * @param id Novo identificador único
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atualiza o nome do paciente.
     *
     * @param nome Novo nome completo
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera o número de telefone.
     *
     * @param telefone Novo contato telefônico
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // ========== MÉTODO toString ==========
    /**
     * Retorna uma representação textual padronizada do paciente.
     *
     * @return String no formato:
     * Paciente{id=[id], nome='[nome]', telefone='[telefone]'}
     */
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
