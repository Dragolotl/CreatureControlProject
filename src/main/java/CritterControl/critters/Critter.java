package CritterControl.critters;

abstract public class Critter {
    protected String name;
    private Double health;

    public Critter(String name){
        this.name = name;
        this.health = 5.0;
    }

    public Critter(String name, Double health) {
        this.name = name;
        this.health = health;
    }

    public double getHealth(){
        return this.health;
    }
}
