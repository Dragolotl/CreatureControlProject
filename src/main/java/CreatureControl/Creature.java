package CreatureControl;

public class Creature {
    protected String name;
    private Double health;

    public Creature(String name){
        this.name = name;
        this.health = 5.0;
    }

    public double getHealth(){
        return this.health;
    }
}
