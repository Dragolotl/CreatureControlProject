package CritterControl.Food;

public abstract class DecoratedFood extends Food {
    protected Food food;
    public DecoratedFood(Food food){
        super(food.getName(), food.getHappinessValue(),food.getLevel());
        this.food = food;
    }
}
