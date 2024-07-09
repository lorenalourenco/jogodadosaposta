import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo CSV para salvar os vencedores: ");
        String caminhoArquivoCSV = scanner.nextLine();
        JogoAposta jogo = new JogoAposta(caminhoArquivoCSV);

        System.out.println("Bem-vindo ao jogo de aposta com dados!");

        System.out.print("Digite o número de jogadores (até 11): ");
        int numJogadores = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (numJogadores < 1 || numJogadores > 11) {
            System.out.println("Número inválido de jogadores. O número deve estar entre 1 e 11.");
            return;
        }

        // Adiciona jogadores
        for (int i = 0; i < numJogadores; i++) {
            System.out.print("Digite o nome do jogador " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            System.out.print("Digite o número escolhido pelo jogador " + (i + 1) + " (entre 2 e 12): ");
            int numeroEscolhido = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (numeroEscolhido < 2 || numeroEscolhido > 12) {
                System.out.println("Número inválido. Escolha um número entre 2 e 12.");
                i--; // Para pedir o número novamente
            } else {
                jogo.adicionarJogador(nome, numeroEscolhido);
            }
        }

        // Inicia o jogo
        jogo.jogar();
    }
}


