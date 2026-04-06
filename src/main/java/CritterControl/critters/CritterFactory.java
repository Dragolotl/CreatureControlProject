package CritterControl.critters;

public class CritterFactory {
    protected static final double MINITAUR_DEFAULT_HEALTH = 5.0;

    public Critter createMinitaur(String name) {
        return new Minitaur(name, MINITAUR_DEFAULT_HEALTH);
    }

    public Critter createCritterType2(String name) {
        return new CritterType2(name);
    }

    public Critter createCritterType3(String name) {
        return new CritterType3(name);
    }
}
