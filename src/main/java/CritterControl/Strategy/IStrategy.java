package CritterControl.Strategy;

import CritterControl.Commands.ICommand;
import CritterControl.critters.Critter;

public interface IStrategy {
    void damage(Critter opponent);
    void dodge(boolean wasAttacked);
    void setStunned(boolean stunState);
    boolean isStunned();
}

