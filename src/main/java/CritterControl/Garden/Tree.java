package CritterControl.Garden;

import CritterControl.Food.Food;
import CritterControl.Food.FoodFactory;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private static final int GROWTH_RATE = 1;
    private static final int TURNS_TO_GROW = 3;
    // could potentially add max food, per tree
    // maybe there's a maximum number of trees you can harvest from between combats,
    // if we had more time we could've implemented a time system but that's way beyond what we have
    private final String name;
    private final Food foodType;
    private int growCounter = 0;
    private int foodGrown = 0; // all trees start with no food
    private final FoodFactory foodFactory;

    public Tree(String name, Food foodType, FoodFactory foodFactory){
        this.name=name;
        this.foodType=foodType;
        this.foodFactory=foodFactory;
    }

    public String getName(){
        return name;
    }
    public int getFoodGrown(){
        return foodGrown;
    }


    public void grow(){
        // can make more complex later, maybe each tree has a different amount of turns to grow
        // also can add randomness later
        growCounter++;
        if (growCounter >= TURNS_TO_GROW) {
            foodGrown += GROWTH_RATE;
            growCounter = 0;
        }
    }

    public List<Food> harvest(){
        // harvest all food
        List<Food> foodBasket = new ArrayList<>();
        for (int i =0; i<foodGrown; i++){
            foodBasket.add(foodFactory.createFood(foodType));
        }
        foodGrown=0;
        return foodBasket;
    }
}
