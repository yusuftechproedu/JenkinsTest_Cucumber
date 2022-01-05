package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-html-report"},
        glue= {"src/test/java/stepdefinitions"},
        features= {"src/test/resources/features"},
        dryRun=true,
        tags="@smoke"
)
public class TestRunner {

}
