package CritterControl.Commands;

import CritterControl.critters.Critter;

public class CheckCritterCommand implements ICommand{
    Critter critter;

    public CheckCritterCommand(Critter currentCritter) {
        critter = currentCritter;
    }

    @Override
    public boolean execute(){
        System.out.println(critter.getName() + " stats.");
        System.out.println("Level: " + critter.getLevel());
        System.out.println("Type: " + critter.getCritterType());
        if(critter.isAccessorized()){
            System.out.println("Wearing: " + critter.getAccessory().name());
        }
        System.out.println(critter.getName() + " is glad you checked in!");
        return true;
    }
}
