package CritterControl.critters;

import CritterControl.Die;
import CritterControl.Food.Food;
import CritterControl.Strategy.IStrategy;
import CritterControl.Strategy.StrategyFactory;

abstract public class Critter {
    protected static final StrategyFactory strategyFactory = new StrategyFactory();

    public static final int TYPE_ADVANTAGE_DAMAGE_BONUS = 2;
    protected static final double DEFAULT_HAPPINESS=100.0;
    protected static final int LEVEL_HEALTH_MULTIPLIER = 5;
    protected String name;
    private int health;
    private int level;
    private Double happiness; //TODO - IS HAPPINESS STILL A FACTOR IN THIS GAME?
    private CritterType critterType;
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
        setStrategyBasedOnLevel(level);
    }

    public String getName(){ return name; };
    public String getBaseName() { return name; }
    public int getHealth(){
        return health;
    }
    public int getLevel() { return level; }
    public Die getDie() { return die; }
    public CritterType getCritterType() { return critterType; }
    public IStrategy getStrategy() { return strategy; }
    public void setHealth(int healthValue) { this.health = healthValue; }
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

    abstract public void setStrategyBasedOnLevel(int level);


    public abstract void setStrategy();

    protected void setStrategyBasedOnLevel(IStrategy level5Strategy, IStrategy level10Strategy) {
        if (getLevel() < 5) {
            strategy = strategyFactory.Level1Strategy();
        } else if (getLevel() < 10) {
            strategy = level5Strategy;
        } else {
            strategy = level10Strategy;
        }
    }

    //Is this how eating works with the game as it is?
    //TODO - DECIDE HOW EAT SHOULD WORK
    public void eat(Food food){
        addHealth(food.getHealthValue());
        setHappiness(getHappiness() + food.getHappinessValue());
    }

    public void addHealth(int healthGained) {
        setHealth(getHealth() + healthGained);
    }

    public void loseHealth(int healthLost) {
        if (getHealth() <= 0) {
            return;
        }

        setHealth(getHealth() - healthLost);
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public Double getHappiness() {
        return happiness;
    }

    public boolean isAccessorized() {
        return false;
    }

    //TODO - Not sure if calc is correct but maybe...
    public void damage(Critter opponent) {
        //If stunned, cut result in half
        int playerResult = getDie().roll();
        getStrategy().tryStun(opponent, playerResult, getDie().getNumSides());

        if (getStrategy().isStunned()) {
            playerResult /= 2;
            getStrategy().setStunned(false);
        }

        int opponentResult = opponent.getDie().roll();
        opponent.getStrategy().tryStun(this, opponentResult, opponent.getDie().getNumSides());
        if (opponent.getStrategy().isStunned()) {
            opponentResult /= 2;
            opponent.getStrategy().setStunned(false);
        }

        //Total result = initial roll + type advantage damage bonus + stolen damage (if high level magic type)
        playerResult = Math.max(0, playerResult
                + checkForTypeAdvantage(opponent)
                + (getStrategy().shouldStealEnemyDamage() * opponent.getStrategy().getDamageReduction())
                + getStrategy().addDodgeDamageBonus()
                - getStrategy().getDamageReduction());
        opponentResult = Math.max(0, opponentResult
                + checkForTypeAdvantage(this)
                + (getStrategy().shouldStealEnemyDamage() * getStrategy().getDamageReduction())
                + getStrategy().addDodgeDamageBonus()
                - opponent.getStrategy().getDamageReduction());

        if (playerResult > opponentResult) {
            opponent.loseHealth(playerResult - opponentResult);
        } else {
            loseHealth(opponentResult -  playerResult);
        }

        getStrategy().drain(opponent);
        opponent.getStrategy().drain(this);
    }

    abstract public int checkForTypeAdvantage(Critter opponent);

//    public void getArenaStage(String arenaType) { //This might be something we delete
//        arenaLevel.get(arenaType);
//    }
//
//    public void battle() {
//        bring in a command
//    }
}
