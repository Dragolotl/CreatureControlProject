package CritterControl.critters;

public class Velociraptor extends Critter {
    //Speed Critter
    public Velociraptor(String name) { this(name, 1); }

    public Velociraptor(String name, int level) {
        super(name, level);
        critterType = CritterType.SPEED;
    }

    @Override
    public void setStrategyBasedOnLevel(int level) {
        if (level < 5) {
            strategy = strategyFactory.Level1Strategy();
        } else if (level < 10) {
            strategy = strategyFactory.VelociraptorLevel5Strategy();
        } else {
            strategy = strategyFactory.VelociraptorLevel10Strategy();
        }
    }

    @Override
    public int checkForTypeAdvantage(Critter opponent) {
        if (opponent.getCritterType() == CritterType.STRENGTH) {
            return Critter.TYPE_ADVANTAGE_DAMAGE_BONUS;
        }

        return 0;
    }
}
