package CritterControl;

import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import CritterControl.Accessories.Accessory;
import CritterControl.Food.Food;
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
    @Test
    public void testAddAndRemoveFood() {
        CritterCorral corral = new CritterCorral();
        Food apple = new Food("Apple", 1);

        corral.add(apple);
        assertTrue(corral.contains(apple));

        corral.remove(apple);
        assertFalse(corral.contains(apple));
    }
    @Test
    public void testAddAndRemoveAccessory() {
        CritterCorral corral = new CritterCorral();
        Accessory hat = new Accessory("Hat", 2);

        corral.add(hat);
        assertTrue(corral.contains(hat));

        corral.remove(hat);
        assertFalse(corral.contains(hat));
    }
    @Test
    public void testPrintAll() {
        CritterCorral corral = new CritterCorral();

        assertFalse(corral.printAllFood());
        assertFalse(corral.printAllAccessories());

        corral.add(new Food("Apple", 1));
        corral.add(new Accessory("Hat", 2));

        assertTrue(corral.printAllAccessories());
        assertTrue(corral.printAllFood());
    }
    @Test
    public void testGetWardrobeAndKitchen() {
        CritterCorral corral = new CritterCorral();

        assertNotNull(corral.getWardrobe());
        assertNotNull(corral.getKitchen());
    }
    @Test
    public void testGetCritterByIndex() {
        Critter manny = critterFactory.createMinitaur("Manny");
        CritterCorral corral = new CritterCorral(List.of(manny));

        assertEquals(manny, corral.getCritterByIndex(0));
        assertNull(corral.getCritterByIndex(-1));
        assertNull(corral.getCritterByIndex(1));
    }

    @Test
    public void testGetAccessoryByIndex() {
        CritterCorral corral = new CritterCorral();
        Accessory hat = new Accessory("Hat", 2);

        corral.add(hat);

        assertEquals(hat, corral.getAccessoryByIndex(0));
        assertNull(corral.getAccessoryByIndex(-1));
        assertNull(corral.getAccessoryByIndex(1));
    }

    @Test
    public void testGetFoodByIndex() {
        CritterCorral corral = new CritterCorral();
        Food apple = new Food("Apple", 1);

        corral.add(apple);

        assertEquals(apple, corral.getFoodByIndex(0));
        assertNull(corral.getFoodByIndex(-1));
        assertNull(corral.getFoodByIndex(1));
    }


}