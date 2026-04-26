package CritterControl.Garden;

import CritterControl.Food.Food;
import CritterControl.Food.FoodFactory;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private final String name;
    private final Food foodType;
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
        foodGrown+=1;
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
