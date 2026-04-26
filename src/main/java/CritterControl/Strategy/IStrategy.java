package CritterControl.Strategy;

import CritterControl.critters.Critter;

public interface IStrategy {
    void tryStun(Critter opponent);
    void setStunned(boolean stunState);
    boolean isStunned();
    void setDodged(boolean dodged);
    boolean dodged();
    int getDamageReduction();
    void resetDamageReduction();
}

