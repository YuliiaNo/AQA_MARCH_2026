package org.prog.session16.codedriven;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class FakeWebDriver {

    @Step("Finding web element: {locator}")
    public void findElement(By locator) {
        log.info("Find Element: " + locator);
    }

    @Step("Clicking web element: {locator}")
    public void clickElement(By locator) {
        log.info("Click Element: " + locator);
    }
}
