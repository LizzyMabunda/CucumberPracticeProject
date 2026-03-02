package stepDefinitions;

import io.cucumber.java.en.*;
import utils.Base;
import utils.TestContext;


public class AdminPanelSteps extends Base {

    @Given("I navigate to Admin panel page")
    public void IAmLoggedInAsAdmin() {
        adminPanelPage.verifyAdminLoggedInSuccessfully();

    }

    @When("I navigate to the pending users section")
    public void INavigateToPendingApprovalsUsersTab() {
        adminPanelPage.clickApprovalsTab();

    }

    @And("I approve a pending user")
    public void IApprovePendingUser() {
        adminPanelPage.approveNewRegisteredUser(TestContext.email);
    }

    @And("the successful pop-up message should be displayed")
    public void SuccessfulPopupMessageDisplayed() {
        adminPanelPage.SuccessfullyApprovedMessage();

    }

    @And("I navigate back to main page")
    public void clickBackToWebsiteButton() {
        adminPanelPage.clickBackToWebsiteButton();
    }
    @Then("I log-out")
    public void clickLogoutButton() {
        adminPanelPage.Logout();
    }


    @When("I navigate to the user management section")
    public void INavigateToUsersTab() {
        adminPanelPage.clickUsersTab();
    }

    @And("I make the user an admin")
    public void changeUserRoleToAdminRole() {
        adminPanelPage.changeUserRoleToAdminRole(TestContext.email);

    }

    @Then("the successful pop-up message should be displayed for role change")
    public void verifyUserRoleChangedSuccessful() {
        adminPanelPage.verifyUserRoleChangedSuccessful();
    }
    @And("I Login as new admin")
    public void loginAsNewAdmin() {

        signUpPage.clickNavLoginButton();

        loginPage.enterUsername(TestContext.email);
        loginPage.enterPassword("Testing@31");
        loginPage.clickLoginButton();
        String actualValue = loginPage.getLoginSuccessMessage();
        System.out.println("Actual login success message: " + actualValue);
        String expectedValue = "Welcome back, " + TestContext.firstName + "! \uD83D\uDC4B";
        org.testng.Assert.assertEquals(actualValue, expectedValue, "Expected message: " + expectedValue + ", but got: " + actualValue);
    }


}
