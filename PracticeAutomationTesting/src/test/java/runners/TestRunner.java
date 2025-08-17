package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = "src/test/resources/features",
		glue = {"amazon.stepdefinitions","hooks"},
		plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"},
		tags = "@HomePage",
		dryRun = false,
		monochrome = true
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
