package entidade;

public class Medico {

    private int id;
    private String nome;
    private String especialidade;

    /**
     * Construtor da classe Medico.
     * Ele serve para inicializar os atributos do objeto, ou seja, definir os valores iniciais que esse objeto terá
     */
    public Medico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    // ==================== GETTERS ====================
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    // ==================== SETTERS ====================
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    // ==================== MÉTODO toString ====================

    /**
     * Retorna uma representação textual do médico.
     * Útil para impressão no console ou debug.
     */
    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
