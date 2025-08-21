package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = "C:\\Users\\Admin\\git\\PracticeAutomationTesting\\PracticeAutomationTesting\\src\\test\\resources\\features",
		glue = {"stepdefinitions","hooks"},
		plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"},
		tags = "@HomePage",
		dryRun = false,
		monochrome = true
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
