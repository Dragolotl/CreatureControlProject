package CritterControl;

import java.util.Random;

public class Die {
    private final Random random = new Random();
    private final int numSides;

    public Die(int numSides) {
        this.numSides = numSides;
    }

    public static Die createDefaultDie() {
        return new Die(6);
    }

    public int roll() {
        return random.nextInt(numSides) + 1;
    }
}
