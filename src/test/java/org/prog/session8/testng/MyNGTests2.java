package org.prog.session8.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class MyNGTests2 extends AbstractTest {

    @AfterSuite
    public void afterSuite() {
        System.out.println("=========AFTER ALL==============");
    }


    @Test
    public void myNgTest() {
        System.out.println("myNgTest2");
    }
}
