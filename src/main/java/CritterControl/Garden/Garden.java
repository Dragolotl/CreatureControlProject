package CritterControl.Garden;

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
    // harvest All Trees too right?
}
