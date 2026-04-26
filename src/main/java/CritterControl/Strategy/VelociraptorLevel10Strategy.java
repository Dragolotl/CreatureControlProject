package CritterControl.Strategy;

public class VelociraptorLevel10Strategy extends VelociraptorLevel5Strategy {
    @Override
    public int addDodgeDamageBonus() {
        if (dodged()) {
            return 4;
        }

        return 0;
    }
}
