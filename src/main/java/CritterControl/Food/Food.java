package CritterControl.Food;

public class Food {
    private final String name;
//    private final int healthValue;
    private final int happinessValue;// can be negative
    private final int level;
    public Food(String name, int happinessValue, int level){
        this.name=name;
//        this.healthValue=healthValue;
        this.happinessValue=happinessValue;
        this.level=level;
    }
    public String getName(){
        return name;
    }
//    public int getHealthValue(){
//        return healthValue;
//    }
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
