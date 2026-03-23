package CreatureControl.creatures;

import org.junit.jupiter.api.Test;
import CreatureControl.creatures.Creature;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatureTest {

    @Test
    void testCreatureHasHungerLevel(){
        Creature critter = new Creature("Tester");
        assertTrue(critter.getHealth() > 0);
    }
}
