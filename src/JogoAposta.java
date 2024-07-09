import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JogoAposta {
    private List<Jogador> jogadores;
    private Dado dado1;
    private Dado dado2;
    private String caminhoArquivoCSV;

    public JogoAposta(String caminhoArquivoCSV) {
        jogadores = new ArrayList<>();
        dado1 = new Dado();
        dado2 = new Dado();
        this.caminhoArquivoCSV = caminhoArquivoCSV;
    }

    public void adicionarJogador(String nome, int numeroEscolhido) {
        if (jogadores.size() < 11) {
            jogadores.add(new Jogador(nome, numeroEscolhido));
        } else {
            System.out.println("O número máximo de jogadores é 11.");
        }
    }

    public void jogar() {
        int resultadoDado1 = dado1.rolar();
        int resultadoDado2 = dado2.rolar();
        int somaDados = resultadoDado1 + resultadoDado2;

        System.out.println("Os dados foram rolados: " + resultadoDado1 + " + " + resultadoDado2 + " = " + somaDados);

        boolean houveVencedor = false;
        for (Jogador jogador : jogadores) {
            if (jogador.getNumeroEscolhido() == somaDados) {
                System.out.println("O jogador " + jogador.getNome() + " venceu!");
                salvarVencedorNoCSV(jogador);
                houveVencedor = true;
                break;
            }
        }

        if (!houveVencedor) {
            System.out.println("Nenhum jogador acertou. O computador vence!");
        }
    }

    private void salvarVencedorNoCSV(Jogador vencedor) {
        try (FileWriter writer = new FileWriter(caminhoArquivoCSV, true)) {
            writer.append(vencedor.getNome());
            writer.append(',');
            writer.append(String.valueOf(vencedor.getNumeroEscolhido()));
            writer.append('\n');
        } catch (IOException e) {
            System.out.println("Erro ao salvar vencedor no arquivo CSV: " + e.getMessage());
        }
    }
}
