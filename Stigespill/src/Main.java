import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Slange- og stigespill ===");
        int antall = lesInt(sc, "Antall spillere (2-4): ", 2, 4);

        List<Spiller> spillere = new ArrayList<>();
        for (int i = 1; i <= antall; i++) {
            System.out.print("Navn på spiller " + i + ": ");
            String navn = sc.nextLine().trim();
            if (navn.isEmpty()) navn = "Spiller" + i;
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
