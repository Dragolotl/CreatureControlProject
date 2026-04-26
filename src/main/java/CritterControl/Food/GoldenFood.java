package CritterControl.Food;

public class GoldenFood extends DecoratedFood {
    static int HEALTH_BONUS=5;

    public GoldenFood(Food food) {
        super(food);
    }
    @Override
    public int getHealthValue(){
        return food.getHealthValue() + HEALTH_BONUS;
    }
}
