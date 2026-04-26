package CritterControl.critters;

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
        setStrategy(strategyFactory.MinitaurLevel5Strategy(), strategyFactory.MinitaurLevel10Strategy() );
    }
}
