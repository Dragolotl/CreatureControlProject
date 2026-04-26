package CritterControl.Commands;

import CritterControl.CritterCorral;
import CritterControl.Food.Food;
import CritterControl.critters.Critter;

public class FeedCommand extends Command{
    private final Food food;
    private final CritterCorral corral;

    public FeedCommand(Critter critter, Food food, CritterCorral corral) {
        super(CommandType.FEED, critter);
        this.food=food;
        this.corral=corral;
    }

    public boolean execute() {
        if (food==null){
        return false;
        }
        critter.eat(food);
        corral.remove(food);
        return true;
    }
}
