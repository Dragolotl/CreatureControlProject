package CritterControl.critters;

import CritterControl.Die;
import CritterControl.Food.Food;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CritterTest {
    CritterFactory critterFactory = new CritterFactory();

    @Test
    void testCritterHasHealth() {
        Critter critter = critterFactory.createMinitaur("placeholder name");

        assertTrue(critter.getHealth() > 0);
    }

    @Test
    void testEatChangesHappiness() {
        Critter critter = critterFactory.createMinitaur("placeholder name");
        Food broccoli = new Food("Broccoli", -1,1);

        int expectedHappiness = critter.getHappiness() + broccoli.getHappinessValue();

        critter.eat(broccoli);

        assertEquals(expectedHappiness, critter.getHappiness());
    }

    @Test
    void testLoseHealth() {
        Critter critter = critterFactory.createMinitaur("placeholder name");

        int expectedHealth = critter.getHealth() - 2;

        critter.loseHealth(2);

        assertEquals(expectedHealth, critter.getHealth());
    }

    @Test
    void testLoseHappiness() {
        Critter critter = critterFactory.createMinitaur("placeholder name");

        critter.loseHappiness(10);

        assertEquals(90, critter.getHappiness());
    }

    @Test
    void testHappinessDoesNotGoBelowZero() {
        Critter critter = critterFactory.createMinitaur("placeholder name");

        critter.loseHappiness(200);

        assertEquals(0, critter.getHappiness());
    }

    @Test
    void testHappinessDoesNotGoAboveOneHundred() {
        Critter critter = critterFactory.createMinitaur("placeholder name");

        critter.setHappiness(200);

        assertEquals(100, critter.getHappiness());
    }

    @Test
    void testLevelUp() {
        Critter critter = critterFactory.createMinitaur("placeholder name");

        critter.levelUp();

        assertEquals(2, critter.getLevel());
    }

    @Test
    void testSetName() {
        Critter critter = critterFactory.createMinitaur("placeholder name");

        critter.setName("New Name");

        assertEquals("New Name", critter.getName());
    }
    @Test
    void testSingleArgumentConstructorDefaultsLevelToOne() {
        Critter critter = new Minitaur("Manny");

        assertEquals(1, critter.getLevel());
    }

    @Test
    void testSetDie() {
        Critter critter = critterFactory.createMinitaur("Manny");
        Die die = new Die(12);

        critter.setDie(die);

        assertEquals(die, critter.getDie());
    }

    @Test
    void testAddHealth() {
        Critter critter = critterFactory.createMinitaur("Manny");

        int expectedHealth = critter.getHealth() + 5;

        critter.addHealth(5);

        assertEquals(expectedHealth, critter.getHealth());
    }

    @Test
    void testBaseCritterGetAccessoryReturnsNull() {
        Critter critter = critterFactory.createMinitaur("Manny");

        assertNull(critter.getAccessory());
    }
    @Test
    public void testNecroBonesHasTypeAdvantageOverSpeed() {
        Critter necro = critterFactory.createNecroBones("Necro");
        Critter raptor = critterFactory.createVelociraptor("Raptor");

        assertEquals(Critter.TYPE_ADVANTAGE_DAMAGE_BONUS,
                necro.checkForTypeAdvantage(raptor));
    }

    @Test
    public void testNecroBonesNoTypeAdvantageOverStrength() {
        Critter necro = critterFactory.createNecroBones("Necro");
        Critter manny = critterFactory.createMinitaur("Manny");

        assertEquals(0, necro.checkForTypeAdvantage(manny));
    }
}