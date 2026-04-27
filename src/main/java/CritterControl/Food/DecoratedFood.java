package CritterControl.Food;

public abstract class DecoratedFood extends Food {
    protected Food food;
    public DecoratedFood(Food food){
        super(food.getName(), food.getHealthValue(),food.getHappinessValue());
        this.food = food;
    }
}
