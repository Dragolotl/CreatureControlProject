package CritterControl;

import CritterControl.Commands.ICommand;
import CritterControl.Food.FoodFactory;
import CritterControl.Food.FoodType;
import CritterControl.Garden.Garden;
import CritterControl.Garden.Tree;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import CritterControl.critters.CritterType;
import CritterControl.Commands.CommandFactory;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CritterControl {
    //Might need another class to handle these to be in compliance with Single Responsibility Principle
    //CritterControl should handle playing the game
    private final Scanner scanner = new Scanner(System.in);
    private int gold;
    private Boolean playing;

    private final CritterCorral corral;
    private final Garden garden;
    private final FoodFactory foodFactory;
    private final CritterFactory critterFactory;
    public CommandFactory commandFactory;
    //CommandFactory commandFactory;

    private final Map<CritterType, Integer> arenaLevels = new ConcurrentHashMap<>();
//need a scanner

    //include a map that holds arena levels indexed by a possible arena enum
    //need a scanner
    static Logger logger = LoggerFactory.getLogger(CritterControl.class);
    //this will have the selectAction method, and also will have a feed method

    public CritterControl() {
        this.gold = 0;
        this.corral = new CritterCorral();
        this.playing = true;
        this.garden = new Garden();
        this.foodFactory = new FoodFactory(new Die(20));
        this.critterFactory = new CritterFactory();
        garden.addTree(new Tree(
                FoodType.APPLE.getTreeName(),
                FoodType.APPLE.createFood(),
                foodFactory)); // need to fix new keyword here
    }

    public CritterControl(CritterCorral corral) {
        //Give player starting stuff
        this.gold = 0;
        this.playing = true;
        this.corral = corral;
        this.garden = new Garden();
        this.foodFactory = new FoodFactory(new Die(20));
        this.critterFactory = new CritterFactory();
        garden.addTree(new Tree(
                FoodType.APPLE.getTreeName(),
                FoodType.APPLE.createFood(),
                foodFactory)); // need to fix new keyword here

    } //Also potentially code in an Arena if we do Ramsey's plan

    public void play() {
        //Get player choice of critter
        Critter currentCritter = null;
        logger.info("Select Critter: ");
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i< corral.getCritters().size(); i++){
            logger.info(corral.getCritters().get(i).getName());
        }
        int critterIndex = 0;
        boolean chooseOption = true;
        while(chooseOption){
            critterIndex = scanner.nextInt();
            if(critterIndex >= 0 && critterIndex < corral.getCritters().size()){
                logger.info("You have chosen Critter {}!", corral.getCritterByIndex(critterIndex).getName());
                currentCritter = corral.getCritterByIndex(critterIndex);
                chooseOption = false;
            }else{
                logger.info("{} is out of bounds. Choose a valid Critter. Printing again.", critterIndex);
                for(int i = 0; i < corral.getCritters().size(); i++){
                    logger.info(corral.getCritters().get(i).getName());
                }
                break;
            }
        }

        assert currentCritter != null; //Might get rid of this assert statement, we'll see
        logger.info("Interact with {}!", currentCritter.getName());
        while (playing) {
            //Print menu somehow
            //could select a current critter in here rather than selectAction?
            ICommand command = selectAction(currentCritter);
            command.execute();
        }
    }

    public ICommand selectAction(Critter currentCritter) {
        //Take in user input and choose the action accordingly - take in a number option?
//        List<ICommand> actionOptions = getPossibleActions(myself, room); //Feed, Wear, Battle
//        List<CommandType> actions = new ArrayList<>();
        //enum.values.getIndex
        logger.info("Select option: ");
        Scanner scanner = new Scanner(System.in);
        //switch (user input):
        switch(scanner.nextInt()) {
            case 1:
                //1. Change Critter (not a command, just variable swapping)
                // Could have a function in critterCorral to iterate through the list
                logger.info("Choose different Critter: --IN PROGRESS--");
                //      print out critter list from corral
                //      scan to get user choice
                //      currentCritter = corral.get(userChoice);
                //somehow pull player out of this selectAction and put them in a new one - potentially put this in play?
                //      return commandFactory.SleepCommand();
                break;
            case 2:
                //2. Battle
                //      print out arenas
                //      get user input for choice
                //generate commands based on arenas
                return chooseBattleCommand(currentCritter);
                //return commandFactory.newBattleCommand(currentCritter, critterFactoryStuff);
            case 3:
                //3. Feed
                //      scan for user input for amount of food
                if(chooseFoodCommand(currentCritter) == null){
                    logger.info("Please choose a different option for now. ");
                    break;
                }
                return chooseFoodCommand(currentCritter);
                //return commandFactory.newFeedCommand(currentCritter, foodAmount);
            case 4:
                //4. Dress
                //selectSubAction - also returns an ICommand
                //if returns null, then immediately break and go back to top menu?
                if(chooseDressCommand(currentCritter) == null){
                    logger.info("Please choose a different option for now. ");
                    break;
                }else{
                    return chooseDressCommand(currentCritter);
                }

            case 5:
                //5. Quit
                return commandFactory.newQuitCommand(playing);
            default:
                //Default. maybe make them choose again...
                logger.info("Choose a number from 1 to 5.");
        }
        return null;
    }

    //could have a getPossibleActions cause critters and clothes might change, arenas wouldn't
    //or have a specific submenu for dress
    public ICommand chooseDressCommand(Critter currentCritter){
        //make a menu that calls the dress options, and then returns a dress command based on what the player chooses
        //could possibly use a forEach
        //possibly move printing to a new function into CritterCorral
        //This function can find the outfit that the player wants to check, then pass it into the DressFunction
        Scanner scanner = new Scanner(System.in);
        //List<Accessory> wardrobe = corral.getWardrobe();
        if(!corral.printAllAccessories()){
            return null; //find some way to just return to top menu
        }
        //corral.printAllAccessories(); //if this returns false, then return a null?

        logger.info("Choose an accessory: ");
        int wardrobeIndex = 0;
        boolean chooseOption = true;
        while(chooseOption){
            wardrobeIndex = scanner.nextInt();
            if(wardrobeIndex >= 0 &&  wardrobeIndex < corral.getWardrobe().size()){ //wardrobeIndex >= 0 &&  wardrobeIndex < corral.getWardrobe().size()
                logger.info("You have chosen the {} to put on {}", corral.getAccessoryByIndex(wardrobeIndex).name(), currentCritter.getName());
                chooseOption = false;
                //return commandFactory.newWearCommand(currentCritter, corral, corral.getAccessoryByIndex(wardrobeIndex));
            }else{
                logger.info("{} is out of bounds. Choose a valid number. Printing again.", wardrobeIndex);
                //play the options again
                corral.printAllAccessories();
                break;
            }
        }
        return commandFactory.newDressCommand(currentCritter, corral, corral.getAccessoryByIndex(wardrobeIndex));
        // get player choice with scanner (checking valid index)
        // get accessory with player choice
        // return commandFactory.WearCommand(currentCritter, corral, accessory)
    }

    private ICommand chooseBattleCommand(Critter currentCritter) {
        //print arena choices
        //get player choice (ensure valid index)
        //index into the values of enum to get the proper type
        //CritterType.values()[playerChoice]
        //Critter opponent = some randomly generated critter of the appropriate type and level
        //return commandFactory.BattleCommand(currentCritter, opponent);
        Scanner scanner = new Scanner(System.in);
        logger.info("Choose an arena: ");
        for(int i = 0; i < CritterType.values().length; i++){
            logger.info(CritterType.values()[i].name());
        }
        int arenaIndex = 0;
        Critter opponent = null;
        boolean chooseOption = true;
        while(chooseOption){
            arenaIndex = scanner.nextInt();
            if(arenaIndex >= 0 && arenaIndex < CritterType.values().length){
                logger.info("You have chosen to enter the Arena of {}!", CritterType.values()[arenaIndex].name());
                opponent = critterFactory.createCritter(CritterType.values()[arenaIndex], currentCritter.getLevel());
                chooseOption = false;
            }else{
                logger.info("{} is out of bounds. Choose a valid arena. Printing again.", arenaIndex);
                for(int i = 0; i < CritterType.values().length; i++){
                    logger.info(CritterType.values()[i].name());
                }
                break;
            }
        }
        return commandFactory.newBattleCommand(currentCritter, opponent, garden); //CHECK LATER: Do I need a specific reference to Garden?
    }

    private ICommand chooseFoodCommand(Critter currentCritter) {
        Scanner scanner = new Scanner(System.in);
        if(!corral.printAllFood()){
            return null;
        }
        logger.info("Choose an food: ");
        int foodIndex = 0;
        boolean chooseOption = true;
        while(chooseOption){
            foodIndex = scanner.nextInt();
            if(foodIndex >= 0 && foodIndex < corral.getKitchen().size()){
                logger.info("You have chosen to feed {} to {}.",  corral.getKitchen().get(foodIndex).getName(), currentCritter.getName());
                chooseOption = false;
            }else{
                logger.info("{} is out of bounds. Choose a valid number. Printing again.", foodIndex);
                //play the options again
                corral.printAllFood();
                break;
            }
        }
        return commandFactory.newFeedCommand(currentCritter, corral.getKitchen().get(foodIndex), corral);
    }

    public void addGold(int goldEarned) {
        gold += goldEarned;
    }

    public void loseGold(int goldLost) {
        gold -= goldLost;
        if (gold <= 0) {
            gold = 0;
        }
    }

    public int getGold() {
        return gold;
    }



    public void initializeArenas() {
        arenaLevels.put(CritterType.STRENGTH, 1);
        arenaLevels.put(CritterType.SPEED, 1);
        arenaLevels.put(CritterType.MAGIC, 1);
    }



    //have a play method
    //play can be a void method, and a save and quit function at the top menu(
    //Game runs in a while loop, it initializes everything, then it starts a while loop method that presents the plater with options.
    //then in that while loop, there's a 'quit' method that the player can select to stop playing

}
