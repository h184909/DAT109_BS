package no.hvl.dat109.stigespill;

import java.util.*;

/**
 * Hovedprogram for slange- og stigespill (konsoll).
 * Programmet:
 * - Leser inn antall spillere (2–4) og navn.
 * - Oppretter brett, terning og spill.
 * - Kjører spillet til noen vinner.
 * - Skriver ut historikk over trekk til slutt.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Slange- og stigespill ===");
        int antall = lesInt(sc, "Antall spillere (2-4): ", 2, 4);

        List<Spiller> spillere = new ArrayList<>();
        for (int i = 1; i <= antall; i++) {
            System.out.print("Navn på spiller " + i + ": ");
            String navn = sc.nextLine().trim();
            if (navn.isEmpty()) navn = "no.hvl.dat109.stigespill.Spiller" + i;
            spillere.add(new Spiller(navn));
        }

        Brett brett = Brett.standardBrett();
        Terning terning = new Terning();
        Spill spill = new Spill(spillere, brett, terning);

        spill.spill();

        System.out.println("\n--- Historikk (trekk) ---");
        for (Trekk t : spill.getHistorikk()) {
            System.out.println(t);
        }
    }

    /**
     * Leser et heltall fra konsoll med validering.
     * Brukes for å sikre at antall spillere ligger innenfor et intervall.
     *
     * @param sc scanner for input
     * @param prompt tekst som vises til bruker
     * @param min minste lovlige verdi
     * @param max største lovlige verdi
     * @return et gyldig heltall innenfor [min, max]
     */
    private static int lesInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            try {
                int v = Integer.parseInt(s.trim());
                if (v >= min && v <= max) return v;
            } catch (Exception ignored) {}
            System.out.println("Ugyldig. Skriv et tall mellom " + min + " og " + max + ".");
        }
    }
}
