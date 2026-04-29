package CritterControl.Food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {

    @Test
    public void testFoodStoresValues() {
        Food apple = new Food("Apple", 1);

        assertEquals("Apple", apple.getName());
        assertEquals(5, apple.getHealthValue());
        assertEquals(1, apple.getHappinessValue());
    }

    @Test
    public void testGoldenFoodAddsHealth() {
        Food apple = new Food("Apple", 1);
        Food goldenApple = new GoldenFood(apple);

        assertEquals(10, goldenApple.getHealthValue());
        assertEquals(1, goldenApple.getHappinessValue());
    }

    @Test
    public void testRainbowFoodAddsHappiness() {
        Food apple = new Food("Apple", 1);
        Food rainbowApple = new RainbowFood(apple);

        assertEquals(5, rainbowApple.getHealthValue());
        assertEquals(6, rainbowApple.getHappinessValue());
    }

    @Test
    public void testRottenFoodChangesHealthAndHappiness() {
        Food apple = new Food("Apple", 1);
        Food rottenApple = new RottenFood(apple);

        assertEquals(0, rottenApple.getHealthValue());
        assertEquals(-9, rottenApple.getHappinessValue());
    }
    @Test
    public void testToString() {
        Food food = new Food("Apple", 1);

        String result = food.toString();

        assertEquals("Apple (health: 5, happiness: 1)", result);
    }
}