package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

public class BaseTest {
    private WebDriver driver;
    private WebDriverManager webDriverManager;
    @BeforeMethod
    @Parameters({"browserName"})
    public void before(String browserName){
        //System.setProperty("webdriver.chrome.driver", "E:\\fpt\\selenium\\chromedriver.exe");
        if (browserName.equalsIgnoreCase("chrome")) {
            webDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
        }
        //incognito firefox
        if (browserName.equalsIgnoreCase("firefox")) {
            webDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("-private-window");
            driver = new FirefoxDriver(firefoxOptions);
        }
    }
    @AfterMethod
    public void after(){
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
