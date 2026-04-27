package CritterControl.Commands;

import CritterControl.Accessories.Accessory;
import CritterControl.CritterCorral;
import CritterControl.Food.Food;
import CritterControl.Garden.Garden;
import CritterControl.critters.Critter;
import CritterControl.Commands.ICommand;

import CritterControl.Accessories.Accessory;
import CritterControl.CritterCorral;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterType;

public class CommandFactory {
    public ICommand newBattleCommand(Critter critter1, Critter opponentCritter, Garden garden) {
        return new BattleCommand(critter1, opponentCritter, garden);
    }

    public ICommand newDressCommand(Critter critter, CritterCorral corral, Accessory accessory) {
        return new DressCommand(critter, corral, accessory);
    }

    public ICommand newQuitCommand(Boolean isPlaying) {
        return new QuitCommand(isPlaying);
    }
}
    public ICommand newFeedCommand(Critter critter, Food food, CritterCorral corral) {
        return new FeedCommand(critter, food, corral);
    }

    public ICommand newQuitCommand(Boolean isPlaying) {
        return new QuitCommand(isPlaying);
    }

}