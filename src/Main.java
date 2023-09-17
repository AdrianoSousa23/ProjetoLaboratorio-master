import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Fila<Pessoa> fila= new Fila<>();

        int resp = 0;

        do {
            String[] valores = {"Retirar Senha", "Chamar paciente", "Verificar fila", "Verificar Início da Fila", "Sair"};
            Object opcao = JOptionPane.showInputDialog(null, "O que deseja fazer?", "Laboratório", JOptionPane.WARNING_MESSAGE, null, valores, valores[0]);

            if (opcao.equals("Retirar Senha")) {
                String nome = JOptionPane.showInputDialog(null, "Digite o seu nome: ");
                String[] situacao = {"Paciente Normal", "Paciente Prioritário"};
                opcao = JOptionPane.showInputDialog(null, "O que deseja fazer?", "Laboratório", JOptionPane.WARNING_MESSAGE, null, situacao, situacao[0]);

                if(opcao.equals("Paciente Normal")) {
                    boolean prioridade = (opcao.equals("Paciente Normal"));
                    Pessoa pessoa = new Pessoa(nome, prioridade);
                    fila.enfileira((pessoa), prioridade);
                } else if(opcao.equals("Paciente Prioritário")) {
                    boolean prioridade = (opcao.equals("Paciente Prioritário"));
                    Pessoa pessoa = new Pessoa(nome, prioridade);
                    fila.enfileira((pessoa), prioridade);
                }
            } else if (opcao.equals("Chamar paciente")) {
                Pessoa pacienteChamado = fila.desenfileira();
                if (pacienteChamado != null) {
                    System.out.println("Paciente chamado: " + pacienteChamado.getNome());
                } else {
                    System.out.println("Não há pacientes na fila.");
                }
            } else if (opcao.equals("Verificar fila")) {
                fila.verificarFila();
            } else if (opcao.equals("Verificar Início da fila")) {
                Pessoa pacienteProximo = fila.espiar();
                if (pacienteProximo != null) {
                    System.out.println("Próximo paciente: " + pacienteProximo.getNome());
                } else {
                    System.out.println("Não há pacientes na fila.");
                }
            } else if (opcao.equals("Sair")) {
                resp = 1;
            }
        } while (resp == 0);
    }
}
