package CritterControl.critters;

import CritterControl.Food.Food;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

abstract public class Critter {
    protected static final double DEFAULT_HAPPINESS=100.0;
    protected static final double DEFAULT_HEALTH = 5.0;
    protected String name;
    private Double health;
    private int level;
    //Include a map that has the arena levels in it
    private final Map<String, Integer> arenaLevel = new ConcurrentHashMap<>(); //<Type, Level>
    private Double happiness; //TODO - IS HAPPINESS STILL A FACTOR IN THIS GAME?

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
    public double getHealth(){
        return health;
    }
    public int getLevel() { return level; }

    //Is this how eating works with the game as it is?
    //TODO - DECIDE HOW EAT SHOULD WORK
    public void eat(Food food){
        health += food.getHealthValue();
        happiness += food.getHappinessValue();
        if (happiness >= 100.0){
            happiness = 100.0;
        }
    }

    public Double getHappiness() {
        return happiness;
    }

    public void getArenaStage(String arenaType) { //This might be something we delete
        arenaLevel.get(arenaType);
    }

    public void battle() {
        //bring in a command
    }
}
