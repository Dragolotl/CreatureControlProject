package CritterControl.Food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodTest {
    @Test
    public void testConstructor(){
        Food food = new Food("Cupcake", 5, 10);
        assertEquals("Cupcake", food.getName());
        assertEquals(5, food.getHealthValue());
        assertEquals(10, food.getHappinessValue());
    }
}
