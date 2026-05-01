package CritterControl;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CritterControlTest {

    @Test
    public void testConstructorWithCorral() {
        CritterCorral corral = new CritterCorral();
        CritterControl critterControl = new CritterControl(corral);

        assertNotNull(critterControl);
    }

    @Test
    public void testDefaultConstructor() {
        CritterControl critterControl = new CritterControl();

        assertNotNull(critterControl);
    }









}