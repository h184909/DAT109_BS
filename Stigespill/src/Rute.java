public class Rute {
    private final int nummer;

    public Rute(int nummer) {
        this.nummer = nummer;
    }

    public int getNummer() {
        return nummer;
    }

    @Override
    public String toString() {
        return "Rute " + nummer;
    }
}
