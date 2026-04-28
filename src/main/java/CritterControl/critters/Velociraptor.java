package CritterControl.critters;

public class Velociraptor extends Critter {
    //SPEED CRITTER
    public Velociraptor(String name){ this(name, 1); }
    public Velociraptor(String name, int level) {
        super(name,level);
        this.critterType = CritterType.SPEED;
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
