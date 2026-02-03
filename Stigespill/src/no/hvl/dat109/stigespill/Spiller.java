package no.hvl.dat109.stigespill;

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

    public void setMaTrilleSeksForStart(boolean v) {
        this.maaTrilleSeksForStart = v;
    }
}
