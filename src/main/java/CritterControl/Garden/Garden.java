package CritterControl.Garden;

import CritterControl.Food.Food;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    private final List<Tree> trees = new ArrayList<>();
    public void addTree(Tree tree){
        trees.add(tree);
    }
    public List<Tree> getTrees(){
        return trees;
    }
    public void growAllTrees(){
        for (Tree tree : trees) {
            tree.grow();
        }
    }
    public List<Food> harvestAllTrees() {
        List<Food> foodBasket = new ArrayList<>();

        for (Tree tree : trees) {
            foodBasket.addAll(tree.harvest());
        }

        return foodBasket;
    }
}
