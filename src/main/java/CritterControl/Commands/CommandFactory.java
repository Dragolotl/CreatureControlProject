package CritterControl.Commands;

import CritterControl.CritterCorral;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterType;

public class CommandFactory {
    public ICommand BattleCommand(Critter critter1, CritterType opponentType, CritterCorral corral) {
        return new BattleCommand(critter1, opponentType, corral);
      
        public ICommand newWearCommand(Critter critter, CritterCorral corral, Accessory accessory) {
            return new WearCommand(critter, corral, accessory);
        }

        public ICommand newQuitCommand(Boolean isPlaying) {
            return new QuitCommand(isPlaying);
        }
}
