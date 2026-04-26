package CritterControl.Commands;

import CritterControl.critters.Critter;

public class FeedCommand extends Command{

    //food object? This will probably interact with one specific food rather than the whole garden
    public FeedCommand(Critter critter) { //possibly have a parameter for garden? Will Garden be its own thing or part of the CritterCorral?
        super(CommandType.FEED, critter);
    }

    public boolean execute() {
        return false;
        //have access to garden, pick food and feed it to creature-is this too much in one command?
    }
}
