public class Pessoa {
    private String nome;
    private boolean prioridade;

    public Pessoa() {
    }

    public Pessoa(String nome, boolean prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    public String toString() {
        return this.nome;
    }
}
