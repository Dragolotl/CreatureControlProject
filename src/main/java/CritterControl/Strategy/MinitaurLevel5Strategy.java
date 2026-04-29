package CritterControl.Strategy;

import CritterControl.critters.Critter;
import CritterControl.critters.Minitaur;
import org.slf4j.Logger;

public class MinitaurLevel5Strategy extends BaseStrategy {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(Minitaur.class);
    @Override
    public void tryStun(Critter opponent, int inputValue, int stunThreshold) {
        if (inputValue >= stunThreshold) {
            logger.info("You stunned {}!", opponent.getName());
            opponent.getStrategy().setStunned(true);
        }
    }
}
