package CritterControl.Commands;

import CritterControl.Accessories.Accessory;
import CritterControl.CritterCorral;
import CritterControl.Food.Food;
import CritterControl.critters.Critter;

import CritterControl.Accessories.Accessory;
import CritterControl.CritterCorral;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterType;

public class CommandFactory {
    public ICommand BattleCommand(Critter critter1, CritterType opponentType, CritterCorral corral) {
        return new BattleCommand(critter1, opponentType, corral);
    }

    public ICommand DressCommand(Critter critter, CritterCorral corral, Accessory accessory) {
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