package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/SignUp.feature",

        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/report.html"},
        monochrome = true
)

public class SignUpRunner extends AbstractTestNGCucumberTests {
}
