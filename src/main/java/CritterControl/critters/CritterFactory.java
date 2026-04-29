package CritterControl.critters;

import CritterControl.Accessories.Accessory;

public class CritterFactory {
    public Critter createMinitaur(String name) {
        return new Minitaur(name);
    }
    public Critter createMinitaur(String name, int level ) {
        return new Minitaur(name, level);
    }

    public Critter createVelociraptor(String name) {
        return new Velociraptor(name);
    }
    public Critter createVelociraptor(String name, int level ) {
        return new Velociraptor(name, level);
    }

    public Critter createNecroBones(String name) {
        return new NecroBones(name);
    }
    public Critter createNecroBones(String name, int level ) {
        return new NecroBones(name, level);
    }

    public Critter createAccessorizedCritter(Critter myself, Accessory accessory) {
        return new AccessorizedCritter(myself, accessory);
    }
  
    public Critter createCritter(CritterType type) {
        return createCritter(type, 1);
    }

    public Critter createCritter(CritterType type, int level) {
        Critter critter = switch (type) {
            case STRENGTH -> createMinitaur("Manny", level);
            case SPEED -> createVelociraptor("Sonic", level);
            case MAGIC -> createNecroBones("Bones", level);
//            default:
//                System.out.println("Invalid Critter type.");

        };
        critter.setStrategy();
        return critter;
    }
}
