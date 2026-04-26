package CritterControl.Strategy;

import CritterControl.critters.Critter;

public class MinitaurLevel10Strategy extends MinitaurLevel5Strategy {


    @Override
    public void tryStun(Critter opponent, int inputValue, int stunThreshold) {
        //-1 makes it easier to stun
        //Need to roll less to stun opponent
        if (inputValue >= stunThreshold - 1) {
            opponent.getStrategy().setStunned(true);
        }
    }
}
