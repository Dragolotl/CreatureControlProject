package CritterControl.Accessories;

public class AccessoryFactory {
    private final static double DEFAULT_HEALTH_BOOST = 0.0;
    private final static double DEFAULT_STRENGTH_BOOST = 0.0;
    private final static double DEFAULT_SPEED_BOOST = 0.0;
    private final static double DEFAULT_MAGIC_BOOST = 0.0;

    public Accessory createDefaultAccessory(String name) {
        return createAccessory(name, DEFAULT_HEALTH_BOOST, DEFAULT_STRENGTH_BOOST, DEFAULT_SPEED_BOOST, DEFAULT_MAGIC_BOOST);
    }

    public Accessory createAccessory(String name, double healthBoost, double strengthBoost, double speedBoost, double magicBoost) {
        return new Accessory(name, healthBoost, strengthBoost, speedBoost, magicBoost);
    }
}
