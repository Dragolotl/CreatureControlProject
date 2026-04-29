package CritterControl.critters;

import CritterControl.Strategy.IStrategy;

public class Velociraptor extends Critter {
    //Implementation TBD
    public Velociraptor(String name, int level) {
        super(name,level);
        critterType = CritterType.SPEED;
    }


    public Velociraptor(String name){
        super(name);
        critterType = CritterType.SPEED;
    }


    @Override
    public void setStrategy() {
        setStrategyBasedOnLevel(strategyFactory.VelociraptorLevel5Strategy(), strategyFactory.VelociraptorLevel10Strategy() );
    }

    @Override
    public int checkForTypeAdvantage(Critter opponent) {
        if (opponent.getCritterType() == CritterType.STRENGTH) {
            return Critter.TYPE_ADVANTAGE_DAMAGE_BONUS;
        }

        return 0;
    }


}
