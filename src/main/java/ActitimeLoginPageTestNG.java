import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeLoginPageTestNG {

    @FindBy(xpath = "//input[@id='username']")

    private WebElement un;
    @FindBy(xpath = "//input[@class='textField pwdfield']")
    private WebElement pwd;

    @FindBy(xpath = "//a[@id='loginButton']")
    private WebElement LoginButton;

    public ActitimeLoginPageTestNG(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }


    public void setActitimeLoginPageUsername()
    {
        un.sendKeys("Admin");
    }

    public void setActitimeLoginPagePassword()
    {

        pwd.sendKeys("manager");
    }

    public void setActitimeLoginPageLoginButton()
    {
        LoginButton.click();

    }
}


