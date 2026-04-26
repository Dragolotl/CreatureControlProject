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
    }

    @Test
    public void testAccessoryCreation() {
        int level = 7;

        for (int i = 0; i < 100; i++) {
            Accessory accessory = accessoryFactory.createRandomAccessory(level);

            assertTrue(accessory.healthBoost() >= 0.0 && accessory.healthBoost() <= level);
        }
    }
}
