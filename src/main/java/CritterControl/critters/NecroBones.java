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
    public void setStrategyBasedOnLevel(int level) {
        if (level < 5) {
            strategy = strategyFactory.Level1Strategy();
        } else if (level < 10) {
            strategy = strategyFactory.NecroBonesLevel5Strategy();
            setDie(new Die(4));
        } else {
            strategy = strategyFactory.NecroBonesLevel10Strategy();
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
