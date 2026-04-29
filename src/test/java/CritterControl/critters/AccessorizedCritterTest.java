package CritterControl.critters;

import CritterControl.Accessories.Accessory;
import CritterControl.Accessories.AccessoryFactory;
import CritterControl.Commands.DressCommand;
import CritterControl.CritterCorral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccessorizedCritterTest {
    private static final CritterFactory critterFactory = new CritterFactory();
    private static final AccessoryFactory accessoryFactory = new AccessoryFactory();

    @Test
    public void createAccessorizedCritter() {
        Critter critter = critterFactory.createMinitaur("Test Critter");
        Accessory testAccessory = accessoryFactory.createRandomAccessory(7);
        Critter accessorizedCritter = critterFactory.createAccessorizedCritter(critter, testAccessory);

        System.out.println("Accessorized Critter Base Name: " + accessorizedCritter.getBaseName());
        System.out.println("Accessorized Critter Name: " + accessorizedCritter.getName());
        assertEquals(accessorizedCritter.getHealth(), critter.getHealth() + testAccessory.healthBoost());
    }

    @Test
    public void testReplacementOfCritter() {
        CritterCorral corral = new CritterCorral();
        Critter critter = critterFactory.createMinitaur("Test Critter");
        Accessory testAccessory = accessoryFactory.createDefaultAccessory();
        Critter accessorizedCritter = critterFactory.createAccessorizedCritter(critter, testAccessory);

        corral.add(critter);
        corral.add(testAccessory);
        assertTrue(corral.contains(critter));

        DressCommand wearCommand = new DressCommand(corral.getCritterByName("Test Critter").get(), corral, testAccessory);
        wearCommand.execute();

        String expectedName = accessorizedCritter.getName();
        String actualName = corral.getCritterByName(expectedName).get().getName();

        assertFalse(corral.contains(critter));
        assertEquals(expectedName, actualName);
    }
    @Test
    public void testIsAccessorizedAndAccessoryGetter() {
        Critter critter = critterFactory.createMinitaur("Manny");
        Accessory accessory = accessoryFactory.createDefaultAccessory();

        Critter accessorized = critterFactory.createAccessorizedCritter(critter, accessory);

        assertTrue(accessorized.isAccessorized());
        assertEquals(accessory, accessorized.getAccessory());
    }

    @Test
    public void testDelegationToBaseCritter() {
        Critter critter = critterFactory.createMinitaur("Manny");
        Accessory accessory = accessoryFactory.createDefaultAccessory();

        Critter accessorized = critterFactory.createAccessorizedCritter(critter, accessory);

        assertEquals(critter.getLevel(), accessorized.getLevel());
        assertEquals(critter.isAlive(), accessorized.isAlive());
        assertEquals(critter.getHappiness(), accessorized.getHappiness());
    }
    @Test
    public void testAccessorizedCritterDelegatesStrategy() {
        Critter critter = critterFactory.createMinitaur("Manny");
        Accessory accessory = accessoryFactory.createDefaultAccessory();
        Critter accessorizedCritter = critterFactory.createAccessorizedCritter(critter, accessory);

        assertEquals(critter.getStrategy(), accessorizedCritter.getStrategy());
    }

    @Test
    public void testAccessorizedCritterDelegatesSetHealth() {
        Critter critter = critterFactory.createMinitaur("Manny");
        Accessory accessory = accessoryFactory.createDefaultAccessory();
        Critter accessorizedCritter = critterFactory.createAccessorizedCritter(critter, accessory);

        accessorizedCritter.setHealth(20);

        assertEquals(20, critter.getHealth());
    }

    @Test
    public void testAccessorizedCritterDelegatesSetHappiness() {
        Critter critter = critterFactory.createMinitaur("Manny");
        Accessory accessory = accessoryFactory.createDefaultAccessory();
        Critter accessorizedCritter = critterFactory.createAccessorizedCritter(critter, accessory);

        accessorizedCritter.setHappiness(50);

        assertEquals(50, critter.getHappiness());
    }

    @Test
    public void testAccessorizedCritterDelegatesLevelUp() {
        Critter critter = critterFactory.createMinitaur("Manny");
        Accessory accessory = accessoryFactory.createDefaultAccessory();
        Critter accessorizedCritter = critterFactory.createAccessorizedCritter(critter, accessory);

        accessorizedCritter.levelUp();

        assertEquals(2, critter.getLevel());
    }

    @Test
    public void testAccessorizedCritterDelegatesSetStrategy() {
        Critter critter = critterFactory.createMinitaur("Manny", 5);
        Accessory accessory = accessoryFactory.createDefaultAccessory();
        Critter accessorizedCritter = critterFactory.createAccessorizedCritter(critter, accessory);

        accessorizedCritter.setStrategy();

        assertInstanceOf(CritterControl.Strategy.MinitaurLevel5Strategy.class, critter.getStrategy());
    }
    @Test
    public void testAccessorizedCritterDelegatesTypeAdvantage() {
        Critter raptor = critterFactory.createVelociraptor("Raptor");
        Critter manny = critterFactory.createMinitaur("Manny");

        Accessory accessory = accessoryFactory.createDefaultAccessory();
        Critter accessorized = critterFactory.createAccessorizedCritter(raptor, accessory);

        int expected = raptor.checkForTypeAdvantage(manny);
        int actual = accessorized.checkForTypeAdvantage(manny);

        assertEquals(expected, actual);
    }
}
