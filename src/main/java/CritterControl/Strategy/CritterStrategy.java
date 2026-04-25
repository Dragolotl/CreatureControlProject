package CritterControl.Strategy;

import CritterControl.critters.Critter;

public abstract class CritterStrategy implements IStrategy{
    protected boolean isStunned;
    protected boolean dodged;
    protected int necrobonesDamageReduction;

    public abstract void damage(Critter opponent);

    public abstract void dodge(boolean wasAttacked);

    public void setStunned(boolean stunState) {
        isStunned = stunState;
    }
    public boolean isStunned() {
        return isStunned;
    }
}
