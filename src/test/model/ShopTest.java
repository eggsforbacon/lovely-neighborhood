package model;

import exceptions.IncorrectTypeException;
import exceptions.InvalidForTheDayException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ShopTest {

    @Test
    public void testCreateUser1() {
        Shop testShop = new Shop();

        String newTypeTest = "CC";
        String newIdTest = "66806902";

        try {
            testShop.createUser(newTypeTest, newIdTest);
        } catch (IncorrectTypeException typeException) {
            if (typeException.getMessage().contains("menores")) fail("Underage person. Test failed");
            else fail("Invalid type. Test failed");
        } catch (InvalidForTheDayException dayException) {
            fail("Invalid for the day. Test failed");
        }
    }

    @Test
    public void testCreateUser2() {
        Shop testShop = new Shop();

        String newTypeTest = "literallyanythingthatisntincluded";
        String newIdTest = "1006011433";

        try {
            testShop.createUser(newTypeTest, newIdTest);
        } catch (IncorrectTypeException typeException) {
            if (typeException.getMessage().contains("menores")) fail("Underage person. Test failed");
            else fail("Invalid type. Test failed");
        } catch (InvalidForTheDayException dayException) {
            fail("Invalid for the day. Test failed");
        }
    }

    @Test
    public void testCreateUser3() {
        Shop testShop = new Shop();

        String newTypeTest = "TI";
        String newIdTest = "1006011433";

        try {
            testShop.createUser(newTypeTest, newIdTest);
        } catch (IncorrectTypeException typeException) {
            if (typeException.getMessage().contains("menores")) fail("Underage person. Test failed");
            else fail("Invalid type. Test failed");
        } catch (InvalidForTheDayException dayException) {
            fail("Invalid for the day. Test failed");
        }
    }

    @Test
    public void testCreateUser4() {
        Shop testShop = new Shop();

        String newTypeTest = "CC";
        String newIdTest = "1006011433";

        try {
            testShop.createUser(newTypeTest, newIdTest);
        } catch (IncorrectTypeException typeException) {
            if (typeException.getMessage().contains("menores")) fail("Underage person. Test failed");
            else fail("Invalid type. Test failed");
        } catch (InvalidForTheDayException dayException) {
            fail("Invalid for the day. Test failed");
        }
    }
}