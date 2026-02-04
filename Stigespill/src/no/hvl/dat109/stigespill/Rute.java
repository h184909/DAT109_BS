package no.hvl.dat109.stigespill;
/**
 * Representerer en rute på brettet.
 * I denne løsningen brukes rute mest som en enkel verdi (nummer),
 * men kan utvides senere (f.eks. egne typer ruter).
 */
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
