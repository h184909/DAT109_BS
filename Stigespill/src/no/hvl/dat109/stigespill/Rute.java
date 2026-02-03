package no.hvl.dat109.stigespill;

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
        return "no.hvl.dat109.stigespill.Rute " + nummer;
    }
}
