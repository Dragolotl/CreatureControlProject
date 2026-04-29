package CritterControl.Strategy;

import CritterControl.critters.Critter;
import CritterControl.critters.Velociraptor;
import org.slf4j.Logger;

public class VelociraptorLevel5Strategy extends BaseStrategy {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(Velociraptor.class);
    public static final int DODGE_DAMAGE_BONUS = 1;

    @Override
    public int addDodgeDamageBonus() {
        if (dodged()) {
            logger.info("You dodged an attack! Your attack will deal additional damage!");
            return DODGE_DAMAGE_BONUS;
        }

        return 0;
    }
}
