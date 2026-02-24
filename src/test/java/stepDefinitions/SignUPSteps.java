package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.SignUpPage;
import utils.Base;
import utils.DataGenerator;
import utils.TestContext;


public class SignUPSteps extends Base {

    @Given("I am on the login page")
    public void IamOnTheLoginPage() {
        signUpPage.clickNavLoginButton();
    }

    @When("I click on sign up here link")
    public void ClickOnSignUpLink(){
        signUpPage.ClickOnSignUpLink();

    }
    @Then("I should be redirected to the create your account form")
    public void RedirectedToCreateAccountForm(){
        signUpPage.verifyRegistrationHeadingIsDisplayed();

    }

    @When("I generate random user data")
    public void generateRandomUserData(){

        TestContext.firstName = DataGenerator.getFirstName();
        TestContext.lastName = DataGenerator.getLastName();
        TestContext.email = DataGenerator.getEmail();

        System.out.println("Saved Email: " + TestContext.email);
    }

    @And("I enter first name")
    public void enterFirstName(){
        signUpPage.enterFirstName(TestContext.firstName);

    }
    @And("I enter Last name")
    public void enterLastName(){
        signUpPage.enterLastName(TestContext.lastName);

    }
    @And("I enter valid email address")
    public void enterEmailAddress(){
        signUpPage.enterEmilAddress(TestContext.email);

    }
    @And("I enter password {}")
    public void enterPassword(String password){
        signUpPage.enterPassword(password);

    }
    @And("I enter confirm password {}")
    public void enterConfirmPassword(String confirmPassword){
        signUpPage.enterConfirmPassword(confirmPassword);

    }
    @And("Select Your group")
    public void selectYourGroup(){
        signUpPage.selectYourGroup();

    }
    @And("I click the Create account button")
    public void clickCreateAccountButton(){
        signUpPage.clickCreateAccountButton();

    }
    @Then("I should get a success registration message pop-up")
    public void verifySuccessRegistrationMessage(){
        signUpPage.verifySuccessMessage();

    }

}
