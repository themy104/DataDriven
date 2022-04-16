package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class LoginPage extends BasePage {
    @FindBy(id = "loginform-username")
    private WebElement usernameCombobox;

    @FindBy(id = "loginform-password")
    private WebElement passwordText;

    @FindBy(xpath = "//button[@class = \"btn btn-warning pull-right\"]")
    private WebElement signinButton;

    @FindBy(xpath = "//div[@class = \"checkbox checkbox-admin\"]")
    private WebElement rememberMe;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToLoginPage(String url) {
        getDriver().get(url);
    }

    public void login(String u , String p) {
        usernameCombobox.sendKeys(u);
        passwordText.sendKeys(p);
        signinButton.click();
    }


    public boolean isDisplayLoginPage(){
        return usernameCombobox.isDisplayed()
                && passwordText.isDisplayed()
                && signinButton.isDisplayed()
                && rememberMe.isDisplayed();
    }


}
