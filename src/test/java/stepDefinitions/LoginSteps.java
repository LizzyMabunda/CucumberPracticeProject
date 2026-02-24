package stepDefinitions;

import io.cucumber.java.en.*;
import utils.Base;
import utils.TestContext;

public class LoginSteps extends Base {

    @When("I login as admin")
    public void loginAsAdmin(){
        loginPage.enterUsername("admin@gmail.com");
        loginPage.enterPassword("@12345678");
        loginPage.clickLoginButton();
        String actualValue = loginPage.getLoginSuccessMessage();
        System.out.println("Actual login success message: " + actualValue);
        String expectedValue = "Welcome back, admin! \uD83D\uDC4B";
        org.testng.Assert.assertEquals(actualValue, expectedValue, "Expected message: " + expectedValue + ", but got: " + actualValue);

    }


}
