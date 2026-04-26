package CritterControl.Food;

public class RottenFood extends DecoratedFood {
    static int HEALTH_BONUS=-5;
    static int HAPPINESS_BONUS=-10;

    public RottenFood(Food food) {
        super(food);
    }
    @Override
    public int getHealthValue(){
        return food.getHealthValue() + HEALTH_BONUS;

    }
    @Override
    public int getHappinessValue(){
        return food.getHappinessValue()+HAPPINESS_BONUS;
    }
}
