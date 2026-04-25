package CritterControl.Arena;

import CritterControl.critters.Critter;

import java.util.HashSet;

abstract public class Arena {
    //3 diffrent types of arena
    //each Critter should have their own Arenas attached(I think) - OR Each Critter has its own CritterCorral/Enclosure that holds everything!
    private Double difficultyLevel;
    private String type;
    //needs to contain modifiers for potential foes? Or does Arena possibly just need to be a single object more similar to Artifact rather than Maze?
    private Double modifier; //Or difficultyLevel IS the modifier?
    //List of prizes?
    //private Set<Hat> hats = new HashSet<>();

    //Constructor needs: Critter,
    //could put a method in Critter to retrieve its level
    public Arena(Double difficultyLevel, Double modifier) {
        this.difficultyLevel = difficultyLevel;
        this.modifier = modifier;
    }

    public void battle(Critter critter){
        //take the critter's level, or reference the difficulty level of the arena?
    }
    //WOULD A BUILDER BE GOOD FOR THE ARENA? THEN WE CAN BUILD WHAT LEVEL IT IS? Or does that overcomplicate things?

}

//Only hard-code 3 in ONE PLACE, maybe we have 3 in a list but we should make it super easy to add another arena to anywhere
//There should only be 1 place that knows where the arenas are and how many of them are there

//have a Critter game class that has the player, the critters,
//we'll need a player object that has a list of their critter objects (This will be part of HW 10)
//put the state in our game class, as we develop functionallity keep in mind the single-responsibility principle
//
