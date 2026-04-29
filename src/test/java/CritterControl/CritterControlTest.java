//package CritterControl;
//
//import CritterControl.critters.Critter;
//import CritterControl.critters.CritterFactory;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class CritterControlTest {
//    @Test
//    public void testGoldModification(){
//        CritterCorral corral = new CritterCorral();
//        CritterControl critterControl = new CritterControl(corral);
//
//        critterControl.addGold(40);
//        assertEquals(40, critterControl.getGold());
//
//        critterControl.loseGold(25);
//        assertEquals(15, critterControl.getGold());
//
//        critterControl.loseGold(25);
//        assertEquals(0, critterControl.getGold());
//    }
//    @Test
//    public void testMinimumGold(){
//        CritterCorral corral = new CritterCorral();
//        CritterControl critterControl = new CritterControl(corral);
//
//        critterControl.addGold(10);
//        critterControl.loseGold(11);
//
//        assertEquals(0, critterControl.getGold());
//    }
////    @Test
////    public void testMinimumFoodAmount() {
////        CritterCorral corral = new CritterCorral();
////        CritterControl critterControl = new CritterControl(corral);
////
////        critterControl.addFood(5);
////        critterControl.loseFood(10);
////
////        assertEquals(0, critterControl.getFoodAmount());
////    }
//
//    @Test
//    public void testPlayerSelectCritter(){
//        CritterCorral corral = new CritterCorral();
//        CritterControl critterControl = new CritterControl(corral);
//        CritterFactory critterFactory = new CritterFactory();
//        Critter manny = critterFactory.createMinitaur("Manny");
//        corral.add(manny);
//
//        critterControl.play();
//    }
//}