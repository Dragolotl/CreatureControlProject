package CritterControl.critters;

import CritterControl.Strategy.IStrategy;

public class Minitaur extends Critter {
    //Strength Critter
    public Minitaur(String name, int level) {
        super(name, level);
    }

    public Minitaur(String name){
        super(name);
    }

    @Override
    public void setStrategy() {
        setStrategyBasedOnLevel(strategyFactory.MinitaurLevel5Strategy(), strategyFactory.MinitaurLevel10Strategy() ); }


    @Override
    public int checkForTypeAdvantage(Critter opponent) {
        if (opponent.getCritterType() == CritterType.MAGIC) {
            return Critter.TYPE_ADVANTAGE_DAMAGE_BONUS;
        }

        return 0;
    }
}
