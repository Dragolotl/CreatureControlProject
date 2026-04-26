package CritterControl.Commands;

import CritterControl.critters.Critter;
import org.slf4j.Logger;

import java.util.Random;
import java.util.Scanner;

public class BattleCommand implements ICommand{
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BattleCommand.class);
    private static final Random random = new Random();

    private static final int OPPONENT_CHANCE_TO_DODGE = 3;

    private final Critter player;
    private final Critter opponent;

    public BattleCommand(Critter critterInThisCorner, Critter critterInTheOtherCorner) {
        this.player = critterInThisCorner;
        this.opponent = critterInTheOtherCorner;
    }

    @Override
    public boolean execute() {
        logger.info("{} vs. {}... FIGHT!", player.getName(), opponent.getName());
        while (player.isAlive() && opponent.isAlive()) {
            boolean isPlayerAttacking = getPlayerChoice();
            fight(isPlayerAttacking, randomBattleOpponentChoice());
        }
        return true;
    }

    private void fight(boolean playerAttacked, boolean opponentAttacked) {
        if (playerAttacked && opponentAttacked) {
            player.damage(opponent);
            player.getStrategy().setDodged(false);
            opponent.getStrategy().setDodged(false);
        }

        if (!opponentAttacked) {
            opponent.getStrategy().setDodged(playerAttacked);
            player.getStrategy().resetDamageReduction();
        }

        if (!playerAttacked) {
            player.getStrategy().setDodged(opponentAttacked);
            opponent.getStrategy().resetDamageReduction();
        }
    }

    private boolean getPlayerChoice() {
        int playerChoice;

        if (checkForStunned(player)) {
            logger.info("You are stunned and can't attack!");
            return true;
        }

        while (true) {
            logger.info("Make your choice:");
            logger.info("1. ATTACK\n2. DODGE");
            playerChoice = scanner.nextInt();
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

        return random.nextInt(OPPONENT_CHANCE_TO_DODGE) == 0;
    }

    private boolean checkForStunned(Critter critter) {
        return critter.getStrategy().isStunned();
    }
}
