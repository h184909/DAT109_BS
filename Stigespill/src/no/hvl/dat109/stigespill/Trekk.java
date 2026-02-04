package no.hvl.dat109.stigespill;

/**
 * Representerer ett trekk i spillet (historikk).
 * Brukes til å lagre hva som skjedde i en tur:
 * - spiller
 * - terningkast
 * - fra/til-posisjon
 * - evt. effekt (stige/slange/overshoot osv.).
 */
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
