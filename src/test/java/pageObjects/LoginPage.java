package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "login-email")
    WebElement usernameFieldId;
    @FindBy(id = "login-password")
    WebElement passwordFieldId;
    @FindBy(id = "login-submit")
    WebElement loginButtonId;
    @FindBy(xpath = "//h2[contains(text(),'Welcome back, ')]")
    WebElement verifyLoginIsSuccessfullyXpath;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(usernameFieldId));
        usernameFieldId.clear();
        usernameFieldId.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordFieldId.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButtonId.click();
    }

    public String getLoginSuccessMessage() {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(verifyLoginIsSuccessfullyXpath));
        return verifyLoginIsSuccessfullyXpath.getText();
    }


}
