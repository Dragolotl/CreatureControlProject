package CritterControl.Strategy;

import CritterControl.critters.Critter;
import CritterControl.critters.CritterFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {

    CritterFactory factory = new CritterFactory();

    @Test
    public void testBaseStrategyDefaults() {
        BaseStrategy strategy = new BaseStrategy();

        assertFalse(strategy.isStunned());
        assertFalse(strategy.dodged());
        assertEquals(0, strategy.getDamageReduction());
    }

    @Test
    public void testVelociraptorDodgeBonusLevel5() {
        VelociraptorLevel5Strategy strategy = new VelociraptorLevel5Strategy();

        strategy.setDodged(true);

        assertEquals(1, strategy.addDodgeDamageBonus());
    }

    @Test
    public void testVelociraptorDodgeBonusLevel10() {
        VelociraptorLevel10Strategy strategy = new VelociraptorLevel10Strategy();

        strategy.setDodged(true);

        assertEquals(2, strategy.addDodgeDamageBonus());
    }

    @Test
    public void testMinitaurStun() {
        Critter attacker = factory.createMinitaur("Manny");
        Critter defender = factory.createVelociraptor("Raptor");

        MinitaurLevel5Strategy strategy = new MinitaurLevel5Strategy();

        strategy.tryStun(defender, 10, 10);

        assertTrue(defender.getStrategy().isStunned());
    }

    @Test
    public void testNecroBonesDamageReduction() {
        Critter attacker = factory.createNecroBones("Necro");
        Critter defender = factory.createVelociraptor("Raptor");

        NecroBonesLevel5Strategy strategy = new NecroBonesLevel5Strategy();

        strategy.drain(defender);

        assertTrue(defender.getStrategy().getDamageReduction() >= 0);
    }

    @Test
    public void testNecroBonesLevel10StealDamage() {
        NecroBonesLevel10Strategy strategy = new NecroBonesLevel10Strategy();

        assertEquals(1, strategy.shouldStealEnemyDamage());
    }
    @Test
    public void testMinitaurLevel10StunsOneBelowThreshold() {
        Critter defender = factory.createVelociraptor("Raptor");
        MinitaurLevel10Strategy strategy = new MinitaurLevel10Strategy();

        strategy.tryStun(defender, 9, 10);

        assertTrue(defender.getStrategy().isStunned());
    }

    @Test
    public void testMinitaurLevel10DoesNotStunTooLow() {
        Critter defender = factory.createVelociraptor("Raptor");
        MinitaurLevel10Strategy strategy = new MinitaurLevel10Strategy();

        strategy.tryStun(defender, 8, 10);

        assertFalse(defender.getStrategy().isStunned());
    }

    @Test
    public void strategyFactoryWorksForAllStrategies() {
        StrategyFactory factory = new StrategyFactory();

        assertInstanceOf(BaseStrategy.class, factory.BaseStrategy());
        assertInstanceOf(MinitaurLevel5Strategy.class, factory.MinitaurLevel5Strategy());
        assertInstanceOf(MinitaurLevel10Strategy.class, factory.MinitaurLevel10Strategy());
        assertInstanceOf(VelociraptorLevel5Strategy.class, factory.VelociraptorLevel5Strategy());
        assertInstanceOf(VelociraptorLevel10Strategy.class, factory.VelociraptorLevel10Strategy());
        assertInstanceOf(NecroBonesLevel5Strategy.class, factory.NecroBonesLevel5Strategy());
        assertInstanceOf(NecroBonesLevel10Strategy.class, factory.NecroBonesLevel10Strategy());
    }
    @Test
    public void testResetDamageReduction() {
        BaseStrategy strategy = new BaseStrategy();

        strategy.increaseCritterDamageReduction();
        strategy.increaseCritterDamageReduction();

        assertTrue(strategy.getDamageReduction() > 0);

        strategy.resetDamageReduction();

        assertEquals(0, strategy.getDamageReduction());
    }
}