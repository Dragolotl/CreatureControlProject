package CreatureControl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatureTest {

    @Test
    void testCreatureHasHungerLevel(){
        Creature critter = new Creature("Tester");
        assertTrue(critter.getHealth() > 0);
    }
}
