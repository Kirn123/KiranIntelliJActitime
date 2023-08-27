import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ActitimeTestClassWithTestNG {

    WebDriver driver;
    ActitimeLoginPageTestNG login;
    ActitimeHomePageTestNG  home;


    @BeforeClass
    public void launchBrowser()
    {
        System.out.println("Browser Launched");
        System.setProperty("webdriver.chrome.driver", "E:\\velocity\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/login.do");
        login = new ActitimeLoginPageTestNG(driver);
        home = new  ActitimeHomePageTestNG(driver);
    }

    @AfterClass
    public void quitBrowser()
    {
        System.out.println("Browser is quit");
        driver.quit();
    }

    @BeforeMethod
    public void performLogin()
    {
        System.out.println("Actions are being performed");
        login.setActitimeLoginPageUsername();
        login.setActitimeLoginPagePassword();
        login.setActitimeLoginPageLoginButton();
    }

    @AfterMethod
    public void performLogout()
    {
        System.out.println("Doing logout");
        home.setActitimtHomePageLogout();
    }

    @Test(priority = 1)
    public void verifyLogo()
    {
        System.out.println("Verification started");
        home.verifyActitimtHomePageHeader();

    }



    @Test (priority = 3)
    public void verifyadministratorSystemLink() throws InterruptedException
    {
        System.out.println("Clicking on Administrator System");
        home.clickOnAdministratorSystem();
    }

}





