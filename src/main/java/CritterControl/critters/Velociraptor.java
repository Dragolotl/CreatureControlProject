package CritterControl.critters;

import CritterControl.Strategy.IStrategy;

public class Velociraptor extends Critter {
    //Implementation TBD
    public Velociraptor(String name, int level) {
        super(name,level);
    }


    public Velociraptor(String name){super(name);}
    @Override
    public void setStrategy() {
        setStrategyBasedOnLevel(strategyFactory.VelociraptorLevel5Strategy(), strategyFactory.VelociraptorLevel10Strategy() );
    }

    @Override
    public int checkForTypeAdvantage(Critter opponent) {
        return 0;
    }


}
