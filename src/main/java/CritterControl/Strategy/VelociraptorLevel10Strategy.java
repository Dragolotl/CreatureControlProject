package CritterControl.Strategy;

public class VelociraptorLevel10Strategy extends VelociraptorLevel5Strategy {
    @Override
    public int addDodgeDamageBonus() {
        if (dodged()) {
            return 2 * VelociraptorLevel5Strategy.DODGE_DAMAGE_BONUS;
        }

        return 0;
    }
}
