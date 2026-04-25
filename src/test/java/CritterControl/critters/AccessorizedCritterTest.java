package CritterControl.critters;

import CritterControl.Accessories.Accessory;
import CritterControl.Accessories.AccessoryFactory;
import CritterControl.Commands.WearCommand;
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

        WearCommand wearCommand = new WearCommand(corral.getCritterByName("Test Critter").get(), corral, testAccessory);
        wearCommand.execute();

        String expectedName = accessorizedCritter.getName();
        String actualName = corral.getCritterByName(expectedName).get().getName();

        assertFalse(corral.contains(critter));
        assertEquals(expectedName, actualName);
    }
}
