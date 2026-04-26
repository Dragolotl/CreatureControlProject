package CritterControl.Strategy;

public class VelociraptorLevel5Strategy extends BaseStrategy {
    @Override
    public int addDodgeDamageBonus() {
        if (dodged()) {
            return 2;
        }

        return 0;
    }
}
