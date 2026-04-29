package CritterControl.Command;

import CritterControl.Commands.CommandFactory;
import CritterControl.Commands.ICommand;
import CritterControl.CritterCorral;
import CritterControl.Food.FoodFactory;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import CritterControl.critters.CritterType;
import org.junit.jupiter.api.Test;

public class BattleCommandTest {
    private final CritterFactory critterFactory = new CritterFactory();
    private final CommandFactory commandFactory = new CommandFactory();
    private final FoodFactory foodFactory = new FoodFactory();

    @Test
    public void testBattleCommand() {
        Critter critter1 = critterFactory.createCritter(CritterType.STRENGTH, 1);

        CritterCorral corral = new CritterCorral();

        ICommand battle = commandFactory.newBattleCommand(critter1, CritterType.MAGIC, corral);
        battle.execute();
    }
}
