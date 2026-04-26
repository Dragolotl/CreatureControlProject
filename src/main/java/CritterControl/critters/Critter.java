package CritterControl.critters;

import CritterControl.Accessories.Accessory;
import CritterControl.Die;
import CritterControl.Food.Food;
import CritterControl.Strategy.IStrategy;

abstract public class Critter {
    public static final int TYPE_ADVANTAGE_DAMAGE_BONUS = 2;

    protected static final double DEFAULT_HAPPINESS=100.0;
    protected static final double LEVEL_HEALTH_MULTIPLIER = 5;
    protected String name;
    private Double health;
    private int level;
    private Double happiness; //TODO - IS HAPPINESS STILL A FACTOR IN THIS GAME?

    private Die die;
    protected IStrategy strategy;

    public Critter() {}

    public Critter(String name){
        this(name, 1);
    }

    public Critter(String name, int level) {
        this(name, level, Die.createDefaultDie());
    }

    public Critter(String name, int level, Die die) {
        this.name = name;
        setHealth(level * LEVEL_HEALTH_MULTIPLIER);
        setHappiness(DEFAULT_HAPPINESS);
        setDie(Die.createDefaultDie());
    }

    public String getName(){
        return name;
    };
    public String getBaseName() { return name; }
    public double getHealth(){
        return health;
    }
    public int getLevel() { return level; }
    public Die getDie() { return die; }
    public IStrategy getStrategy() {return strategy; }
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

    public void setDie(Die die) {
        this.die = die;
    }

    public abstract void setStrategyBasedOnLevel(int level);

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
            return;
        }

        setHealth(getHealth() - healthLost);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public Double getHappiness() {
        return happiness;
    }

    public Accessory getAccessory() {
        return null;
    }

    public boolean isAccessorized() {
        return false;
    }

//    public void getArenaStage(String arenaType) { //This might be something we delete
//        arenaLevel.get(arenaType);
//    }
//
//    public void battle() {
//        bring in a command
//    }
}
