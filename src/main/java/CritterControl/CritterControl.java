package CritterControl;

import CritterControl.Commands.ICommand;
import CritterControl.Commands.QuitCommand;
import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import CritterControl.critters.CritterType;
import CritterControl.Commands.CommandFactory;

import java.util.Scanner;

public class CritterControl {
    //Might need another class to handle these to be in compliance with Single Responsibility Principle
    //CritterControl should handle playing the game
    private final Scanner scanner = new Scanner(System.in);
    private Boolean playing;

    private final CritterCorral corral;
    private static final CritterFactory critterFactory = new CritterFactory();
    private static final CommandFactory commandFactory = new CommandFactory();
//need a scanner

    //include a map that holds arena levels indexed by a possible arena enum
    //need a scanner
    //static Logger logger = LoggerFactory.getLogger(CritterControl.class);
    //this will have the selectAction method, and also will have a feed method

    public CritterControl() {
        this.corral = new CritterCorral();
        this.playing = true;
      //  this.foodFactory = new FoodFactory();
   //     this.critterFactory = new CritterFactory();

    }

    public CritterControl(CritterCorral corral) {
        //Give player starting stuff
        this.playing = true;
        this.corral = corral;
//        this.foodFactory = new FoodFactory();
//        this.critterFactory = new CritterFactory();


    } //Also potentially code in an Arena if we do Ramsey's plan

    public void play() {
        //Get player choice of critter
        System.out.println("Welcome to Critter Control!");
        startNewGame();
        // since we only have 1 critter in current gme:
        Critter currentCritter = corral.getCritterByIndex(0);

//        Critter currentCritter = selectCritter();
//        assert currentCritter != null; //Might get rid of this assert statement, we'll see
        System.out.println("Interact with " + currentCritter.getName() + "!");
        while (playing) {
            //I could check if it returns quitCommand, and if it does I could have a special 'if' statement that either calls selectCritter again or
            currentCritter = corral.getCritterByIndex(0);
            ICommand command = selectAction(currentCritter);
            if(command instanceof QuitCommand) {
                System.out.println("Thanks for playing!");
                playing = false;
            }
            command.execute();
        }//Maybe quit command gets us out of this while loop, and there's one after it that checks if you want to check on another Critter or quit
    }

    public void startNewGame(){
        System.out.println("What type of Critter do you want?");
        //Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < CritterType.values().length; i++){
            System.out.println((i) + ": " + CritterType.values()[i].name());
        }

