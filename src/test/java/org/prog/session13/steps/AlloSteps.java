       package org.prog.session13.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.prog.session12.DBHelper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AlloSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private DBHelper dbHelper;

    @Given("Open allo.ua")
    public void openAllo() throws Exception {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        dbHelper = new DBHelper();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/ua/");
    }

    @When("Search for {string}")
    public void searchFor(String searchText) {

        WebElement searchInput =
                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.name("q")
                                )
                );

        searchInput.sendKeys(searchText);

        searchInput.sendKeys(Keys.ENTER);
    }

    @When("Collect first 3 products")
    public void collectProducts() {

        List<Product> productsData =
                new ArrayList<>();

        wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.cssSelector(".product-card")
                        )
        );

        for (int i = 0; i < 3; i++) {

            List<WebElement> products =
                    driver.findElements(
                            By.cssSelector(".product-card")
                    );

            WebElement product =
                    products.get(i);

            String productName =
                    product.findElement(
                            By.cssSelector(
                                    ".product-card__title"
                            )
                    ).getText();

            System.out.println(productName);

            product.click();

            WebElement skuElement =
                    wait.until(
                            ExpectedConditions
                                    .visibilityOfElementLocated(
                                            By.cssSelector(
                                                    "[itemprop='sku']"
                                            )
                                    )
                    );

            String productCode =
                    skuElement.getText();

            System.out.println(productCode);

            productsData.add(
                    new Product(
                            productCode,
                            productName
                    )
            );

            driver.navigate().back();

            wait.until(
                    ExpectedConditions
                            .visibilityOfElementLocated(
                                    By.cssSelector(
                                            ".product-card"
                                    )
                            )
            );
        }

        DataManager.DATA.put(
                "products",
                productsData
        );
    }

    @Then("Save products to DB if absent")
    public void saveProducts() throws Exception {

        List<Product> products =
                (List<Product>)
                        DataManager.DATA.get(
                                "products"
                        );

        for (Product product : products) {

            boolean exists =
                    dbHelper.exists(
                            product.getCode(),
                            product.getName()
                    );

            if (!exists) {

                dbHelper.insert(
                        product.getCode(),
                        product.getName()
                );

            } else {

                System.out.println(
                        "Already exists in DB"
                );
            }
        }

        driver.quit();

        dbHelper.close();
    }
}

