package CritterControl.Strategy;

public class VelociraptorLevel5Strategy extends Level1Strategy {
    @Override
    public int addDodgeDamageBonus() {
        if (dodged()) {
            return 2;
        }

        return 0;
    }
}
