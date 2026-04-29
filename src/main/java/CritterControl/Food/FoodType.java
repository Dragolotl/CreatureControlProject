package CritterControl.Food;

import java.util.Random;

public enum FoodType {
    APPLE("Apple", 5, 1),
    CUPCAKE("Cupcake",15,7),
    BROCCOLI("Strawberry", 10, 4);
    private static final Random rand = new Random();
    private final String name;
    private final int happinessValue;
    private final int level;
    FoodType(String name, int happinessValue, int level) {
        this.name = name;
        this.happinessValue = happinessValue;
        this.level=level;
    }

    public Food createFood() {
        return new Food(name, happinessValue, level);
    }

    public int getLevel() {
        return level;
    }
    public static Food createRandomFoodBasedOnLevel(int maxLevel){
        FoodType[] foods = values();
        FoodType randomFoodType =foods[rand.nextInt(foods.length)];
        while (maxLevel < randomFoodType.getLevel()){
            randomFoodType = foods[rand.nextInt(foods.length)];
        }
        return randomFoodType.createFood();
    }

}