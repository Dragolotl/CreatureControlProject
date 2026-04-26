package CritterControl.Food;

public class RainbowFood extends DecoratedFood {
    static int HAPPINESS_BONUS=5;

    public RainbowFood(Food food) {
        super(food);
    }
    @Override
    public int getHappinessValue(){
        return food.getHappinessValue() + HAPPINESS_BONUS;
    }
}
