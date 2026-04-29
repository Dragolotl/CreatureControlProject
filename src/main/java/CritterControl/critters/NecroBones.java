package CritterControl.critters;

import CritterControl.Die;

public class NecroBones extends Critter {
    //Magic Critter
    public NecroBones(String name) { this(name, 1); }
    public NecroBones(String name, int level) {
        super(name, level);
        critterType = CritterType.MAGIC;
    }

    @Override
    public void setStrategy() {
        setStrategyBasedOnLevel(strategyFactory.NecroBonesLevel5Strategy(), strategyFactory.NecroBonesLevel10Strategy());
        if (getLevel() == 5) {
            setDie(new Die(4));
        }
    }

    @Override
    public int checkForTypeAdvantage(Critter opponent) {
        if (opponent.getCritterType() == CritterType.SPEED) {
            return Critter.TYPE_ADVANTAGE_DAMAGE_BONUS;
        }

        return 0;
    }
}