package CritterControl.Strategy;

import CritterControl.critters.Critter;

public class NecroBonesLevel10Strategy extends NecroBonesLevel5Strategy {
    @Override
    public int shouldStealEnemyDamage() {
        return 1;
    }
}
