package CritterControl.Strategy;

import CritterControl.critters.Critter;

public class Level1Strategy implements IStrategy {
    protected boolean isStunned = false;
    protected boolean dodged = false;
    protected int necrobonesDamageReduction = 0;

    public void tryStun(Critter opponent) { opponent.getStrategy().setStunned(false); }
    public void setStunned(boolean stunned) {isStunned = stunned;}
    public boolean isStunned() { return isStunned; }
    public void setDodged(boolean wasAttacked) { dodged = wasAttacked; }
    public boolean dodged() { return dodged; }
    public int getDamageReduction() { return necrobonesDamageReduction; }
    public void resetDamageReduction() { necrobonesDamageReduction = 0; }
}
