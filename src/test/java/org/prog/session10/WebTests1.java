package org.prog.session10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;


public class WebTests1 {

    private WebDriver driver;
    private AlloPage alloPage;

    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        // maximize window
        driver.manage().window().maximize();

        alloPage = new AlloPage(driver);
    }

    @Test
    public void myWebTest1() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // go to allo.ua
        alloPage.load();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));


        // search iphone
        alloPage.search("iphone");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'product-card')]")
        ));

        //  get products
        List<WebElement> products = alloPage.getProducts();

        Assert.assertTrue(products.size() >= 3, "Less than 3 products!");

        // check first 3 products
        for (int i = 0; i < 3; i++) {

            String code = alloPage.getProductCode(products.get(i));

            Assert.assertNotNull(code, "Product code is null!");
            Assert.assertFalse(code.isEmpty(), "Product code is empty!");

            System.out.println("Product " + (i + 1) + " code: " + code);
        }
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}