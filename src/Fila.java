import java.util.Arrays;

public class Fila<T> extends EstruturaEstatica<T>{
    private int contadorPrioritarios; // Contador para controlar as chamadas de pessoas normais

    public Fila() {
        super();
        this.contadorPrioritarios = 0;
    }

    public Fila(int capacidade, int colunas) {
        super(capacidade, colunas);
        this.contadorPrioritarios = 0;
    }

    public void enfileira(Pessoa pessoa, boolean prioridade) {
        this.aumentaCapacidade(); // Garante que haja espaço na fila

        if (prioridade) {
            // Adiciona no início da fila (prioritário)
            this.adiciona(pessoa);
        } else {
            int index = this.tamanho; // Adiciona no final da fila (não prioritário)
            for (int i = 0; i < this.tamanho; i++) {
                if (this.elementos[i][0] == null) {
                    index = i;
                    break;
                }
            }
            this.elementos[index][0] = pessoa;
        }
    }

    public Pessoa espiar() {
        if (this.estaVazia()) {
            return null;
        }
        return (Pessoa) this.elementos[0][0];
    }

    public Pessoa desenfileira() {
        if (this.estaVazia()) {
            return null;
        }

        Pessoa pacienteChamado = null;

        // Verifica se a próxima pessoa a ser chamada é prioritária ou normal
        if (this.elementos[0][0] != null) {
            pacienteChamado = this.remove(0, 0); // Remove o elemento prioritário
            this.contadorPrioritarios++;
        } else {
            pacienteChamado = this.remove(0, 1); // Remove o elemento normal
        }

        // A cada três pessoas prioritárias chamadas, chama uma pessoa normal
        if (this.contadorPrioritarios % 3 == 0 && this.elementos[0][1] != null) {
            Pessoa pacienteNormal = this.remove(0, 1); // Remove o elemento normal
            enfileira(pacienteNormal, false); // Adiciona o paciente normal de volta à fila
        }

        return pacienteChamado;
    }

    public void verificarFila() {
        if (this.estaVazia()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Fila:");
            for (int i = 0; i < this.tamanho; i++) {
                Pessoa pacientePrioritario = (Pessoa) this.elementos[i][0];
                if (pacientePrioritario != null) {
                    System.out.println("Prioritário: " + pacientePrioritario.getNome());
                }
                Pessoa pacienteNormal = (Pessoa) this.elementos[i][1];
                if (pacienteNormal != null) {
                    System.out.println("Normal: " + pacienteNormal.getNome());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Fila{" +
                "elementos=" + Arrays.toString(elementos) +
                '}';
    }
}







//    public Fila() {
//        super();
//    }
//
//    public Fila(int capacidade, int colunas) {
//        super(capacidade, colunas);
//    }
//
//
//
//    public void enfileira(Pessoa pessoa, boolean prioridade) {
//        this.aumentaCapacidade(); // Garante que haja espaço na fila
//
//        if (prioridade) {
//            this.adiciona(pessoa); // Adiciona no início da fila (prioritário)
//        } else {
//            int index = this.tamanho; // Adiciona no final da fila (não prioritário)
//            for (int i = 0; i < this.tamanho; i++) {
//                if (this.elementos[i][0] == null) {
//                    index = i;
//                    break;
//                }
//            }
//            this.elementos[index][0] = pessoa;
//        }
//    }
//
////    public Pessoa chamarProximoPaciente() {
////        Pessoa pacienteChamado = this.desenfileira();
////        if (pacienteChamado != null) {
////            System.out.println("Paciente chamado: " + pacienteChamado.getNome());
////        } else {
////            System.out.println("Não há pacientes na fila.");
////        }
////        return pacienteChamado;
////    }
//
//    public void verificarFila() {
//        if (this.estaVazia()) {
//            System.out.println("A fila está vazia.");
//        } else {
//            System.out.println("Fila:");
//            for (int i = 0; i < this.tamanho; i++) {
//                Pessoa pacientePrioritario = (Pessoa) this.elementos[i][0];
//                if (pacientePrioritario != null) {
//                    System.out.println("Prioritário: " + pacientePrioritario.getNome());
//                }
//                Pessoa pacienteNormal = (Pessoa) this.elementos[i][1];
//                if (pacienteNormal != null) {
//                    System.out.println("Normal: " + pacienteNormal.getNome());
//                }
//            }
//        }
//    }
//    public Pessoa espiar() {
//        if(this.estaVazia()) {
//            return null;
//        }
//        return this.elementos[0][0];
//    }
//
//    public Pessoa desenfileira() {
//        if (this.estaVazia()) {
//            return null;
//        }
//
//        // Verifica se há elemento prioritário no início da fila
//        if (this.elementos[0][0] != null) {
//            return this.remove(0, 0); // Remove o elemento prioritário
//        } else {
//            return this.remove(0, 1); // Remove o elemento normal
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Fila{" +
//                "elementos=" + Arrays.toString(elementos) +
//                '}';
//    }
//}
