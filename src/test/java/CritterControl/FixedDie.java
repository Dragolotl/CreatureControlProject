package CritterControl;

public class FixedDie extends Die{
    public FixedDie(int numSides) {
        super(numSides);
    }

    @Override
    public int roll() {
        return getNumSides();
    }
}
