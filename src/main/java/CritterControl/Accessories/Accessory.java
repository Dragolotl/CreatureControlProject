package CritterControl.Accessories;

public record Accessory(String name, double healthBoost, double strengthBoost, double speedBoost, double magicBoost) {
    @Override
    public String toString() {
        return name;
    }
}
