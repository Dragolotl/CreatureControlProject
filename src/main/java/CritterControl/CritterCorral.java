package CritterControl;

import CritterControl.Accessories.Accessory;
import CritterControl.critters.Critter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CritterCorral {
    private final List<Critter> critters = new ArrayList<>();
    private final List<Accessory> wardrobe = new ArrayList<>();

    public CritterCorral() {
    }

    public CritterCorral(List<Critter> critterList) {
        for (Critter critter: critterList) {
            add(critter);
        }
    }

    public void add(Critter critter) {
        critters.add(critter);
    }
    public void add(Accessory accessory) { wardrobe.add(accessory); }

    public void remove(Critter critter) {
        if (contains(critter)) {
            critters.remove(critter);
        } else {
            throw new NoSuchElementException(critter.getName() + "does not exist!");
        }
    }

    public void remove(Accessory accessory) {
        if (contains(accessory)) {
            wardrobe.remove(accessory);
        } else {
            throw new NoSuchElementException(accessory.name() + "does not exist!");
        }
    }

    public void replace(Critter originalCritter, Critter newCritter) {
        if (contains(originalCritter)) {
            remove(originalCritter);
            critters.add(newCritter);
        }
    }

    public boolean contains(Critter critter) { return critters.contains(critter); }
    public boolean contains(Accessory accessory) { return wardrobe.contains(accessory); }


    public Optional<Critter> getCritter(String name) {
        return critters.stream().filter(critter -> critter.getName().equals(name)).findFirst();
    }

    public List<Critter> getCritters() {
        return critters;
    }
}
