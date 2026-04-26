package CritterControl.Commands;

import CritterControl.CritterCorral;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterType;

public class CommandFactory {
    public ICommand BattleCommand(Critter critter1, int arenaLevel, CritterType opponentType, CritterCorral corral) {
        return new BattleCommand(critter1, arenaLevel, opponentType, corral);
    }

}
