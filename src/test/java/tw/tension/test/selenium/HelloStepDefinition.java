package tw.tension.test.selenium;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Rickey Huang on 2016/7/7.
 */
@StepDefAnnotation
public class HelloStepDefinition {
    
    private Hello hello;
    
    private static final Logger log = LoggerFactory.getLogger(HelloStepDefinition.class.getName());
    
    @Given("^I got a greeting object called Hello$")
    public void iGotAGreetingObjectCalledHello() throws Throwable {
        log.info("create a hello object");
        hello = new Hello();
    }

    @When("^I call greeting method, and give (.+) name$")
    public void iCallGreetingMethodAndGiveUserName(String name) throws Throwable {
        log.info("given user: {}", name);
        hello.setName(name);

    }

    @Then("^print (.+) hello!$")
    public void printUserHello(String name) throws Throwable {
        log.info("given user: {}", name);
        log.info("greeting: {}", hello.greeting());
        String expected = name + " hello!";
        Assert.assertEquals(expected, hello.greeting());
    }
}
