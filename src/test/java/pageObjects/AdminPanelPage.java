package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPanelPage {
    WebDriver driver;

    public AdminPanelPage(WebDriver driver) {
        this.driver = driver;              // ✅ ASSIGN DRIVER
    }

    @FindBy(xpath = "//button[contains(@class,'user-pill')]")
    WebElement loggedInUserXpath;
    @FindBy(xpath = "//button[.//span[normalize-space()=\"Admin Panel\"]]")
    WebElement adminPanelButtonXpath;
    @FindBy(xpath = "//p[contains(text(),\"Welcome back, Admin!\")]")
    WebElement adminPanelHeadingXpath;
    @FindBy(xpath = "//button[contains(normalize-space(),\"Approvals\")]")
    WebElement approvalsTabXpath;
    @FindBy(xpath = "//input[@placeholder='Search by name or email...']")
    WebElement searchByEmailFieldXpath;
    @FindBy(xpath = "//button[contains(normalize-space(),'Approve')]")
    WebElement approveButtonXpath;
    @FindBy(xpath = "//div[contains(normalize-space(),\"User approved successfully!\")]")
    WebElement userApprovedSuccessfullyMessageXpath;
    @FindBy(xpath = "//button[contains(.,'Users')]")
    WebElement usersTabXpath;
    @FindBy(xpath = "//select[option[@value='admin']]")
    WebElement userRoleOptionXpath;
    @FindBy(xpath = "//button[normalize-space()='← Back to Website']")
    WebElement backToWebSiteButtonXpath;
    @FindBy(xpath = "//button[.//span[text()='Logout']]")
    WebElement logoutButtonXpath;
    @FindBy(xpath = "//input[@placeholder='\uD83D\uDD0D Search users...']")
    WebElement searchUserByEmailFieldXpath;
    @FindBy(id = "login-email")
    WebElement usernameFieldId;
    @FindBy(id = "login-password")
    WebElement passwordFieldId;
    @FindBy(id = "login-submit")
    WebElement loginButtonId;


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
    public void clickBackToWebsiteButton() {
        backToWebSiteButtonXpath.click();

    }
    public void Logout() {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(loggedInUserXpath));
        loggedInUserXpath.click();
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(logoutButtonXpath));
        logoutButtonXpath.click();

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText2 = driver.switchTo().alert().getText();
        if (alertText2.equals("Are you sure you want to logout?")) {
            System.out.println("Message is correct: " + alertText2);
        } else {
            System.out.println("Alert message is incorrect: " + alertText2);
        }
        driver.switchTo().alert().accept();
    }
        public void clickUsersTab() {
            new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(usersTabXpath));
            usersTabXpath.click();
    }
        public void changeUserRoleToAdminRole(String email) {
            new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(searchUserByEmailFieldXpath));
            searchUserByEmailFieldXpath.sendKeys(email);

            new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(userRoleOptionXpath));
            Select select = new Select(userRoleOptionXpath);
            select.selectByValue("admin");

            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            if (alertText.equals("Are you sure you want to change this user's role to \"admin\"?")) {
                System.out.println("Alert message is correct: " + alertText);
            } else {
                System.out.println("Alert message is incorrect: " + alertText);
            }
            driver.switchTo().alert().accept();
        }
        public void verifyUserRoleChangedSuccessful() {

            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText2 = driver.switchTo().alert().getText();
            if (alertText2.equals("User role updated to \"admin\" successfully!")) {
                System.out.println("User role changed to Admin: " + alertText2);
            } else {
                System.out.println("Alert message is incorrect: " + alertText2);
            }
            driver.switchTo().alert().accept();
        }

        public void loginAsNewAdmin(String email, String password) {

            new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(loggedInUserXpath));
            loggedInUserXpath.click();

            new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(usernameFieldId));
            usernameFieldId.clear();
            usernameFieldId.sendKeys(email);
            passwordFieldId.sendKeys(password);
            loginButtonId.click();

        }



}
