package CritterControl.Food;

public enum FoodType {
    APPLE("Apple", 3, 2,2),
    CUPCAKE("Cupcake", -5, 10,7),
    BROCCOLI("Broccoli", 5, -5,7);

    private final String name;
    private final int healthValue;
    private final int happinessValue;
    private final int cost;
    FoodType(String name, int healthValue, int happinessValue, int cost) {
        this.name = name;
        this.healthValue = healthValue;
        this.happinessValue = happinessValue;
        this.cost=cost;
    }

    public Food createFood() {
        return new Food(name, healthValue, happinessValue);
    }

    public String getTreeName() {
        return name + " Tree";
    }
    public int getCost() {
        return cost;
    }
}