package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPanelPage {
    WebDriver driver;

    public AdminPanelPage(WebDriver driver) {
        this.driver = driver;              // ✅ ASSIGN DRIVER
    }

    @FindBy(xpath = "//button[.//span[normalize-space()=\"admin\"]]")
    WebElement loggedInUserXpath;
    @FindBy(xpath = "//button[.//span[normalize-space()=\"Admin Panel\"]]")
    WebElement adminPanelButtonXpath;
    @FindBy(xpath = "//p[contains(text(),\"Welcome back, Admin!\")]")
    WebElement adminPanelHeadingXpath;
    @FindBy(xpath = "//button[contains(normalize-space(),\"Approvals\")]")
    WebElement approvalsTabXpath;
    @FindBy(xpath = "//input[contains(@placeholder,\"Search by email\")]")
    WebElement searchByEmailFieldXpath;
    @FindBy(xpath = "//button[contains(normalize-space(),\"Approve\")]")
    WebElement approveButtonXpath;
    @FindBy(xpath = "//div[contains(normalize-space(),\"User approved successfully!\")]")
    WebElement userApprovedSuccessfullyMessageXpath;

    public void verifyAdminLoggedInSuccessfully() {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(loggedInUserXpath));
        loggedInUserXpath.click();
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(adminPanelButtonXpath));
        adminPanelButtonXpath.click();
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(adminPanelHeadingXpath));
        adminPanelHeadingXpath.isDisplayed();

    }
    public void clickApprovalsTab() {
        approvalsTabXpath.click();
    }
    public void approveNewRegisteredUser(String email) {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(searchByEmailFieldXpath));
        searchByEmailFieldXpath.sendKeys(email);

        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(approveButtonXpath));
        approveButtonXpath.click();

    }
    public void SuccessfullyApprovedMessage() {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(userApprovedSuccessfullyMessageXpath));
        userApprovedSuccessfullyMessageXpath.isDisplayed();

    }


}
