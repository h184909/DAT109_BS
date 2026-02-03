import java.util.Random;

public class Terning {
    private final Random rnd = new Random();

    public int trill() {
        return rnd.nextInt(6) + 1;
    }
}
