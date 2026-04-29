package CritterControl;

import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;

import java.text.ParseException;
import java.util.logging.Logger;

public class GameConfigurator {
    //static Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(GameConfigurator.class);
    static Logger logger = Logger.getLogger(GameConfigurator.class.getName());
//    static CritterCorral corral = new CritterCorral();
//    static CritterControl critterControl;
    static CritterFactory critterFactory = new CritterFactory();

    GameConfigurator() {
        //critterControl = new CritterControl(corral);
    }
//plain text file with a perameter on each line and feed that in
    // config.txt that has # of enemies, # of trees that get fed in line by line

    //set up the main function so that it does what you want it to - we can just make a game and play it
    //critterControl
    //put this stuff into main

    public static void main(String[] args) throws ParseException {
        CritterCorral corral = new CritterCorral();
        CritterControl critterControl = new CritterControl(corral);
//        Critter manny = critterFactory.createMinitaur("Manny");
//        corral.add(manny);
        critterControl.play();
    }

}
