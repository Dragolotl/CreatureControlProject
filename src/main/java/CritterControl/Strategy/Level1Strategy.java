package CritterControl.Strategy;

import CritterControl.critters.Critter;

public class Level1Strategy implements IStrategy {
    protected boolean isStunned = false;
    protected boolean dodged = false;
    protected int necrobonesDamageReduction = 0;

    public void setStunned(boolean stunState) {
        isStunned = stunState;
    }
    public boolean isStunned() { return isStunned; }
    public void setDodged(boolean wasAttacked) { dodged = wasAttacked; }
    public boolean dodged() { return dodged; }
    public int getDamageReduction() { return necrobonesDamageReduction; }
    public void resetDamageReduction() { necrobonesDamageReduction = 0; }
}
