package CritterControl.Strategy;

import CritterControl.critters.Critter;

public class MinitaurLevel5Strategy extends BaseStrategy {
    @Override
    public void tryStun(Critter opponent, int inputValue, int stunThreshold) {
        if (inputValue >= stunThreshold) {
            opponent.getStrategy().setStunned(true);
        }
    }
}
