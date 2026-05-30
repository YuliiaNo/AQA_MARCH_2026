package org.prog.session16.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import java.util.Random;

@Slf4j
public class AllureDemoSteps {

    private final static Random random = new Random();

    @Given("I have preconditions")
    public void iHavePreconditions() {
        log.info("Test sets up some preconditions...");
    }

    @When("I make some actions")
    public void iMakeSomeActions() {
        log.info("Test takes some actions...");
    }

    @Then("I get some results")
    public void iGetSomeResults() {
        int i = random.nextInt(100);
        Assert.assertTrue(i <= 85, "I was greater than 85");
    }
}
