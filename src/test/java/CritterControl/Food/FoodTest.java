package CritterControl.Food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {

    @Test
    public void testFoodStoresValues() {
        Food apple = new Food("Apple", 1,1);

        assertEquals("Apple", apple.getName());
        assertEquals(1, apple.getHappinessValue());
    }


    @Test
    public void testRainbowFoodAddsHappiness() {
        Food apple = new Food("Apple", 1,1);
        Food rainbowApple = new RainbowFood(apple);

        assertEquals(6, rainbowApple.getHappinessValue());
    }

    @Test
    public void testRottenFoodChangesHealthAndHappiness() {
        Food apple = new Food("Apple", 1,1);
        Food rottenApple = new RottenFood(apple);

        assertEquals(-9, rottenApple.getHappinessValue());
    }
    @Test
    public void testToString() {
        Food food = new Food("Apple", 1,1);

        String result = food.toString();

        assertEquals("Apple (happiness: 1)", result);
    }
}