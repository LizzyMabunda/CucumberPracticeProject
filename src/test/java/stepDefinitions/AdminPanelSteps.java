package stepDefinitions;

import io.cucumber.java.en.*;
import utils.Base;
import utils.TestContext;


public class AdminPanelSteps extends Base{

    @Given("I am logged in as an admin")
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
    @Then("the successful pop-up message should be displayed")
    public void SuccessfulPopupMessageDisplayed() {
        adminPanelPage.SuccessfullyApprovedMessage();

    }

}
