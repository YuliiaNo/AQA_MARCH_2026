package session9HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

//TODO: write test to:
// - go to allo.ua
// - search for iphone
// - assert 1st card title is not null

public class WebTests1 {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void myWebTest1() throws InterruptedException {

        // Go to allo.ua
        driver.get("https://allo.ua/");
        Thread.sleep(2000);

        // Searching IPhone
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();
        searchBox.sendKeys("iphone");

        WebElement searchButton = driver.findElement(
                By.xpath("//button[contains(@class,'search-form__submit')]"));
        searchButton.click();

        Thread.sleep(3000);

        // Getting product cards
        List<WebElement> products = driver.findElements(
                By.xpath("//div[contains(@class,'product-card')]"));

        Assert.assertFalse(products.isEmpty(), "Products list is empty!");

        // Getting the first product title
        WebElement firstProduct = products.get(0);

        WebElement title = firstProduct.findElement(
                By.xpath(".//a[contains(@class,'product-card__title')]"));

        // Assert title is not null
        String titleText = title.getText();

        Assert.assertNotNull(titleText, "Title is null!");
        Assert.assertFalse(titleText.isEmpty(), "Title is empty!");

        System.out.println("First product: " + titleText);
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}