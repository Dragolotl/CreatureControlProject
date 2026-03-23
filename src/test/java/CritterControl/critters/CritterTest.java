package CritterControl.critters;

import org.junit.jupiter.api.Test;
import CritterControl.critters.Critter;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CritterTest {
    CritterFactory critterFactory = new CritterFactory();

    @Test
    void testCreatureHasHungerLevel(){
        Critter critter = critterFactory.createCritterType1("placeholder name");
        assertTrue(critter.getHealth() > 0);
    }
}
