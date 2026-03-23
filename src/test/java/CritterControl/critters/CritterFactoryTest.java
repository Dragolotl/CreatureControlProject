package CritterControl.critters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CritterFactoryTest {
    CritterFactory critterFactory = new CritterFactory();

    //Since the functionality of each critter type is TBD, these tests won't do much yet
    //For now, they will only assertInstanceOf
    @Test
    public void testCritterType1() {
        Critter critter = critterFactory.createCritterType1("placeholder");
        assertInstanceOf(CritterType1.class, critter);
    }

    @Test
    public void testCritterType2() {
        Critter critter = critterFactory.createCritterType2("placeholder");
        assertInstanceOf(CritterType2.class, critter);
    }

    @Test
    public void testCritterType3() {
        Critter critter = critterFactory.createCritterType3("placeholder");
        assertInstanceOf(CritterType3.class, critter);
    }
}
