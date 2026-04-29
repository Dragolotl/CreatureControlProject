package CritterControl.Food;

import CritterControl.Die;

public class FoodFactory {

    private static final int DEFAULT_DIE_SIZE = 20;

    private final Die die;

    public FoodFactory() {
        this(new Die(DEFAULT_DIE_SIZE));
    }

    public FoodFactory(Die die) {
        this.die = die;
    }

    public Food createFood(FoodType type) {
        Food baseFood = type.createFood();
        return createDecoratedFood(baseFood);
    }

    private Food createDecoratedFood(Food baseFood) {
        int roll = die.roll();

        if (roll == 20) {
            return new GoldenFood(baseFood);
        }
        if (roll == 19) {
            return new RainbowFood(baseFood);
        }
        if (roll == 1) {
            return new RottenFood(baseFood);
        }

        return baseFood;
    }

    public Food createRandomFood(Integer maxLevel) {
        return FoodType.createRandomFoodBasedOnLevel(maxLevel);
    }
}