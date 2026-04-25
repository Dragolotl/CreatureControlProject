package CritterControl;

import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CritterCorralTest {
    private static final CritterFactory critterFactory = new CritterFactory();

    @Test
    public void testConstructor() {
        List<Critter> critters = List.of(
                critterFactory.createMinitaur("Dave"),
                critterFactory.createNecroBones("Randy"),
                critterFactory.createCritterType3("Jorge")
        );

        CritterCorral corral = new CritterCorral(critters);
        assertEquals(3, corral.getCritters().size());
    }

    @Test
    public void testGetCritterByName() {
        List<Critter> critters = List.of(
                critterFactory.createMinitaur("Dave"),
                critterFactory.createNecroBones("Randy"),
                critterFactory.createCritterType3("Jorge")
        );

        CritterCorral corral = new CritterCorral(critters);
        Critter critter = corral.getCritter("Dave").get();

        assertEquals("Dave", critter.getName());
    }
}