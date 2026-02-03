package no.hvl.dat109.stigespillTests;

import no.hvl.dat109.stigespill.Spiller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpillRegelTest {

    @Test
    void maaTrilleSeksBlokkererFlytt() {
        Spiller s = new Spiller("A");
        s.setMaTrilleSeksForStart(true);

        // simuler "ikke 6"
        s.registrerSeks(5);

        assertTrue(s.maTrilleSeksForStart());
        assertEquals(1, s.getBrikke().getPosisjon());
    }
}
