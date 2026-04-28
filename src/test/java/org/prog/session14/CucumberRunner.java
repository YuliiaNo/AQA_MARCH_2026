package org.prog.session14;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session14.page.GooglePage;
import org.prog.session14.steps.DBSteps;
import org.prog.session14.steps.WebAtomicSteps;
import org.prog.session14.steps.WebSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.DriverManager;
import java.sql.SQLException;

//TODO: Adapt previous homework to cucumber

@CucumberOptions(
        tags = "@all_in_one",
        glue = "org.prog.session14.steps",
        features = "src/test/resources/features"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        driver = new ChromeDriver();
        DBSteps.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
        DBSteps.statement = DBSteps.connection.createStatement();
        WebSteps.googlePage = new GooglePage(driver);
        WebAtomicSteps.driver = driver;
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        DBSteps.connection.close();
        driver.quit();
    }
}
