package no.hvl.dat109.stigespill;

import java.util.Random;

/**
 * Representerer en vanlig 6-sidet terning.
 */
public class Terning {
    private final Random rnd = new Random();

    public int trill() {
        return rnd.nextInt(6) + 1;
    }
}
