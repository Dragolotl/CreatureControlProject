package CritterControl.Food;

public class GoldenFood extends DecoratedFood {
    static int HAPPINESS_BONUS=10;

    public GoldenFood(Food food) {
        super(food);
    }
    @Override
    public int getHappinessValue(){
        return food.getHappinessValue() + HAPPINESS_BONUS;
    }
}
