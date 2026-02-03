package no.hvl.dat109.stigespill;

import java.util.*;

public class Spill {
    private final List<Spiller> spillere;
    private final Brett brett;
    private final Terning terning;

    private final List<Trekk> historikk = new ArrayList<>();
    private boolean ferdig = false;
    private int rundeNr = 1;

    public Spill(List<Spiller> spillere, Brett brett, Terning terning) {

        if (spillere.size() < 2 || spillere.size() > 4) {
            throw new IllegalArgumentException("Må inneholde 2-4 spillere!");
        }
        this.spillere = spillere;
        this.brett = brett;
        this.terning = terning;
    }

    /**
     * Oppretter spill, og så looper runder -> hver spiller tar tur til en vinner
     */

    public void spill() {

        System.out.println("Spillet starter! Alle starter på rute 1.");

        while (!ferdig) {
            System.out.println("=== Runde " + rundeNr + " ===");
            for (Spiller spiller : spillere) {
                if (ferdig) break;
                spillTrekk(spiller);
            }
            rundeNr++;
            System.out.println();
        }

    }

    private void spillTrekk(Spiller spiller) {
        System.out.println("\n" + spiller.getNavn() + " sin tur. (posisjon=" + spiller.getBrikke().getPosisjon() + ")");

        spiller.resetSeksTellerHvisNyTur();

        boolean fortsett = true;
        while (fortsett && !ferdig) {
            int kast = terning.trill();
            System.out.println("Kast: " + kast);

            // 3x6-regel
            spiller.registrerSeks(kast);
            if (spiller.harTreSeksPaRad()) {
                int fra = spiller.getBrikke().getPosisjon();
                spiller.getBrikke().setPosisjon(1);
                spiller.setMaTrilleSeksForStart(true);

                historikk.add(new Trekk(spiller.getNavn(), kast, fra, 1, "3x6 -> til start, må trille 6"));
                System.out.println("3 seksere på rad! Til start. Må trille 6 for å starte igjen.");
                break; // turen er ferdig
            }

            // Må trille 6 for å starte igjen (etter 3x6)
            if (spiller.maTrilleSeksForStart()) {
                if (kast != 6) {
                    historikk.add(new Trekk(spiller.getNavn(), kast,
                            spiller.getBrikke().getPosisjon(),
                            spiller.getBrikke().getPosisjon(),
                            "må trille 6 (ingen bevegelse)"));
                    System.out.println("Du må trille 6 for å starte igjen. Ingen bevegelse.");
                    break;
                } else {
                    spiller.setMaTrilleSeksForStart(false);
                    System.out.println("Du trillet 6, du kan starte igjen!");
                }
            }

            int fra = spiller.getBrikke().getPosisjon();
            int til = brett.flytt(fra, kast);

            String effekt = "ingen";
            if (til == fra && kast > 0 && (fra + kast) > brett.getSisteRute()) {
                effekt = "overshoot -> står";
                System.out.println("Du måtte treffe 100. Overshoot! Du blir stående på " + fra + ".");
            } else {
                spiller.getBrikke().setPosisjon(til);
                System.out.println("Flyttet til rute " + til);

                int etterSlangeStige = brett.anvendSlangeEllerStige(til);
                if (etterSlangeStige != til) {
                    if (etterSlangeStige > til) {
                        effekt = "stige " + til + "->" + etterSlangeStige;
                        System.out.println("Stige! Opp til " + etterSlangeStige);
                    } else {
                        effekt = "slange " + til + "->" + etterSlangeStige;
                        System.out.println("Slange! Ned til " + etterSlangeStige);
                    }
                    spiller.getBrikke().setPosisjon(etterSlangeStige);
                    til = etterSlangeStige;
                }
            }

            historikk.add(new Trekk(spiller.getNavn(), kast, fra, spiller.getBrikke().getPosisjon(), effekt));

            // Sjekk vinner (må treffe 100)
            if (spiller.getBrikke().getPosisjon() == brett.getSisteRute()) {
                System.out.println("\n🎉 " + spiller.getNavn() + " vant! (treffet 100)");
                ferdig = true;
                break;
            }

            // 6 gir ekstra kast (hvis ikke 3x6 skjedde)
            if (kast == 6) {
                System.out.println("Du trillet 6 => ekstra kast!");
                fortsett = true;
            } else {
                fortsett = false;
            }
        }
    }

    public List<Trekk> getHistorikk() {
        return Collections.unmodifiableList(historikk);
    }
}