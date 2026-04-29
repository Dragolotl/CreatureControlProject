package CritterControl.Commands;

import CritterControl.Accessories.AccessoryFactory;
import CritterControl.CritterCorral;
import CritterControl.Food.FoodFactory;
import CritterControl.Garden.Garden;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import CritterControl.critters.CritterType;
import org.slf4j.Logger;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


public class BattleCommand extends Command{
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BattleCommand.class);
    private static final Random random = new Random();
    private static final CritterFactory critterFactory = new CritterFactory();
    private static final AccessoryFactory accessoryFactory = new AccessoryFactory();
    private static final FoodFactory foodFactory = new FoodFactory();

    private static final Map<CritterType, Integer> arenaLevels = new ConcurrentHashMap<>();
    private static final int OPPONENT_CHANCE_TO_DODGE = 3;

    static {
        initializeArenas();
    }

    private final Critter opponent;
    private final CritterType opponentType;
    private final CritterCorral corral;
    private final Garden garden;

    public BattleCommand(Critter player, CritterType opponentType, CritterCorral corral, Garden garden) {
        super(CommandType.BATTLE, player);
        this.opponent = critterFactory.createCritter(opponentType, arenaLevels.get(opponentType));
        this.opponentType = opponentType;
        this.corral = corral;
        this.garden=garden;
    }

    @Override
    public boolean execute() {
        int maxHealth = critter.getHealth();

        logger.info("{} vs. {}... FIGHT!", critter.getName(), opponent.getName());
        while (critter.isAlive() && opponent.isAlive()) {
            boolean isPlayerAttacking = getPlayerChoice();
            fight(isPlayerAttacking, randomBattleOpponentChoice());
        }

        maxHealth+=handleBattleResult(); // handle battle result calculates health to add to critter

        garden.growAllTrees();
        critter.setHealth(maxHealth);
        return true;
    }

    private void fight(boolean playerAttacked, boolean opponentAttacked) {
        if (playerAttacked && opponentAttacked) {
            critter.damage(opponent);
            critter.getStrategy().setDodged(false);
            opponent.getStrategy().setDodged(false);
        }

        if (!opponentAttacked) {
            opponent.getStrategy().setDodged(playerAttacked);
            critter.getStrategy().resetDamageReduction();
            logger.info("{} dodged!.", opponent.getName());
        }

        if (!playerAttacked) {
            critter.getStrategy().setDodged(opponentAttacked);
            opponent.getStrategy().resetDamageReduction();
            logger.info("{} dodged!.", critter.getName());
        }
    }

    private boolean getPlayerChoice() {
        int playerChoice;

        if (checkForStunned(critter)) {
            logger.info("You are stunned and can't act!");
            return true;
        }

        while (true) {
            logger.info("Make your choice:");
            logger.info("1. ATTACK");
            logger.info("2. DODGE");
            playerChoice = random.nextInt(2) + 1;
//          Scanner scanner = new Scanner(System.in);
//          playerChoice = Integer.parseInt(scanner.nextLine());
            if (playerChoice < 1 || playerChoice > 2) {
                logger.warn("Invalid choice.");
            } else {
                return playerChoice == 1;
            }
        }
    }

    private boolean randomBattleOpponentChoice() {
        if (checkForStunned(opponent)) {
            return true;
        }

        return !(random.nextInt(OPPONENT_CHANCE_TO_DODGE) == 0);
    }

    private boolean checkForStunned(Critter critter) {
        return critter.getStrategy().isStunned();
    }

    public static void initializeArenas() {
        arenaLevels.put(CritterType.STRENGTH, 1);
        arenaLevels.put(CritterType.SPEED, 1);
        arenaLevels.put(CritterType.MAGIC, 1);
    }
    public int handleBattleResult(){
        int winHappinessLost = 5;
        int loseHappinessLost = 20;

        if (critter.isAlive()) {
            logger.info("Congratulations! {} won the fight and leveled up!", critter.getName());
            critter.levelUp();
//            maxHealth += Critter.LEVEL_HEALTH_MULTIPLIER;
            arenaLevels.put(opponentType, arenaLevels.get(opponentType) + 1);
            corral.add(accessoryFactory.createRandomAccessory(arenaLevels.get(opponentType)));
            corral.add(foodFactory.createRandomFood(arenaLevels.get(opponentType)));
            critter.loseHappiness(winHappinessLost);
            return Critter.LEVEL_HEALTH_MULTIPLIER;
        } else {
            logger.info("{} lost the fight. Bummer...", critter.getName());
            critter.loseHappiness(loseHappinessLost);
            return 0;
        }

    }
}
