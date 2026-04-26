package CritterControl.critters;

public class NecroBones extends Critter {
    //Magic Critter
    public NecroBones(String name, int level) { super(name, level); }

    public NecroBones(String name) { super(name); }

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
        if (opponent.getCritterType() == CritterType.SPEED) {
            return Critter.TYPE_ADVANTAGE_DAMAGE_BONUS;
        }

        return 0;
    }
}
