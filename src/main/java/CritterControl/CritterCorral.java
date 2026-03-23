package CritterControl;

import CritterControl.critters.Critter;

import java.util.ArrayList;
import java.util.List;

public class CritterCorral {
    //Not sure if class is necessary yet
    //Intent: move critter storage out of CritterControl file in compliance with Single Responsibility Principle

    //Maybe implement a default starting corral for when the game is played...
    private final List<Critter> critters = new ArrayList<>();

    public CritterCorral() {
    }

    public CritterCorral(List<Critter> critterList) {
        for (Critter critter: critterList) {
            addCritter(critter);
        }
    }

    public void addCritter(Critter critter) {
        critters.add(critter);
    }
}
