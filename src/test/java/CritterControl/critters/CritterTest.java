package CritterControl.critters;

import CritterControl.Food.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CritterTest {
    CritterFactory critterFactory = new CritterFactory();
    @Test
    void testCreatureHasHungerLevel(){
        Critter critter = critterFactory.createMinitaur("placeholder name");
        assertTrue(critter.getHealth() > 0);
    }
    @Disabled
    void testEat(){
        Critter critter = critterFactory.createMinitaur("placeholder name");
        Food broccoli = new Food("Broccoli", 10, 1); //10.0, -1.0
        int initialHealth=critter.getHealth();
        double initialHappiness=critter.getHappiness();
        int expectedHealth=critter.getHealth()+ broccoli.getHealthValue();
        double expectedHappiness = critter.getHappiness()+broccoli.getHappinessValue();
        critter.eat(broccoli);
        Assertions.assertEquals(expectedHealth, critter.getHealth());
        Assertions.assertEquals(expectedHappiness, critter.getHappiness());

    }
}
