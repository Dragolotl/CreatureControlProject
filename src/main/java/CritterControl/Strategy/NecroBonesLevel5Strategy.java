package CritterControl.Strategy;

import CritterControl.critters.Critter;
import CritterControl.critters.NecroBones;
import org.slf4j.Logger;

public class NecroBonesLevel5Strategy extends BaseStrategy {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(NecroBones.class);
    private static final int MAX_DAMAGE_REDUCTION = 3;
    @Override
    public void drain(Critter opponent) {
        logger.info("{} was drained! It's damage will be reduced...", opponent.getName());
        if (opponent.getStrategy().getDamageReduction() < MAX_DAMAGE_REDUCTION) {
            opponent.getStrategy().increaseCritterDamageReduction();
        }
    }
}
