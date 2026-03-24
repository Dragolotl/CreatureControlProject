package CritterControl;

public class CritterControl {
    //Might need another class to handle these to be in compliance with Single Responsibility Principle
    //CritterControl should handle playing the game
    private int gold;
    private int food;
    private final CritterCorral corral;

    public CritterControl(CritterCorral corral) {
        //decide on starting values later
        this.gold = 0;
        this.food = 0;
        this.corral = corral;
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
