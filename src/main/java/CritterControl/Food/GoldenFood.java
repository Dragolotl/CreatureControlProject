package CritterControl.Food;

public class GoldenFood extends DecoratedFood {


    public GoldenFood(Food food) {
        super(food);
    }
    @Override
    public double getHealthValue(){
        return food.getHealthValue() + 5;
    }
}
