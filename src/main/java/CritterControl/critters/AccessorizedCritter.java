package CritterControl.critters;

import CritterControl.Accessories.Accessory;

public class AccessorizedCritter extends Critter {
    private Critter myself;
    private Accessory accessory;

    public AccessorizedCritter(Critter myself, Accessory accessory) {
        this.myself = myself;
        this.accessory = accessory;
    }

    @Override
    public String getName() {
        return getBaseName() + ", " + accessory.getName();
    }

    public String getBaseName() {
        return myself.getName();
    }

    @Override
    public double getHealth() {
        return myself.getHealth();
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
    public void setHealth(Double healthValue) {
        myself.setHealth(healthValue);
    }

    @Override
    public void setHappiness(Double happinessValue) {
        myself.setHappiness(happinessValue);
    }



}
