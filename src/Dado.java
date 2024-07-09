import java.util.Random;

public class Dado {
    private Random random;

    public Dado() {
        random = new Random();
    }

    public int rolar() {
        return random.nextInt(6) + 1;
    }
}

