package CritterControl.Food;

import CritterControl.Die;

public class FoodFactory {
    private final Die die;

    // should use a D20
    public FoodFactory(Die die) {
        this.die = die;
    }

    public Food createFood(Food baseFood) {
        int roll = die.roll();

        if (roll == 20) {
            return new GoldenFood(baseFood);
        }
        if (roll==19){
            return new RainbowFood(baseFood);
        }
        if (roll == 1) {
            return new RottenFood(baseFood);
        }

        return baseFood;
    }
}