package CritterControl.critters;

public class CritterFactory {
    public Critter createCritterType1(String name) {
        return new Minitaur(name);
    }

    public Critter createCritterType2(String name) {
        return new CritterType2(name);
    }

    public Critter createCritterType3(String name) {
        return new CritterType3(name);
    }
}
