package org.prog.session16;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.prog.session16.page.GooglePage;
import org.prog.session16.steps.DBSteps;
import org.prog.session16.steps.WebAtomicSteps;
import org.prog.session16.steps.WebSteps;
import org.prog.session16.util.DBConnectionFactory;
import org.prog.session16.util.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;

@CucumberOptions(
        tags = "@allure-demo",
        glue = "org.prog.session16.steps",
        features = "src/test/resources/features",
        plugin = {
                "json:target/Cucumber.json"
//                , "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
@Slf4j
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private WebDriver driver;
    private Connection connection;

    @BeforeSuite
    public void beforeSuite() throws SQLException, MalformedURLException {
        driver = WebDriverFactory.getDriver();
        connection = DBConnectionFactory.getConnection();
        DBSteps.connection = connection;
        DBSteps.statement = connection.createStatement();
        WebSteps.googlePage = new GooglePage(driver);
        WebAtomicSteps.driver = driver;
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        driver.quit();
        connection.close();
    }
}
