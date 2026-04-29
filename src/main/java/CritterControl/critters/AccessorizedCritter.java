package CritterControl.critters;

import CritterControl.Accessories.Accessory;
import CritterControl.Strategy.IStrategy;

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
        return myself.getBaseName();
    }

    @Override
    public int getHealth() {
        return myself.getHealth() + accessory.healthBoost();
    }

    @Override
    public int getLevel() {
        return myself.getLevel();
    }

    @Override
    public boolean isAlive() {
        return myself.isAlive();
    }

    @Override
    public int getHappiness() {
        return myself.getHappiness();
    }

    @Override
    public Accessory getAccessory () {
        return accessory;
    }

    @Override
    public IStrategy getStrategy () {
        return myself.getStrategy();
    }

    @Override
    public void setHealth(int healthValue) {
        myself.setHealth(healthValue);
    }

    @Override
    public void setHappiness(int happinessValue) {
        myself.setHappiness(happinessValue);
    }

    @Override
    public void levelUp() { myself.levelUp(); }

    @Override
    public void setStrategy() {
        myself.setStrategy();
    }

    @Override
    public boolean isAccessorized() {
        return true;
    }

    @Override
    public int checkForTypeAdvantage(Critter opponent) {
        return myself.checkForTypeAdvantage(opponent);
    }
//    @Override
//    public void setStrategyBasedOnLevel(int level) {
//        myself.setStrategyBasedOnLevel(level);
//    }
}
