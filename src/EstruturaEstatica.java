public class EstruturaEstatica<T> {
    public Pessoa[][] elementos;
    public int tamanho;

    public EstruturaEstatica(int capacidade, int colunas) {
        this.elementos = new Pessoa[capacidade][colunas];
        this.tamanho = 0;
    }

    public EstruturaEstatica() {
        this(10, 2);
    }

    public boolean adiciona(Pessoa elemento) { // Modifique o tipo de T para Pessoa
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            for (int i = 0; i < 2; i++) {
                this.elementos[this.tamanho][i] = elemento;
            }
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(int posicao, int colunas, Pessoa elemento) { // Modifique o tipo de T para Pessoa
        if (!(posicao >= 0 && posicao <= this.tamanho)) {
            throw new IllegalArgumentException("Posição Inválida" + posicao);
        }
        this.aumentaCapacidade();

        for (int i = this.tamanho - 1; i >= posicao; i--) {
            for (int j = colunas - 1; j >= 0; j--) {
                this.elementos[i + 1][j] = this.elementos[i][j];
            }
        }
        this.elementos[posicao][colunas] = elemento;
        this.tamanho++;

        return true;
    }

    public void aumentaCapacidade() {
        if(this.tamanho == this.elementos.length) {
            int novaCapacidade = this.elementos.length * 2;
            Pessoa[][] elementosNovos = new Pessoa[novaCapacidade][2];

            for(int i = 0; i < this.tamanho; i++) {
                for (int j = 0; j < 2; j++) {
                    elementosNovos[i][j] = this.elementos[i][j];
                }
            }
            this.elementos = elementosNovos;
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");

        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < 2; j++) {
                s.append(this.elementos[i][j]);
                if (i < this.tamanho - 1 || j < 1) {
                    s.append(", ");
                }
            }
        }

        s.append("]");

        return s.toString();
    }
    public boolean estaVazia() {
        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < 2; j++) {
                if (this.elementos[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public Pessoa remove(int posicao, int coluna) {
        if(!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição Inválida");
        }

        Pessoa elementoRemovido = this.elementos[posicao][0];

        for(int i = 0; i < coluna; i ++) {
            for (int j = posicao; j < tamanho; j++) {
                elementos[j][i] = elementos[j + 1][i];
            }
        }

        this.tamanho--;

        return elementoRemovido;
    }
}