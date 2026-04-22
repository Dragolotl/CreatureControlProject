package CritterControl.critters;

import CritterControl.Food.Food;

abstract public class Critter {
    protected static final double DEFAULT_HAPPINESS=100.0;
    protected String name;
    protected int level;
    private Double health;
    private Double happiness;
    private Double xp;
    private String type; //OR have type be a strategy?
    public Critter(String name){
        this.name = name;
        this.health = 5.0;
        this.happiness=DEFAULT_HAPPINESS;

    }

    public Critter(String name, Double health) {
        this.name = name;
        this.health = health;
        this.happiness=DEFAULT_HAPPINESS;
    }

    public String getName(){
        return this.name;
    };
    public double getHealth(){
        return this.health;
    }
    public int getLevel(){
        return this.level;
    }

    public void eat(Food food){
        health+=food.getHealthValue();
        happiness+=food.getHappinessValue();
        if (happiness>=100.0){
            happiness=100.0;
        }
    }

    //fight command
    //depending on the foe's type and critter's type, uses a die/randomizer to battle with modifiers according to critter's level and type

    public Double getHappiness() {
        return happiness;
    }
}
