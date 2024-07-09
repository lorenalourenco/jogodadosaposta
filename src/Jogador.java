public class Jogador {
    private String nome;
    private int numeroEscolhido;

    public Jogador(String nome, int numeroEscolhido) {
        this.nome = nome;
        this.numeroEscolhido = numeroEscolhido;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroEscolhido() {
        return numeroEscolhido;
    }
}
