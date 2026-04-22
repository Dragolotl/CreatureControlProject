package CritterControl.Accessory;

import CritterControl.Accessories.Accessory;
import CritterControl.Accessories.AccessoryFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccessoryTest {
    private static final AccessoryFactory accessoryFactory = new AccessoryFactory();

    @Test
    public void testDefaultAccessory() {
        Accessory defaultAccessory = accessoryFactory.createDefaultAccessory();

        System.out.println("Accessory Name: " + defaultAccessory.name());

        assertEquals(AccessoryFactory.DEFAULT_HEALTH_BOOST, defaultAccessory.healthBoost());
        assertEquals(AccessoryFactory.DEFAULT_STRENGTH_BOOST, defaultAccessory.strengthBoost());
        assertEquals(AccessoryFactory.DEFAULT_SPEED_BOOST, defaultAccessory.speedBoost());
        assertEquals(AccessoryFactory.DEFAULT_MAGIC_BOOST, defaultAccessory.magicBoost());
    }

    @Test
    public void testAccessoryCreation() {
        int level = 7;

        for (int i = 0; i < 100; i++) {
            Accessory accessory = accessoryFactory.createRandomAccessory(level);

            assertTrue(accessory.healthBoost() >= 0.0 && accessory.healthBoost() <= level);
            assertTrue(accessory.strengthBoost() >= 0.0 && accessory.strengthBoost() <= level);
            assertTrue(accessory.speedBoost() >= 0.0 && accessory.speedBoost() <= level);
            assertTrue(accessory.magicBoost() >= 0.0 && accessory.magicBoost() <= level);
        }
    }
}
