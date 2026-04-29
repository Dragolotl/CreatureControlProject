package CritterControl.Food;

public class RottenFood extends DecoratedFood {
    static int HAPPINESS_BONUS=-10;

    public RottenFood(Food food) {
        super(food);
    }

    @Override
    public int getHappinessValue(){
        return food.getHappinessValue()+HAPPINESS_BONUS;
    }
}