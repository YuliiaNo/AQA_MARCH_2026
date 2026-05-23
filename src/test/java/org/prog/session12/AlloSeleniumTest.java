package org.prog.session12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

public class AlloSeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private DBHelper dbHelper;

    @BeforeSuite
    public void beforeSuite() throws SQLException {

        dbHelper = new DBHelper();

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        driver.manage().window().maximize();
    }

    @Test
    public void alloTest() throws SQLException {

        // open allo.ua
        driver.get("https://allo.ua/ua/");

        // search iphone
        WebElement searchInput =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.name("q")
                        )
                );

        searchInput.sendKeys("iphone");

        searchInput.sendKeys(Keys.ENTER);

        // wait products
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".product-card")
                )
        );

        // get first 3 products
        List<WebElement> products =
                driver.findElements(
                        By.cssSelector(".product-card")
                );

        for (int i = 0; i < 3; i++) {

            // find elements again after navigation
            products = driver.findElements(
                    By.cssSelector(".product-card")
            );

            WebElement product = products.get(i);

            // get product name
            String productName =
                    product.findElement(
                            By.cssSelector(".product-card__title")
                    ).getText();

            System.out.println(productName);

            // open product page
            product.click();

            // wait
            WebElement skuElement =
                    wait.until(
                            ExpectedConditions.visibilityOfElementLocated(
                                    By.cssSelector("[itemprop='sku']")
                            )
                    );

            // get code
            String productCode =
                    skuElement.getText();

            System.out.println(productCode);

            // check DB
            boolean exists =
                    dbHelper.exists(
                            productCode,
                            productName
                    );

            // insert if not exists
            if (!exists) {

                dbHelper.insert(
                        productCode,
                        productName
                );

            } else {

                System.out.println(
                        "Already exists in DB"
                );
            }

            // return back
            driver.navigate().back();

            // wait products again
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".product-card")
                    )
            );
        }
    }

    @AfterSuite
    public void afterSuite()
            throws SQLException {

        driver.quit();

        dbHelper.close();
    }
}