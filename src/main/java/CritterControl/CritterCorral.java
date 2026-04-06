package CritterControl;

import CritterControl.critters.Critter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CritterCorral {
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

    public void removeCritter(Critter critter) {
        if (critters.contains(critter)) {
            critters.remove(critter);
        } else {

        }
    }

    public Optional<Critter> getCritter(String name) {
        return critters.stream().filter(critter -> critter.getName().equals(name)).findFirst();
    }

    public List<Critter> getCritters() {
        return critters;
    }
}
