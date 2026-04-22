package CritterControl.critters;

import CritterControl.Accessories.Accessory;

public class AccessorizedCritter extends Critter {
    private final Critter myself;
    private final Accessory accessory;

    public AccessorizedCritter(Critter myself, Accessory accessory) {
        this.myself = myself;
        this.accessory = accessory;
    }

    @Override
    public String getName() {
        return getBaseName() + ", " + accessory.name();
    }

    @Override
    public String getBaseName() {
        return myself.getName();
    }

    @Override
    public double getHealth() {
        return myself.getHealth() + accessory.healthBoost();
    }

    @Override
    public int getLevel() {
        return myself.getLevel();
    }

    @Override
    public Double getHappiness() {
        return myself.getHappiness();
    }

    @Override
    public Accessory getAccessory () {
        return accessory;
    }

    @Override
    public void setHealth(Double healthValue) {
        myself.setHealth(healthValue);
    }

    @Override
    public void setHappiness(Double happinessValue) {
        myself.setHappiness(happinessValue);
    }

    @Override
    public boolean isAccessorized() {
        return true;
    }


}
