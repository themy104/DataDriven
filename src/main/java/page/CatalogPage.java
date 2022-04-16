package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {

    @FindBy(xpath = "//span[text()=\"Catalog\"]")
    private WebElement catalog;

    @FindBy(xpath = "//span[text()=\"Product Categories\"]")
    private WebElement productCategories;

    @FindBy(id = "action-toolbar-create")
    private WebElement createButton;

    @FindBy(id = "grid-settings-form")
    private WebElement settingsButton;

    @FindBy(id = "action-toolbar-bulkedit")
    private WebElement bulkEdit;

    @FindBy(id = "action-toolbar-bulkdelete")
    private WebElement bultDelete;

    @FindBy(id = "grid-view")
    private WebElement manageProductCategoriesTable;

    @FindBy(xpath = "//span[text()=\"Products\"]")
    private WebElement products;

    @FindBy(xpath = "//span[text()=\"Attribute Groups\"]" )
    private WebElement attributeGroups;

    @FindBy(xpath = "//span[text()=\"Attributes\"]" )
    private WebElement attributes;

    public void clickCatalog(){
        catalog.click();
    }
    public void clickButtonCreate(){
        createButton.click();
    }

    public void clickProducts(){
        products.click();
    }
    public void clickAttributeGroups(){
        attributeGroups.click();
    }
    public void clickAttributes(){
        attributes.click();
    }

    public void clickProductCategories(){
        productCategories.click();
    }
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplay(){
        return createButton.isDisplayed()
                && settingsButton.isDisplayed()
                && bulkEdit.isDisplayed()
                && bultDelete.isDisplayed()
                && manageProductCategoriesTable.isDisplayed();
    }
}
