import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ActitimeHomePageTestNG {



    @FindBy(xpath = "//img[@src='/img/default/"
            + "top_nav/default-logo.png?hash=274618146']")
    private WebElement header;

    @FindBy(xpath = "//a[@id='logoutLink']")
    private WebElement logout;

    @FindBy(how= How.XPATH,using="//div[text()='Tasks']")
    private WebElement task;

    @FindBy(how=How.XPATH,using = "//input[@name = 'taskSelected[1]']")
    private WebElement CB1;

    @FindBy(xpath = "//input[@name = 'taskSelected[2]']")
    private WebElement CB2;

    @FindBy(xpath = "//input[@name = 'taskSelected[3]']")
    private WebElement CB3;

    @FindBy(xpath = "//input[@name = 'taskSelected[4]']")
    private WebElement CB4;

    @FindBy(xpath = "//a[@class = 'userProfileLink username']")
    private WebElement adminSystem;

    @FindBy(xpath = "//div[@id='userProfilePopup_cancelBtn']")
    private WebElement cancelButton;


    public ActitimeHomePageTestNG(WebDriver driver) {


        PageFactory.initElements(driver, this);
    }


    public void verifyActitimtHomePageHeader() {
        boolean result = header.isDisplayed();
        if (result == true) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public void clickOnTask() throws InterruptedException {
        task.click();
        Thread.sleep(3000);
        CB1.click();
        CB2.click();
        CB3.click();
        CB4.click();

    }

    public void clickOnAdministratorSystem() throws InterruptedException {

        adminSystem.click();
        Thread.sleep(3000);
        cancelButton.click();
    }


    public void setActitimtHomePageLogout() {
        logout.click();


    }

}



