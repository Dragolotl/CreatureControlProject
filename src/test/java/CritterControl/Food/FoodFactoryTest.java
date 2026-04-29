package CritterControl.Food;

import CritterControl.FixedDie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodFactoryTest {

    @Test
    public void testCreateFoodMakesGoldenFoodOnTwenty() {
        FoodFactory factory = new FoodFactory(new FixedDie(20));

        Food food = factory.createFood(FoodType.APPLE);

        assertInstanceOf(GoldenFood.class, food);
    }

    @Test
    public void testCreateFoodMakesRottenFoodOnOne() {
        FoodFactory factory = new FoodFactory(new FixedDie(1));

        Food food = factory.createFood(FoodType.APPLE);

        assertInstanceOf(RottenFood.class, food);
    }

    @Test
    public void testCreateRandomFoodReturnsFood() {
        FoodFactory factory = new FoodFactory();

        Food food = factory.createRandomFood(7);

        assertNotNull(food);
    }
}