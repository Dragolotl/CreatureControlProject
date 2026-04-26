package CritterControl;

import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CritterCorralTest {
    private static final CritterFactory critterFactory = new CritterFactory();

    @Test
    public void testConstructor() {
        List<Critter> critters = List.of(
                critterFactory.createMinitaur("Dave"),
                critterFactory.createNecroBones("Randy"),
                critterFactory.createVelociraptor("Jorge")
        );

        CritterCorral corral = new CritterCorral(critters);
        assertEquals(3, corral.getCritters().size());
    }

    @Test
    public void testGetCritterByName() {
        List<Critter> critters = List.of(
                critterFactory.createMinitaur("Dave"),
                critterFactory.createNecroBones("Randy"),
                critterFactory.createVelociraptor("Jorge")
        );

        CritterCorral corral = new CritterCorral(critters);
        Critter critter = corral.getCritterByName("Dave").get();

        assertEquals("Dave", critter.getName());
    }

    @Test
    public void testReplaceCritter() {
        List<Critter> critters = List.of(
                critterFactory.createMinitaur("Dave"),
                critterFactory.createVelociraptor("Randy"),
                critterFactory.createVelociraptor("Jorge")
        );

        CritterCorral corral = new CritterCorral(critters);

        Critter originalCritter = corral.getCritterByName("Dave").get();
        Critter newCritter = critterFactory.createMinitaur("Dave-lganger");
        corral.replace(originalCritter, newCritter);

        assertFalse(corral.contains(originalCritter));
        assertTrue(corral.contains(newCritter));
    }
}