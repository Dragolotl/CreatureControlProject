package CritterControl.Food;

public class Food {
    private final String name;
    private final Double healthValue;
    private final Double happinessValue; // can be negative
    public Food(String name, Double healthValue, Double happinessValue){
        this.name=name;
        this.healthValue=healthValue;
        this.happinessValue=happinessValue;
    }
    public String getName(){
        return name;
    }
    public Double getHealthValue(){
        return healthValue;
    }
    public Double getHappinessValue(){
        return happinessValue;
    }
}
