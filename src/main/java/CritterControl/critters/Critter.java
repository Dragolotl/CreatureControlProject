package CritterControl.critters;

import CritterControl.Food.Food;

abstract public class Critter {
    protected static final double DEFAULT_HAPPINESS=100.0;
    protected static final double DEFAULT_HEALTH = 5.0;
    protected String name;
    private Double health;
    private int level;
    private Double happiness; //TODO - IS HAPPINESS STILL A FACTOR IN THIS GAME?

    public Critter(String name){
        this(name, DEFAULT_HEALTH);
    }

    public Critter(String name, Double health) {
        this.name = name;
        this.health = health;
        this.happiness = DEFAULT_HAPPINESS;
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
}
