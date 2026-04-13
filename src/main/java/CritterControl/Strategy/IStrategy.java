package CritterControl.Strategy;

import CritterControl.Commands.ICommand;
import CritterControl.critters.Critter;

public interface IStrategy {
    ICommand selectAction(Critter critter);
    default boolean isFighter() { return false; }
    default boolean isSeeker() { return false; };
    default boolean isGuard() { return false; };
    default boolean isCoward() { return false; };
    default boolean isGlutton() { return false; };
}

