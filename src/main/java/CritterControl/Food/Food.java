package CritterControl.Food;

public class Food {
    private final String name;
    private final int healthValue;
    private final int happinessValue;// can be negative
    public Food(String name, int healthValue, int happinessValue){
        this.name=name;
        this.healthValue=healthValue;
        this.happinessValue=happinessValue;
    }
    public String getName(){
        return name;
    }
    public int getHealthValue(){
        return healthValue;
    }
    public int getHappinessValue(){
        return happinessValue;
    }
    @Override
    public String toString() {
        return name + " (health: " + healthValue + ", happiness: " + happinessValue + ")";
    }
}
