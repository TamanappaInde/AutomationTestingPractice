package hooks;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = BaseClass.initBrowser("chrome");
        driver.get("https://practice.automationtesting.in/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
