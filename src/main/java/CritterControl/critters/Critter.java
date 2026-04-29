package CritterControl.critters;

import CritterControl.Accessories.Accessory;
import CritterControl.Die;
import CritterControl.Food.Food;
import CritterControl.Strategy.IStrategy;
import CritterControl.Strategy.StrategyFactory;
import org.slf4j.Logger;

public abstract class Critter {
    protected static final StrategyFactory strategyFactory = new StrategyFactory();

    public static final int TYPE_ADVANTAGE_DAMAGE_BONUS = 1;
    protected static final double DEFAULT_HAPPINESS=100.0;
    public static final int LEVEL_HEALTH_MULTIPLIER = 5;
    protected String name;
    private int health;
    private int level;
    private Double happiness = 0.0; 
    protected CritterType critterType;
    private Die die;

    protected IStrategy strategy;

    static Logger logger = org.slf4j.LoggerFactory.getLogger(Critter.class);

    public Critter() {}

    public Critter(String name){
        this(name, 1);
    }

    public Critter(String name, int level) {
        this(name, level, Die.createDefaultDie());
    }

    public Critter(String name, int level, Die die) {
        this.name = name;
        this.level = level;
        setDie(die);
        setHealth(level * LEVEL_HEALTH_MULTIPLIER);
        setHappiness(DEFAULT_HAPPINESS);
        setStrategyBasedOnLevel(strategyFactory.BaseStrategy(), strategyFactory.BaseStrategy());
    }

    public void setName(String name) {
        this.name = name;
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

    public void levelUp(){ this.level++; }  //

    //abstract public void setStrategyBasedOnLevel(int level);

    public abstract void setStrategy();

    protected void setStrategyBasedOnLevel(IStrategy level5Strategy, IStrategy level10Strategy) {
        if (getLevel() < 5) {
            strategy = strategyFactory.BaseStrategy();
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
        logger.info("{}, ({}) rolled a {}", getName() ,getHealth(), playerResult);
        getStrategy().tryStun(opponent, playerResult, Die.DEFAULT_MAX_VALUE);

        if (getStrategy().isStunned()) {
            playerResult /= 2;
            getStrategy().setStunned(false);
        }

        int opponentResult = opponent.getDie().roll();
        logger.info("{}, ({}) rolled a {}", opponent.getName(), opponent.getHealth(), opponentResult);
        opponent.getStrategy().tryStun(this, opponentResult, Die.DEFAULT_MAX_VALUE);
        if (opponent.getStrategy().isStunned()) {
            opponentResult /= 2;
            opponent.getStrategy().setStunned(false);
        }
//Total result = initial roll + type advantage damage bonus + stolen damage (if high level magic type)
        playerResult += checkForTypeAdvantage(opponent)
                + (getStrategy().shouldStealEnemyDamage() * opponent.getStrategy().getDamageReduction())
                + getStrategy().addDodgeDamageBonus()
                - getStrategy().getDamageReduction();
        opponentResult += checkForTypeAdvantage(this)
                + (getStrategy().shouldStealEnemyDamage() * getStrategy().getDamageReduction())
                + getStrategy().addDodgeDamageBonus()
                - opponent.getStrategy().getDamageReduction();
        if (playerResult > opponentResult) {
            logger.info("{} dealt {} damage to {}", getName(), playerResult - opponentResult, opponent.getName());
            opponent.loseHealth(playerResult - opponentResult);
        } else if (playerResult < opponentResult) {
            logger.info("{} dealt {} damage to {}", opponent.getName(), opponentResult - playerResult, getName());
            loseHealth(opponentResult -  playerResult);
        } else {
            logger.info("Clash! No damage dealt...");
        }

        getStrategy().drain(opponent);
        opponent.getStrategy().drain(this);
    }

    abstract public int checkForTypeAdvantage(Critter opponent);

    public Accessory getAccessory(){return null; }//THIS IS MOSTLY HERE FOR TESTING, WE CAN TRY OTHER THINGS WITH IT LATER

//    public void getArenaStage(String arenaType) { //This might be something we delete
//        arenaLevel.get(arenaType);
//    }
//
//    public void battle() {
//        bring in a command
//    }
}
