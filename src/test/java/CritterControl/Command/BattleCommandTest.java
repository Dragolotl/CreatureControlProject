package CritterControl.Command;

import CritterControl.Commands.CommandFactory;
import CritterControl.Commands.ICommand;
import CritterControl.CritterCorral;
import CritterControl.FixedDie;
import CritterControl.Garden.Garden;
import CritterControl.Strategy.StrategyFactory;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import CritterControl.critters.CritterType;
import org.junit.jupiter.api.Test;

public class BattleCommandTest {
    private final CritterFactory critterFactory = new CritterFactory();
    private final CommandFactory commandFactory = new CommandFactory();

    @Test
    public void testBattleCommand() {
        Critter critter1 = critterFactory.createCritter(CritterType.STRENGTH, 1);

        CritterCorral corral = new CritterCorral();
        Critter opponent = critterFactory.createCritter(CritterType.MAGIC, 1);
        Garden garden = new Garden();

        ICommand battle = commandFactory.newBattleCommand(critter1, CritterType.MAGIC, corral, garden);
        battle.execute();
    }


}
