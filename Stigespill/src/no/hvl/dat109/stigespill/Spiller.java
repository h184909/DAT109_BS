package no.hvl.dat109.stigespill;

/**
 * Representerer en spiller i spillet.
 * En spiller har:
 *   - Navn
 *   - En brikke (posisjon på brettet)
 *   - Tilstand for regel "3 seksere på rad"
 *   - Tilstand for regel "må trille 6 for å starte igjen"
 *
 * Klassen inneholder bare enkel tilstand og støttefunksjoner,
 * mens selve tur-logikken styres av Spill klassen.
 */
public class Spiller {
    private final String navn;
    private final Brikke brikke = new Brikke();

    // regel: 3x6 på rad
    private int seksPaaRad = 0;

    // regel: etter 3x6 må du trille 6 for å starte igjen
    private boolean maaTrilleSeksForStart = false;
    private boolean nyTur = true;

    public Spiller(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public Brikke getBrikke() {
        return brikke;
    }

    public void registrerNyTurn() {
        nyTur = true;
    }

    /**
     * Resetter teller for antall 6 på rad hvis spilleren starter ny tur.
     * Dette gjør at 3x6-regelen blir knyttet til én tur.
     */
    public void resetSeksTellerHvisNyTur() {
        if (nyTur) {
            seksPaaRad = 0;
            nyTur = false;
        }
    }

    public void registrerSeks(int kast) {
        if (kast == 6) seksPaaRad++;
        else seksPaaRad = 0;
    }

    public boolean harTreSeksPaRad() {
        return seksPaaRad >= 3;
    }

    public boolean maTrilleSeksForStart() {
        return maaTrilleSeksForStart;
    }

    /**
     * Setter flagg for om spilleren må trille 6 for å starte igjen.
     *
     * @param v true hvis spilleren må trille 6, ellers false
     */
    public void setMaTrilleSeksForStart(boolean v) {
        this.maaTrilleSeksForStart = v;
    }
}
