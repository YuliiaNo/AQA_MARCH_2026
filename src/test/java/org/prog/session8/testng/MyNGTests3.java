package org.prog.session8.testng;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyNGTests3 extends AbstractTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("=========BEFORE ALL==============");
    }

    @Test
    public void myNgTest() {
        System.out.println("myNgTest3");
    }
}
