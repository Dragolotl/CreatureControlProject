package CritterControl.Accessories;

import java.util.List;
import java.util.Random;

public class AccessoryFactory {
    private static final Random rand = new Random();

    private static final int CREATOR_NAME_LEVEL_THRESHOLD = 7;
    private static final int ADJECTIVE_LEVEL_THRESHOLD = 4;

    private static final List<String> ACCESSORY_CREATOR_NAMES = List.of("Davior", "Gale", "Xanathar", "Volo", "Tasha", "Acererak", "Desirae", "Melgani", "Elspeth", "Chandra", "Jace", "Lilith", "Caleb", "");
    private static final List<String> ACCESSORY_ADJECTIVES = List.of("Fabulous", "Wonderful", "Bombastic", "Decent", "Strange", "Gaudy", "Silly", "Heavenly", "Mighty", "Resilient", "Lucky", "Imaginary", "Supercalifragilisticexpialidocious");
    private static final List<String> ACCESSORY_NAMES = List.of("Robe", "Rod", "Hat", "Boots", "Sunglasses", "Necklace", "Amulet", "Cape", "Tchotchke", "Orb",  "Friendship Bracelet", "Thigh-highs");

    public static final int DEFAULT_LEVEL = 0;
    public static final int DEFAULT_HEALTH_BOOST = 0;
    public static final int DEFAULT_STRENGTH_BOOST = 0;
    public static final int DEFAULT_SPEED_BOOST = 0;
    public static final int DEFAULT_MAGIC_BOOST = 0;

    public Accessory createAccessory(int level, int healthBoost, int strengthBoost, int speedBoost, int magicBoost) {
        String name = generateRandomNameBasedOnLevel(level);
        return new Accessory(name, healthBoost, strengthBoost, speedBoost, magicBoost);
    }

    public Accessory createDefaultAccessory() {
        return createAccessory(DEFAULT_LEVEL, DEFAULT_HEALTH_BOOST, DEFAULT_STRENGTH_BOOST, DEFAULT_SPEED_BOOST, DEFAULT_MAGIC_BOOST);
    }

    //create an accessory of random level and stats
    public Accessory createRandomAccessory(int maxLevel) {
        int level = rand.nextInt(maxLevel) + 1;
        int randomHealthBoost = rand.nextInt(level);
        int randomStrengthBoost = generateRandomStatValue(level);
        int randomSpeedBoost = generateRandomStatValue(level);
        int randomMagicBoost = generateRandomStatValue(level);

        return createAccessory(level, randomHealthBoost, randomStrengthBoost, randomSpeedBoost, randomMagicBoost);
    }

    private int generateRandomStatValue(int maxValue) {
        int minValue = -maxValue;
        //Calculation intended to increase likelihood of zero values by using range of (-maxValue, maxvalue)
        //and truncating to values >= 0
        return Math.max(0, rand.nextInt(maxValue - minValue) + minValue);
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
