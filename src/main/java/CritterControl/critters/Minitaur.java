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
    public void setStrategyBasedOnLevel(int level) {
        if (level < 5) {
            strategy = strategyFactory.Level1Strategy();
        } else if (level < 10) {
            strategy = strategyFactory.MinitaurLevel5Strategy();
        } else {
            strategy = strategyFactory.MinitaurLevel10Strategy();
        }
    }
}
