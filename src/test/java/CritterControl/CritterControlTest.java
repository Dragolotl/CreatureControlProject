package CritterControl;

import CritterControl.CritterControl;
import CritterControl.CritterCorral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CritterControlTest {
    @Test
    public void testGoldModification(){
        CritterCorral corral = new CritterCorral();
        CritterControl critterControl = new CritterControl(corral);

        critterControl.addGold(40);
        assertEquals(40, critterControl.getGold());

        critterControl.loseGold(25);
        assertEquals(15, critterControl.getGold());

        critterControl.loseGold(25);
        assertEquals(0, critterControl.getGold());
    }
    @Test
    public void testMinimumGold(){
        CritterCorral corral = new CritterCorral();
        CritterControl critterControl = new CritterControl(corral);

        critterControl.addGold(10);
        critterControl.loseGold(11);

        assertEquals(0, critterControl.getGold());
    }
    @Test
    public void testMinimumFoodAmount() {
        CritterCorral corral = new CritterCorral();
        CritterControl critterControl = new CritterControl(corral);

        critterControl.addFood(5);
        critterControl.loseFood(10);

        assertEquals(0, critterControl.getFoodAmount());
    }
}