package CritterControl.critters;

public class Velociraptor extends Critter {
    //Implementation TBD
    public Velociraptor(String name, int level) {
        super(name,level);
    }
    public Velociraptor(String name){super(name);}
    @Override
    public void setStrategy() {
        setStrategy(strategyFactory.VelociraptorLevel5Strategy(), strategyFactory.VelociraptorLevel10Strategy() );
    }
}
