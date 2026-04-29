package CritterControl.Command;

import CritterControl.Accessories.Accessory;
import CritterControl.Commands.*;
import CritterControl.CritterCorral;
import CritterControl.Food.Food;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import CritterControl.critters.CritterType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {
    private final CritterFactory critterFactory = new CritterFactory();
    private final CommandFactory commandFactory = new CommandFactory();

    @Test
    public void testCheckCritterCommandExecutes() {
        Critter critter = critterFactory.createMinitaur("Manny");

        ICommand command = commandFactory.newCheckCritterCommand(critter);

        assertTrue(command.execute());
    }

    @Test
    public void testFeedCommandExecutes() {
        Critter critter = critterFactory.createMinitaur("Manny");
        Food food = new Food("Apple", 1);
        CritterCorral corral = new CritterCorral();

        corral.add(food);

        ICommand command = commandFactory.newFeedCommand(critter, food, corral);

        assertTrue(command.execute());
        assertFalse(corral.contains(food));
    }

    @Test
    public void testFeedCommandWithNullFoodReturnsFalse() {
        Critter critter = critterFactory.createMinitaur("Manny");
        CritterCorral corral = new CritterCorral();

        ICommand command = commandFactory.newFeedCommand(critter, null, corral);

        assertFalse(command.execute());
    }

    @Test
    public void testQuitCommandExecutes() {
        ICommand command = commandFactory.newQuitCommand(true);

        assertTrue(command.execute());
    }

    @Test
    public void testCommandFactoryCreatesBattleCommand() {
        Critter critter = critterFactory.createMinitaur("Manny");
        CritterCorral corral = new CritterCorral();

        ICommand command = commandFactory.newBattleCommand(critter, CritterType.MAGIC, corral);

        assertInstanceOf(BattleCommand.class, command);
    }

    @Test
    public void testCommandFactoryCreatesDressCommand() {
        Critter critter = critterFactory.createMinitaur("Manny");
        CritterCorral corral = new CritterCorral();
        Accessory hat = new Accessory("Hat", 2);

        ICommand command = commandFactory.newDressCommand(critter, corral, hat);

        assertInstanceOf(DressCommand.class, command);
    }

    @Test
    public void testCommandFactoryCreatesFeedCommand() {
        Critter critter = critterFactory.createMinitaur("Manny");
        CritterCorral corral = new CritterCorral();
        Food food = new Food("Apple", 1);

        ICommand command = commandFactory.newFeedCommand(critter, food, corral);

        assertInstanceOf(FeedCommand.class, command);
    }

    @Test
    public void testCommandFactoryCreatesQuitCommand() {
        ICommand command = commandFactory.newQuitCommand(true);

        assertInstanceOf(QuitCommand.class, command);
    }

    @Test
    public void testCommandFactoryCreatesCheckCritterCommand() {
        Critter critter = critterFactory.createMinitaur("Manny");

        ICommand command = commandFactory.newCheckCritterCommand(critter);

        assertInstanceOf(CheckCritterCommand.class, command);
    }
}