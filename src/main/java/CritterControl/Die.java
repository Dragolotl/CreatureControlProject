package CritterControl;

import java.util.Random;

public class Die {
    public static int DEFAULT_MAX_VALUE = 6;
    private final Random random = new Random();
    private final int numSides;

    public Die(int numSides) {
        this.numSides = numSides;
    }

    public static Die createDefaultDie() {
        return new Die(DEFAULT_MAX_VALUE);
    }

    public int roll() {
        return random.nextInt(numSides) + 1;
    }

    public int getNumSides() { return numSides; }
}
