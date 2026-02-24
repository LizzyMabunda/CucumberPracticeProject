package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



    @CucumberOptions(
            features = "src/test/resources/Features/AdminPanel.feature",

            glue = {"stepDefinitions", "hooks"},
            plugin = {"pretty", "html:target/report.html"},
            monochrome = true
    )

    public class AdminPanelRunner extends AbstractTestNGCucumberTests {
}
