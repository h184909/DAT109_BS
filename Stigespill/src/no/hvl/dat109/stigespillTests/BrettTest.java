package no.hvl.dat109.stigespillTests;

import no.hvl.dat109.stigespill.Brett;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester overshoot-regel og slange/stige-mapping.
 */
public class BrettTest {

    @Test
    void overshootGirStaa() {
        Brett b = new Brett();
        assertEquals(99, b.flytt(99, 3));
    }

    @Test
    void slangeOgStigeFlytter() {
        Brett b = new Brett();
        b.setSlangerOgStiger(4,14);
        b.setSlangerOgStiger(17,7);

        assertEquals(14, b.anvendSlangeEllerStige(4));
        assertEquals(7, b.anvendSlangeEllerStige(17));
    }
}

