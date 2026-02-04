package no.hvl.dat109.stigespill;

/**
 * Representerer en spillebrikke til en spiller.
 * Brikken holder kun styr på posisjon (rutenummer) på brettet.
 * Den flyttes av spill-logikken i Spill klassen.
 */
public class Brikke {
    private int posisjon = 1;

    public int getPosisjon() {
        return posisjon;
    }

    public void setPosisjon(int posisjon) {
        this.posisjon = posisjon;
    }
}
