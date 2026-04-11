package org.prog.session8.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class AbstractTest {

    @BeforeClass
    public void beforeClass(){
        System.out.println("=========BEFORE CLASS==============");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("----------BEFORE TEST--------------");
    }
}
