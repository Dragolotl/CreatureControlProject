package CritterControl.Food;

public class Food {
    private final String name;
    private final int happinessValue;
    private final int level;
    public Food(String name, int happinessValue, int level){
        this.name=name;
        this.happinessValue=happinessValue;
        this.level=level;
    }
    public String getName(){
        return name;
    }

    public int getHappinessValue(){
        return happinessValue;
    }
    @Override
    public String toString() {
        return name + " (happiness: " + happinessValue + ")";
    }

    public int getLevel() {
        return level;
    }
}
