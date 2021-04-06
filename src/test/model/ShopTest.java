package model;

import exceptions.IncorrectTypeException;
import exceptions.InvalidForTheDayException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    private String newTypeTest = "";
    private String newEvenIdTest = "";
    private String newOddIdTest = "";
    private final Shop testShop = new Shop();

    //Successful scenario
    public void setUpScenario1() {
        newTypeTest = "CC";
        newOddIdTest = "66806902";
        newEvenIdTest = "1006011433";
    }

    //Underage fail
    public void setUpScenario2() {
        newTypeTest = "TI";
        newEvenIdTest = "1006011433";
        newOddIdTest = "66806902";
    }

    //Date fail
    public void setUpScenario3() {
        newTypeTest = "CC";
        newOddIdTest = "66806912";
        newEvenIdTest = "1006011423";
    }

    @Test
    public void testCreateUser() {
        try {
            if (testShop.getCurrentDay() % 2 == 0)
            testShop.createUser(newTypeTest, newEvenIdTest);
            else testShop.createUser(newTypeTest, newOddIdTest);
        } catch (IncorrectTypeException typeException) {
            if (typeException.getMessage().contains("menores")) fail("Underage person. Test failed");
            else fail("Invalid type. Test failed");
        } catch (InvalidForTheDayException dayException) {
            fail("Invalid for the day. Test failed");
        } catch (Exception e) {
            fail("Something else went wrong");
        }
    }
}
