package CritterControl.Strategy;

public class VelociraptorLevel5Strategy extends BaseStrategy {
    public static final int DODGE_DAMAGE_BONUS = 1;

    @Override
    public int addDodgeDamageBonus() {
        if (dodged()) {
            return DODGE_DAMAGE_BONUS;
        }

        return 0;
    }
}
