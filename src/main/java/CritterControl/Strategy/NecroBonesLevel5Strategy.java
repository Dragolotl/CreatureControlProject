package CritterControl.Strategy;

import CritterControl.critters.Critter;

public class NecroBonesLevel5Strategy extends Level1Strategy {
    @Override
    public void drain(Critter opponent) {
        opponent.getStrategy().increaseCritterDamageReduction();
    }
}
