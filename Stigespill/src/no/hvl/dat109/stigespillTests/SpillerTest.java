package no.hvl.dat109.stigespillTests;

import no.hvl.dat109.stigespill.Spiller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpillerTest {

    @Test
    void treSeksPaRadGirReset() {
        Spiller s = new Spiller("A");

        s.registrerSeks(6);
        s.registrerSeks(6);
        s.registrerSeks(6);

        assertTrue(s.harTreSeksPaRad());
    }

    @Test
    void ikkeSeksResetterTeller() {
        Spiller s = new Spiller("A");

        s.registrerSeks(6);
        s.registrerSeks(5);

        assertFalse(s.harTreSeksPaRad());
    }
}
