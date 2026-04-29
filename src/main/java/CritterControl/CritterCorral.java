package CritterControl;

import CritterControl.Accessories.Accessory;
import CritterControl.Accessories.Accessory;
import CritterControl.Food.Food;
import CritterControl.critters.Critter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CritterCorral {
    private final List<Critter> critters = new ArrayList<>();
    private final List<Accessory> wardrobe = new ArrayList<>();
    private final List<Food> kitchen = new ArrayList<>();

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
    public void add(Food food){ kitchen.add(food);}

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
    public boolean contains(Food food){return kitchen.contains(food);}


    public void remove(Food food){
        if (contains(food)){
            kitchen.remove(food);
        }
        else {
            throw new NoSuchElementException(food.getName() + "does not exist");
        }
    }


    public Optional<Critter> getCritterByName(String name) {
        return critters.stream().filter(critter -> critter.getName().equals(name)).findFirst();
    }

    public Critter getCritterByIndex(int index) {
        if (index < 0 || index >= critters.size()) {
            return null;
        } else {
            return critters.get(index);
        }
    }

    public List<Critter> getCritters() {
        return critters;
    }

    public List<Accessory> getWardrobe() { return wardrobe; }

    public boolean printAllAccessories(){
        if(wardrobe.isEmpty()){
            System.out.println("Your wardrobe is empty! Try again when you have accessories.");
            return false;
        }else{
            for (int i = 0; i < wardrobe.size(); i++) {
                System.out.println((i) + ": " + wardrobe.toArray()[i]);
            }
            return true;
        }
    }

    public Accessory getAccessoryByIndex(int index) {
        if (index < 0 || index >= wardrobe.size()) {
            return null;
        }else{
            return wardrobe.get(index);
        }
    }

    public List<Food> getKitchen(){
        return kitchen;
    }

    public boolean printAllFood(){
        if(kitchen.isEmpty()){
            System.out.println("Your kitchen is empty! Try again when you get food.");
            return false;
        }else{
            for (int i = 0; i < kitchen.size(); i++) {
                System.out.println((i) + ": " + kitchen.toArray()[i]);
            }
            return true;
        }
    }

    public Food getFoodByIndex(int index) {
        if (index < 0 || index >= kitchen.size()) {
            return null;
        }else{
            return kitchen.get(index);
        }
    }
}
