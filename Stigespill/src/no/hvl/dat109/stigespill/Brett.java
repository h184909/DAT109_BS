package no.hvl.dat109.stigespill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representerer brettet i slange- og stigespill.
 * Brettet består av 100 ruter (1..100) og kan inneholde slanger og stiger.
 * Slanger/stiger representeres som en mapping fra startposisjon til endeposisjon.
 */
public class Brett {

    private final int sisteRute = 100;
    private final List<Rute> ruter = new ArrayList<>();

    /**
     * hvis pos finnes i map -> teleport til verdi
     */
    private final Map<Integer, Integer> slangerOgStiger = new HashMap<>();

    /**
     * Oppretter et nytt brett og lager rutene 1..100.
     */
    public Brett() {
        for (int i = 1; i <= sisteRute; i++) {
            ruter.add(new Rute(i));
        }
    }

    public int getSisteRute() {
        return sisteRute;
    }

    /**
     * Flytter fra en posisjon basert på terningkast.
     * Regelen "må treffe 100" håndteres her:
     * Hvis (fra + kast) blir større enn 100, returneres fra-posisjon (spilleren står).
     *
     * @param fra posisjon før flytt
     * @param kast terningkast (1..6)
     * @return ny posisjon, eller fra hvis overshoot
     */
    public int flytt(int fra, int kast) {

        int total = fra + kast;
        if (total > sisteRute) {
            return fra;
        }
        return total;
    }

    /**
     * Sjekker om det finnes slange eller stige fra gitt posisjon.
     *
     * @param pos posisjon spilleren lander på
     * @return endeposisjon hvis det finnes slange/stige, ellers pos selv
     */
    public int anvendSlangeEllerStige(int pos) {
        return slangerOgStiger.getOrDefault(pos, pos);
    }

    /**
     * Legger inn en slange eller stige i mappingen.
     * Metoden validerer enkelt at posisjoner er innenfor 1..99, og at fra != til.
     *
     * @param fra startposisjon for slange/stige
     * @param til endeposisjon for slange/stige
     */
    public void setSlangerOgStiger(int fra, int til) {
        if (fra < 1 || fra >= sisteRute) return;
        if (til < 1 || til >= sisteRute) return;
        if (fra == til) return;
        slangerOgStiger.put(fra, til);
    }

    /**
     * Lager et standardbrett med et forhåndsdefinert sett av slanger og stiger (de samme som bildet i oppgaveteksten).
     * Brukes i denne enkle konsollversjonen.
     *
     * @return et brett med slanger og stiger
     */
    public static Brett standardBrett() {
        Brett b = new Brett();

        //stiger:
        b.setSlangerOgStiger(2, 38);
        b.setSlangerOgStiger(4, 14);
        b.setSlangerOgStiger(8, 31);
        b.setSlangerOgStiger(21, 42);
        b.setSlangerOgStiger(28, 84);
        b.setSlangerOgStiger(36, 44);
        b.setSlangerOgStiger(71, 91);
        b.setSlangerOgStiger(80, 100);

        //slanger:
        b.setSlangerOgStiger(15, 6);
        b.setSlangerOgStiger(47, 26);
        b.setSlangerOgStiger(49, 11);
        b.setSlangerOgStiger(2, 38);
        b.setSlangerOgStiger(56, 53);
        b.setSlangerOgStiger(62, 18);
        b.setSlangerOgStiger(64, 60);
        b.setSlangerOgStiger(87, 24);
        b.setSlangerOgStiger(91, 73);
        b.setSlangerOgStiger(95, 75);
        b.setSlangerOgStiger(98, 78);

        return b;
    }

}
