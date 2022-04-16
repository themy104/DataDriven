package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TheAdminCpnelPage extends BasePage {

    @FindBy(xpath = "//div[@class = \"sidebar-content\"]")
    private WebElement leftMenu;

    @FindBy(id = "latestusersgridview-pjax")
    private WebElement usersTable;

    @FindBy(id = "latestproductgridview-pjax")
    private WebElement productsTable;

    @FindBy(id = "latestcustomergridview-pjax")
    private WebElement customersTable;

    @FindBy(id = "latestordergridview-pjax")
    private WebElement latestOrdersTable;

    public TheAdminCpnelPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayTheAdminCpnelPage(){
        return leftMenu.isDisplayed()
                && usersTable.isDisplayed()
                && productsTable.isDisplayed()
                && customersTable.isDisplayed()
                && latestOrdersTable.isDisplayed();
    }
}
