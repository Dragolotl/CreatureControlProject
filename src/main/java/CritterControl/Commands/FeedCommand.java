package CritterControl.Commands;

public class FeedCommand extends Command{

    //food object? This will probably interact with one specific food rather than the whole garden
    public FeedCommand(Critter critter) { //possibly have a parameter for garden? Will Garden be its own thing or part of the CritterCorral?
        super(CommandType.FEED, critter);
    }
}