        int critterTypeIndex = 0;
        //String critterName = "";
        //Critter opponent = null;
        boolean chooseOption = true;
        while(chooseOption){
            critterTypeIndex = scanner.nextInt();
            if(critterTypeIndex >= 0 && critterTypeIndex < CritterType.values().length){
                System.out.println("You have chosen the Critter " + CritterType.values()[critterTypeIndex].name() + "!");
                Critter firstCritter = critterFactory.createCritter(CritterType.values()[critterTypeIndex]);
                corral.add(firstCritter);
                nameYourCritter(firstCritter);
                //opponent = critterFactory.createCritter(CritterType.values()[critterTypeIndex], currentCritter.getLevel());
                chooseOption = false;
            }else{
                System.out.println(critterTypeIndex + " is out of bounds. Choose a valid Critter type. Printing again.");
                for(int i = 0; i < CritterType.values().length; i++){
                    System.out.println((i) + ": " + CritterType.values()[i].name());
                }
                break;
            }
        }
    }

    public void nameYourCritter(Critter critter){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name your " + critter.getClass() + ": ");
        //critterName = scanner.nextLine();
        critter.setName(scanner.nextLine());
        System.out.println("Your critter is now named " + critter.getName() + "!");
    }

    public Critter selectCritter(){
        Critter currentCritter = null;
        System.out.println("Select Critter: ");
        //Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < corral.getCritters().size(); i++){  //previously 0
            System.out.println((i) + ": " + corral.getCritters().get(i).getName());
        }
        int critterIndex = 0;
        boolean chooseOption = true;
        while(chooseOption){
            critterIndex = scanner.nextInt()-1;//bc we want 0 indexing
            if(critterIndex >= 0 && critterIndex < corral.getCritters().size()){
                System.out.println("You have chosen Critter " + corral.getCritterByIndex(critterIndex).getName() + "!");
                currentCritter = corral.getCritterByIndex(critterIndex);
                chooseOption = false;
            }else{
                System.out.println(critterIndex + " is out of bounds. Choose a valid Critter. Printing again.");
                for(int i = 0; i < corral.getCritters().size(); i++){
                    System.out.println(corral.getCritters().get(i).getName());
                }
                //break;
            }
        }
        return currentCritter;
    }

    public ICommand selectAction(Critter currentCritter) {
        //Take in user input and choose the action accordingly - take in a number option?
//        List<ICommand> actionOptions = getPossibleActions(myself, room); //Feed, Wear, Battle
//        List<CommandType> actions = new ArrayList<>();
        //enum.values.getIndex
        System.out.println("Select option: ");
        System.out.println("1: Check Critter");
        System.out.println("2: Battle");
        System.out.println("3: Feed");
        System.out.println("4: Dress");
        System.out.println("5: Quit");
        //Scanner scanner = new Scanner(System.in);
        //switch (user input):
        switch(scanner.nextInt()) {
            case 1:
                //1. Check Critter
                return commandFactory.newCheckCritterCommand(currentCritter);
            //      return commandFactory.SleepCommand();
            //break;
            case 2:
                //2. Battle
                //      print out arenas
                //      get user input for choice
                //generate commands based on arenas
                return chooseBattleCommand(currentCritter);
            //return commandFactory.newBattleCommand(currentCritter, critterFactoryStuff);
            case 3:
                //3. Feed
                // changed bc the if statement and returned would've prompted food choice twice
                ICommand foodCommand = chooseFoodCommand(currentCritter);
                if (foodCommand == null) {
                    System.out.println("Please choose a different option for now. ");
                    break;
                }
                return foodCommand;
            //return commandFactory.newFeedCommand(currentCritter, foodAmount);
            case 4:
                //4. Dress
                //selectSubAction - also returns an ICommand
                //if returns null, then immediately break and go back to top menu?
                ICommand theDressCommand = chooseDressCommand(currentCritter);
                if(theDressCommand == null){
                    System.out.println("Please choose a different option for now. ");
                    break;
                }else{
                    return theDressCommand;
                }

            case 5:
                //5. Quit
                return commandFactory.newQuitCommand(playing);
            default:
                //Default. maybe make them choose again...
                System.out.println("Choose a number from 1 to 5.");
        }
        return commandFactory.newCheckCritterCommand(currentCritter);  //return null;
    }

    //could have a getPossibleActions cause critters and clothes might change, arenas wouldn't
    //or have a specific submenu for dress
    public ICommand chooseDressCommand(Critter currentCritter){
        //make a menu that calls the dress options, and then returns a dress command based on what the player chooses
        //could possibly use a forEach
        //possibly move printing to a new function into CritterCorral
        //This function can find the outfit that the player wants to check, then pass it into the DressFunction
        //Scanner scanner = new Scanner(System.in);
        //List<Accessory> wardrobe = corral.getWardrobe();
        if(!corral.printAllAccessories()){
            return null; //find some way to just return to top menu
        }
        //corral.printAllAccessories(); //if this returns false, then return a null?

        System.out.println("Choose an accessory: ");
        int wardrobeIndex = 0;
        boolean chooseOption = true;
        while(chooseOption){
            wardrobeIndex = scanner.nextInt()-1;
            if(wardrobeIndex >= 0 &&  wardrobeIndex < corral.getWardrobe().size()){ //wardrobeIndex >= 0 &&  wardrobeIndex < corral.getWardrobe().size()
                System.out.println("You have chosen the " + corral.getAccessoryByIndex(wardrobeIndex).name() +  " to put on " + currentCritter.getName());
                chooseOption = false;
                //return commandFactory.newWearCommand(currentCritter, corral, corral.getAccessoryByIndex(wardrobeIndex));
            }else{
                System.out.println(wardrobeIndex + " is out of bounds. Choose a valid number. Printing again.");
                //play the options again
                corral.printAllAccessories();
            }
        }
        return commandFactory.newDressCommand(currentCritter, corral, corral.getAccessoryByIndex(wardrobeIndex));
        // get player choice with scanner (checking valid index)
        // get accessory with player choice
        // return commandFactory.WearCommand(currentCritter, corral, accessory)
    }

    private ICommand chooseBattleCommand(Critter currentCritter) {
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an arena: ");
        for(int i = 0; i < CritterType.values().length; i++){
            System.out.println((i) + ": " + CritterType.values()[i].name());
        }
        int arenaIndex = 0;
        boolean chooseOption = true;
        while(chooseOption){
            arenaIndex = scanner.nextInt();
            if(arenaIndex >= 0 && arenaIndex < CritterType.values().length){
                System.out.println("You have chosen to enter the Arena of " + CritterType.values()[arenaIndex].name() + "!");
                //opponent = critterFactory.createCritter(CritterType.values()[arenaIndex], currentCritter.getLevel());
                chooseOption = false;
            }else{
                System.out.println(arenaIndex + " is out of bounds. Choose a valid arena. Printing again.");
                for(int i = 0; i < CritterType.values().length; i++){
                    System.out.println((i) + ": " + CritterType.values()[i].name());
                }
            }
        }
        return commandFactory.newBattleCommand(currentCritter, CritterType.values()[arenaIndex], corral);
    }

    private ICommand chooseFoodCommand(Critter currentCritter) {
        //Scanner scanner = new Scanner(System.in);
        if(!corral.printAllFood()){
            return null;
        }
        System.out.println("Choose an food: ");
        int foodIndex = 0;
        boolean chooseOption = true;
        while(chooseOption){
            foodIndex = scanner.nextInt()-1;
            if(foodIndex >= 0 && foodIndex < corral.getKitchen().size()){
                System.out.println("You have chosen to feed " + corral.getKitchen().get(foodIndex).getName() + " to " + currentCritter.getName());
                chooseOption = false;
            }else{
                System.out.println(foodIndex + " is out of bounds. Choose a valid number. Printing again.");
                //play the options again
                corral.printAllFood();
            }
        }
        return commandFactory.newFeedCommand(currentCritter, corral.getKitchen().get(foodIndex), corral);
    }




    //have a play method
    //play can be a void method, and a save and quit function at the top menu(
    //Game runs in a while loop, it initializes everything, then it starts a while loop method that presents the plater with options.
    //then in that while loop, there's a 'quit' method that the player can select to stop playing

}