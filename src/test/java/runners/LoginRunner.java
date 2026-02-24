package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Base;

@CucumberOptions(
            features = "src/test/resources/Features/Login.feature",
            glue = {"stepDefinitions", "hooks"},
            plugin = {"pretty", "html:target/report.html"},
            monochrome = true
    )

    public class LoginRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void setupBrowser() {

        Base.initializeBrowser();
        System.out.println("Browser started once for Login feature");
    }

    @AfterClass
    public void tearDownBrowser() {

        Base.quitBrowser();
        System.out.println("Browser closed after all Login scenarios");
    }


}
