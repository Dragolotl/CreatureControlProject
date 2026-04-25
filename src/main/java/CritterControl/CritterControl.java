package CritterControl;

import CritterControl.Commands.ICommand;
import CritterControl.critters.Critter;

import java.util.Scanner;

public class CritterControl {
    //Might need another class to handle these to be in compliance with Single Responsibility Principle
    //CritterControl should handle playing the game
    private Scanner scanner = new Scanner(System.in);
    private int gold;
    private int food;
    private Boolean playing;
    private final CritterCorral corral;

    public CritterControl() {
        this.gold = 0;
        this.food = 0;
        this.corral = new CritterCorral();
        this.playing = true;
    }

    public CritterControl(CritterCorral corral) {
        //Give player starting stuff
        this.gold = 0;
        this.food = 0;
        this.corral = corral;
    }

    public void play() {
        Critter currentCritter = new Critter();

        while (playing) {
            //Print menu somehow
            ICommand command = selectAction(currentCritter);
            command.execute();
        }
    }

    public ICommand selectAction(Critter currentCritter) {
        //Take in user input and choose the action accordingly
        //switch (user input):
        //1. Change Critter (not a command, just variable swapping)
        //      print out critter list from corral
        //      scan to get user choice
        //      currentCritter = corral.get(userChoice);
        //      return commandFactory.SleepCommand();
        //2. Battle
        //      print out arenas
        //      get user input for choice
        //      return commandFactory.BattleCommand(currentCritter, critterFactoryStuff)
        //3. Feed
        //      scan for user input for amount of food
        //      return commandFactory.FeedCommand(currentCritter, foodAmount);
        //4. Dress
        //      if wardrobe is empty,
        //          be sassy
        //          return commandFactory.sleepCommand();
        //      else
        //          print out accessory list
        //          scan for user input
        //          Accessory accessory = corral.getWardrobe().get(user input);
        //          return commandFactory.WearCommand(currentCritter, corral, accessory);
        //5. Quit
        //      return commandFactory.QuitCommand(playing);
        //Default. maybe make them choose again...
        return null;
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
    public int getFoodAmount(){
        return food;
    }
    public void addFood(int foodEarned) {
        food += foodEarned;
    }

    public void loseFood(int foodLost) {
        food -= foodLost;
        if (food <= 0) {
            food = 0;
        }
    }
}
