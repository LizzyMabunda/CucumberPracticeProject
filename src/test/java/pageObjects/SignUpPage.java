package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataGenerator;

public class SignUpPage {
    WebDriver driver;
    @FindBy(xpath = "//span[text()=\"Login\"]\n")
    WebElement navLoginButtonXpath;
    @FindBy(id = "signup-toggle")
    WebElement signUpLinkid;
    @FindBy(id = "registration-heading")
    WebElement registrationHeadinID;
    @FindBy(id = "register-firstName")
    WebElement firstNameId;
    @FindBy(id = "register-lastName")
    WebElement lastNameId;
    @FindBy(id = "register-email")
    WebElement emailAddressId;
    @FindBy(id = "register-password")
    WebElement passwordId;
    @FindBy(id = "register-confirmPassword")
    WebElement confirmPasswordId;
    @FindBy(id = "register-group")
    WebElement selectGroupId;
    @FindBy(id = "register-submit")
    WebElement createAccountButtonId;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNavLoginButton() {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(navLoginButtonXpath));
        navLoginButtonXpath.click();
    }

     public void ClickOnSignUpLink() {
         new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(signUpLinkid));
         signUpLinkid.click();
     }

     public void verifyRegistrationHeadingIsDisplayed() {
         new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(registrationHeadinID));
         registrationHeadinID.isDisplayed();
     }

     public void enterFirstName(String firstName) {
         firstNameId.sendKeys(firstName);
     }

    public void enterLastName(String lastName) {
        lastNameId.sendKeys(lastName);
    }
    public void enterEmilAddress(String email){
        emailAddressId.sendKeys(email);

    }
    public void enterPassword(String password){
        passwordId.sendKeys("Testing@31");
    }

    public void enterConfirmPassword(String confirmPassword){
        confirmPasswordId.sendKeys("Testing@31");
    }
    public void selectYourGroup(){
        Select select = new Select(selectGroupId);
        select.selectByIndex(3);
    }

    public void clickCreateAccountButton(){
        createAccountButtonId.click();
    }
    public void verifySuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        if (alertText.equals("Registration submitted successfully. Your account is pending admin approval.")) {
            System.out.println("Alert message is correct: " + alertText);
        } else {
            System.out.println("Alert message is incorrect: " + alertText);
        }
        driver.switchTo().alert().accept();
    }


}
