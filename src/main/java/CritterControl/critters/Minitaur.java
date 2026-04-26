package CritterControl.critters;

public class Minitaur extends Critter {
    //Strength Critter
    public Minitaur(String name){ this(name, 1); }
    public Minitaur(String name, int level) {
        super(name, level);
        critterType = CritterType.STRENGTH;
    }

    @Override
    public void setStrategyBasedOnLevel(int level) {
        if (level < 5) {
            strategy = strategyFactory.Level1Strategy();
        } else if (level < 10) {
            strategy = strategyFactory.MinitaurLevel5Strategy();
        } else {
            strategy = strategyFactory.MinitaurLevel10Strategy();
        }
    }

    @Override
    public int checkForTypeAdvantage(Critter opponent) {
        if (opponent.getCritterType() == CritterType.MAGIC) {
            return Critter.TYPE_ADVANTAGE_DAMAGE_BONUS;
        }

        return 0;
    }
}
