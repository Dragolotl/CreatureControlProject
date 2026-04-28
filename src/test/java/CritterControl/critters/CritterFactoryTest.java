package CritterControl.critters;

import org.junit.jupiter.api.Test;

import static CritterControl.critters.CritterType.MAGIC;
import static org.junit.jupiter.api.Assertions.*;

public class CritterFactoryTest {
    CritterFactory critterFactory = new CritterFactory();

    //Since the functionality of each critter type is TBD, these tests won't do much yet
    //For now, they will only assertInstanceOf
    @Test
    public void testCritterType1() {
        Critter critter = critterFactory.createMinitaur("placeholder");
        assertInstanceOf(Minitaur.class, critter);
        assertEquals("placeholder",critter.getName());
    }

    @Test
    public void testCritterType2() {
        Critter critter = critterFactory.createNecroBones("placeholder");
        assertInstanceOf(NecroBones.class, critter);
    }

    @Test
    public void testCritterType3() {
        Critter critter = critterFactory.createVelociraptor("placeholder");
        assertInstanceOf(Velociraptor.class, critter);
    }

    @Test
    public void testMakeCritterOfTypeMagic(){
        Critter critter = critterFactory.createCritter(MAGIC);
        assertInstanceOf(NecroBones.class, critter);
    }

    @Test
    public void testMakeCritterOfTypeMagic(){
        Critter critter = critterFactory.createCritter(MAGIC);
        assertInstanceOf(NecroBones.class, critter);
    }
}
