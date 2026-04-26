package CritterControl.critters;

import CritterControl.Accessories.Accessory;
import org.slf4j.Logger;

public class CritterFactory {
    protected static final double MINITAUR_DEFAULT_HEALTH = 5.0;

    public Critter createMinitaur(String name) {
        return new Minitaur(name, MINITAUR_DEFAULT_HEALTH);
    }

    public Critter createNecroBones(String name) {
        return new NecroBones(name);
    }

    public Critter createCritterType3(String name) {
        return new CritterType3(name);
    }

    public Critter createAccessorizedCritter(Critter myself, Accessory accessory) {
        return new AccessorizedCritter(myself, accessory);
    }
  
    public Critter createCritter(CritterType type) {
        return switch (type) {
            case STRENGTH -> new Minitaur("Manny");
            case MAGIC -> new NecroBones("Bones");
            case SPEED -> new CritterType3("Sonic");
//            default:
//                System.out.println("Invalid Critter type.");

        };
    }
}
