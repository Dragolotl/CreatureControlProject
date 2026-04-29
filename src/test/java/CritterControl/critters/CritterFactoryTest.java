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
    public void testVelociraptorLevel5SetStrategy() {
        Critter raptor = critterFactory.createVelociraptor("Raptor", 5);

        raptor.setStrategy();

        assertInstanceOf(CritterControl.Strategy.VelociraptorLevel5Strategy.class, raptor.getStrategy());
    }

    @Test
    public void testVelociraptorLevel10SetStrategy() {
        Critter raptor = critterFactory.createVelociraptor("Raptor", 10);

        raptor.setStrategy();

        assertInstanceOf(CritterControl.Strategy.VelociraptorLevel10Strategy.class, raptor.getStrategy());
    }

    @Test
    public void testVelociraptorHasTypeAdvantageOverStrength() {
        Critter raptor = critterFactory.createVelociraptor("Raptor");
        Critter manny = critterFactory.createMinitaur("Manny");

        assertEquals(Critter.TYPE_ADVANTAGE_DAMAGE_BONUS, raptor.checkForTypeAdvantage(manny));
    }

    @Test
    public void testVelociraptorHasNoTypeAdvantageOverMagic() {
        Critter raptor = critterFactory.createVelociraptor("Raptor");
        Critter necro = critterFactory.createNecroBones("Necro");

        assertEquals(0, raptor.checkForTypeAdvantage(necro));
    }


}
