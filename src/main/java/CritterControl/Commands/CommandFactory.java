package CritterControl.Commands;

import CritterControl.Accessories.Accessory;
import CritterControl.CritterCorral;
import CritterControl.Food.Food;
import CritterControl.critters.Critter;

public class CommandFactory {
    public ICommand newWearCommand(Critter critter, CritterCorral corral, Accessory accessory) {
        return new WearCommand(critter, corral, accessory);
    }

    public ICommand newFeedCommand(Critter critter, Food food, CritterCorral corral) {
        return new FeedCommand(critter, food, corral);
    }

    public ICommand newQuitCommand(Boolean isPlaying) {
        return new QuitCommand(isPlaying);
    }
}