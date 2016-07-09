package tw.tension.test.selenium;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Rickey Huang on 2016/7/9.
 */
@StepDefAnnotation
public class SeleniumSampleStepDef {

    private static final Logger log = LoggerFactory.getLogger(SeleniumSampleStepDef.class);

    private WebDriver webDriver;

    @Given("^Create a Firefox driver and connect to Google website$")
    public void createAFirefoxDriverAndConnectToGoogleWebsite() throws Throwable {
        log.info("creating firefox web driver...");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        webDriver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        log.info("After creating firefox driver and start connecting to google");
        webDriver.get("http://www.google.com.tw");
    }

    @When("^Input the keyword 'marvel' and submit$")
    public void inputTheKeywordMarvelAndSubmit() throws Throwable {

        log.info("Find the text input element by its name");
        WebElement element = webDriver.findElement(By.name("q"));

        log.info("Enter something to searchFind the text input element by its name for");
        element.sendKeys("marvel");

        log.info("Now submit the form. WebDriver will find the form for us from the element");
        element.submit();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        log.info("waiting for search response page");
        (new WebDriverWait(webDriver, 5)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("marvel");
            }
        });
    }


    @Then("^Get the title of returned page which is 'marvel'$")
    public void getTheTitleOfReturnedPageWhichIsMarvel() throws Throwable {

        log.info("page title: {}", webDriver.getTitle());
        Assert.assertTrue(webDriver.getTitle().startsWith("marvel"));
        log.info("closing web driver");
        webDriver.quit();
    }
}
