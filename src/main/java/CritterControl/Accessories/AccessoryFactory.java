package CritterControl.Accessories;

import java.util.List;
import java.util.Random;

public class AccessoryFactory {
    private static final Random rand = new Random();

    private static final int CREATOR_NAME_LEVEL_THRESHOLD = 7;
    private static final int ADJECTIVE_LEVEL_THRESHOLD = 4;

    private static final List<String> ACCESSORY_CREATOR_NAMES = List.of("Davior", "Gale", "Xanathar", "Volo", "Tasha", "Acererak", "Desirae", "Melgani", "Elspeth", "Chandra", "Jace", "Lilith");
    private static final List<String> ACCESSORY_ADJECTIVES = List.of("Fabulous", "Wonderful", "Bombastic", "Decent", "Strange", "Gaudy", "Silly", "Heavenly", "Mighty", "Resilient", "Lucky", "Imaginary", "Supercalifragilisticexpialidocious");
    private static final List<String> ACCESSORY_NAMES = List.of("Robe", "Rod", "Hat", "Boots", "Sunglasses", "Necklace", "Amulet", "Cape", "Tchotchke", "Orb",  "Friendship Bracelet", "Thigh-highs");

    private static final int DEFAULT_LEVEL = 0;
    private static final double DEFAULT_HEALTH_BOOST = 0.0;
    private static final double DEFAULT_STRENGTH_BOOST = 0.0;
    private static final double DEFAULT_SPEED_BOOST = 0.0;
    private static final double DEFAULT_MAGIC_BOOST = 0.0;


    public Accessory createAccessory(int level, double healthBoost, double strengthBoost, double speedBoost, double magicBoost) {
        String name = generateRandomNameBasedOnLevel(level);
        return new Accessory(name, healthBoost, strengthBoost, speedBoost, magicBoost);
    }

    public Accessory createDefaultAccessory() {
        return createAccessory(DEFAULT_LEVEL, DEFAULT_HEALTH_BOOST, DEFAULT_STRENGTH_BOOST, DEFAULT_SPEED_BOOST, DEFAULT_MAGIC_BOOST);
    }

    public Accessory createRandomAccessory(int level) {
        double randomHealthBoost = rand.nextDouble();
        double randomStrengthBoost = generateRandomStatValue(level);
        double randomSpeedBoost = generateRandomStatValue(level);
        double randomMagicBoost = generateRandomStatValue(level);

        return createAccessory(level, randomHealthBoost, randomStrengthBoost, randomSpeedBoost, randomMagicBoost);
    }

    private double generateRandomStatValue(double maxValue) {
        double minValue = -maxValue;
        //Calculation intended to increase likelihood of zero values by using range of (-maxValue, maxvalue)
        //and truncating to values >= 0
        return Math.max(0.0, rand.nextDouble(maxValue - minValue) + minValue);

    }

    private String generateRandomNameBasedOnLevel(int level) {
        String name = "";

        if (level >= CREATOR_NAME_LEVEL_THRESHOLD) {
            name += ACCESSORY_CREATOR_NAMES.get(rand.nextInt(ACCESSORY_CREATOR_NAMES.size())) + " ";
        }

        if (level >= ADJECTIVE_LEVEL_THRESHOLD) {
            name += ACCESSORY_ADJECTIVES.get(rand.nextInt(ACCESSORY_ADJECTIVES.size())) + " ";
        }

        name += ACCESSORY_NAMES.get(rand.nextInt(ACCESSORY_NAMES.size()));

        return name;
    }
}
