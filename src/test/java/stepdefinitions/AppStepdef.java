package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppStepdef {


    WebDriver driver;

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://etsy.com");
    }

    @When("I search for {string}")
    public void i_search_for(String search) {
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys(search + Keys.ENTER);
    }

    @Then("I should see the results")
    public void i_should_see_the_results() {
        Assert.assertTrue(driver.getCurrentUrl().contains("search"));
    }

    @Then("I should see more results")
    public void i_should_see_more_results() {
      //  Assert.assertTrue(driver.getTitle().contains("XXXXXX"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","screenshots");
        }
        driver.quit();
    }
}
