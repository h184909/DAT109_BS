package no.hvl.dat109.stigespill;

public class Trekk {
    private final String spillerNavn;
    private final int kast;
    private final int fra;
    private final int til;
    private final String effekt;

    public Trekk(String spillerNavn, int kast, int fra, int til, String effekt) {
        this.spillerNavn = spillerNavn;
        this.kast = kast;
        this.fra = fra;
        this.til = til;
        this.effekt = effekt;
    }

    @Override
    public String toString() {
        return spillerNavn + " kast=" + kast + " " + fra + "->" + til + " (" + effekt + ")";
    }
}
