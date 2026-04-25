package CritterControl.critters;

import CritterControl.Accessories.Accessory;
import CritterControl.Food.Food;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

abstract public class Critter {
    protected static final double DEFAULT_HAPPINESS=100.0;
    protected static final double DEFAULT_HEALTH = 5;
    protected String name;
    private Double health;
    private int level;
    //Include a map that has the arena levels in it
    private final Map<String, Integer> arenaLevel = new ConcurrentHashMap<>(); //<Type, Level>
    private Double happiness; //TODO - IS HAPPINESS STILL A FACTOR IN THIS GAME?

    public Critter() {}

    public Critter(String name){
        this(name, DEFAULT_HEALTH);
    }

    public Critter(String name, Double health) {
        this.name = name;
        this.health = health;
        this.happiness = DEFAULT_HAPPINESS;
    }

    public Critter(String name, Double health, int level){
        this.name = name;
    }

    public String getName(){
        return name;
    };
    public String getBaseName() { return name; }
    public double getHealth(){
        return health;
    }
    public int getLevel() { return level; }
    public void setHealth(Double healthValue) { this.health = healthValue; }
    public void setHappiness(Double happinessValue) {
        this.happiness = happinessValue;
        if (getHappiness() > 100.0){
            setHappiness(100.0);
        }

        if (getHappiness() < 0.0) {
            setHappiness(0.0);
        }
    }

    //Is this how eating works with the game as it is?
    //TODO - DECIDE HOW EAT SHOULD WORK
    public void eat(Food food){
        addHealth(food.getHealthValue());
        setHappiness(getHappiness() + food.getHappinessValue());
    }

    public void addHealth(Double healthGained) {
        setHealth(getHealth() + healthGained);
    }

    public void loseHealth(Double healthLost) {
        if (getHealth() <= 0) {
            // already dead, probably called for mandatory health loss for having a fight
            return;
        }

        setHealth(getHealth() - healthLost);
    }

    public Double getHappiness() {
        return happiness;
    }

    public Accessory getAccessory() {
        return null;
    }

    public boolean isAccessorized() {
        return false;
    public void getArenaStage(String arenaType) { //This might be something we delete
        arenaLevel.get(arenaType);
    }

    public void battle() {
        //bring in a command
    }
}
