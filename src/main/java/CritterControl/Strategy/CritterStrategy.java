package CritterControl.Strategy;

import CritterControl.Commands.CommandFactory;
import CritterControl.critters.Critter;

import java.util.Random;

public abstract class CritterStrategy implements IStrategy{
    protected static final Random random = new Random();
    static protected CommandFactory commandFactory = new CommandFactory();
    //but how to take player input?

    //potentially we don't need these as strategies? It might be similar to HW 10
    public Icommand selectAction(Critter critter, String selectedAction){ //possibly take in player input too, we shall see
        //options to each different action
        //calls commands for eating, arena, and decorating
        switch (selectedAction){
            case "Feed":
                //call the feed action/command
                commandFactory.newFeedCommand(critter);
                //have a nested if statement checking if the player does have food in their stores
        }
    }

}
