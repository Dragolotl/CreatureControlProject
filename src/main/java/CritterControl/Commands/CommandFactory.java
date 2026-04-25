package CritterControl.Commands;

import CritterControl.Accessories.Accessory;
import CritterControl.CritterCorral;
import CritterControl.critters.Critter;

public class CommandFactory {
    public ICommand newWearCommand(Critter critter, CritterCorral corral, Accessory accessory) {
        return new WearCommand(critter, corral, accessory);
    }

    public ICommand newQuitCommand(Boolean isPlaying) {
        return new QuitCommand(isPlaying);
    }
}
