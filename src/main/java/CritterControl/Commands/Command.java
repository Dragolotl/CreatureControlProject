package CritterControl.Commands;

import CritterControl.critters.Critter;

public abstract class Command implements ICommand {
    protected CommandType type;
    protected final Critter critter;

    public Command(CommandType type, Critter critter) { //potentially have a parameter for the Corral too?
        this.type = type;
        this.critter = critter;
    }


}
