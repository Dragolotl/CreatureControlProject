package CritterControl.critters;

import CritterControl.Food.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CritterTest {
    CritterFactory critterFactory = new CritterFactory();
    @Test
    void testCreatureHasHungerLevel(){
        Critter critter = critterFactory.createCritterType1("placeholder name");
        assertTrue(critter.getHealth() > 0);
    }
    @Test
    void testEat(){
        Critter critter = critterFactory.createCritterType1("placeholder name");
        Food broccoli = new Food("Broccoli", 10.0, -1.0);
        Double initialHealth=critter.getHealth();
        Double initialHappiness=critter.getHappiness();
        Double expectedHealth=critter.getHealth()+ broccoli.getHealthValue();
        Double expectedHappiness = critter.getHappiness()+broccoli.getHappinessValue();
        critter.eat(broccoli);
        Assertions.assertEquals(expectedHealth, critter.getHealth());
        Assertions.assertEquals(expectedHappiness, critter.getHappiness());

    }
}
