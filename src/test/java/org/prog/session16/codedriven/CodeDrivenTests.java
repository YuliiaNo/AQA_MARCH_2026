package org.prog.session16.codedriven;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CodeDrivenTests {

    private FakeDBUtil fakeDBUtil = new FakeDBUtil();
    private FakeWebDriver fakeWebDriver = new FakeWebDriver();

    @Test
    public void someTest() {
        String s = fakeDBUtil.getDBRecord();
        fakeWebDriver.findElement(By.xpath("test"));
        fakeWebDriver.clickElement(By.xpath("test"));
        fakeDBUtil.storeDBRecord(s);
    }
}
