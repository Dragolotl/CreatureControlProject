package CritterControl.Strategy;

import CritterControl.critters.Critter;

public class NecroBonesLevel5Strategy extends BaseStrategy {
    @Override
    public void drain(Critter opponent) {
        opponent.getStrategy().increaseCritterDamageReduction();
    }
}
