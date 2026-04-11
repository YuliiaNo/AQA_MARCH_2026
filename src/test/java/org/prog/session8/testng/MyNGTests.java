package org.prog.session8.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyNGTests {

    @Test
    public void myNgTest1() {
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i % 2, 0,
                    "I may be divided by 2 without remainder: " + i);
        }
    }

    @Test
    public void myNgTest2() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < 10; i++) {
            softAssert.assertEquals(i % 2, 0, "I may be divided by 2 without remainder: " + i);
        }
        softAssert.assertAll();
    }

    @Test(dataProvider = "data")
    public void myNgTest4(String string, String string2) {
        System.out.println("Print string: " + string + " and string2: " + string2);
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"string_1", "string_2"},
                {"string_2", "string_3"},
                {"string_3", "string_4"},
                {"string_4", "string_5"},
                {"string_5", "string_6"},
        };
    }
}
