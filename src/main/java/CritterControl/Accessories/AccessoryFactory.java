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

    public Accessory createAccessory(int level, int healthBoost) {
        String name = generateRandomNameBasedOnLevel(level);
        return new Accessory(name, healthBoost);
    }

    public Accessory createDefaultAccessory() {
        return createAccessory(DEFAULT_LEVEL, DEFAULT_HEALTH_BOOST);
    }

    //create an accessory of random level and stats
    public Accessory createRandomAccessory(int maxLevel) {
        int level = rand.nextInt(maxLevel) + 1;
        int randomHealthBoost = rand.nextInt(level);

        return createAccessory(level, randomHealthBoost);
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
