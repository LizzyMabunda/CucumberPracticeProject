package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AdminPanelPage;
import pageObjects.SignUpPage;
import pageObjects.LoginPage;


    public class Base {
        public static WebDriver driver;

        public static LoginPage loginPage;
        public static SignUpPage signUpPage;
        public static AdminPanelPage adminPanelPage;

        public static final String url = "https://ndosisimplifiedautomation.vercel.app/";
        public static final String browserName = "chrome";

        public static BrowserFactory browserFactory = new BrowserFactory();

        public static void initializeBrowser() {

            if (driver == null) {

                driver = browserFactory.startBrowser(browserName, url);

                loginPage = PageFactory.initElements(driver, LoginPage.class);
                signUpPage = PageFactory.initElements(driver, SignUpPage.class);
                adminPanelPage = PageFactory.initElements(driver, AdminPanelPage.class);
            }
        }

        public static void quitBrowser() {

            if (driver != null) {

                driver.quit();
                driver = null;
            }
        }
    }