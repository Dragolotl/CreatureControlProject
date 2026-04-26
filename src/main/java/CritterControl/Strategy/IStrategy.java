package CritterControl.Strategy;

import CritterControl.critters.Critter;

public interface IStrategy {
    void tryStun(Critter opponent, int inputValue, int stunThreshold);
    void setStunned(boolean stunState);
    boolean isStunned();
    void setDodged(boolean dodged);
    boolean dodged();
    int addDodgeDamageBonus();
    void drain(Critter opponent);
    int shouldStealEnemyDamage();
    void increaseCritterDamageReduction();
    int getDamageReduction();
    void resetDamageReduction();
}

