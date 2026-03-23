package CritterControl;

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
}
