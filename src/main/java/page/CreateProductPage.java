package page;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateProductPage extends BasePage {

    @FindBy(id = "product-name")
    private WebElement nameInput;

    @FindBy(id = "product-alias")
    private WebElement aliasInput;

    @FindBy(id = "product-image")
    private WebElement imageInput;

    @FindBy(id = "product-sku")
    private WebElement skuInput;

    @FindBy(id = "product-price")
    private WebElement priceInput;

    @FindBy(id = "product-quantity")
    private WebElement quantityInput;

   @FindBy(xpath = "(//ul[@class = \"select2-choices\"])[1]")
    private WebElement categoriesInput;

   /* //click desktop
    @FindBy(id = "select2-result-label-12")
    WebElement categoriesInput;*/

    /*@FindBy(xpath = "(//ul[@class = \"select2-results\"])[10]")
    WebElement select;*/

    @FindBy(id = "select2-result-label-12")
    private WebElement desktops;

    @FindBy(id = "select2-drop-mask")
    private WebElement drop;

    @FindBy(id = "save")
    private WebElement saveButton;

    @FindBy(xpath = "//a[text()=\"General\"]")
    private WebElement generalButton;

    @FindBy(xpath = "//a[text()=\"Data\"]")
    private WebElement dataButton;

    @FindBy(xpath = "//a[text()=\"Specifications\"]")
    private WebElement specButton;

    @FindBy(xpath = "//a[text()=\"Related\"]")
    private WebElement relatedButton;

    @FindBy(xpath = "//div[text()=\"Name cannot be blank.\"]")
    private WebElement messErrorName;

    @FindBy(xpath = "//div[text()=\"Image cannot be blank.\"]")
    private WebElement messErrorImage;


    public void inputName(String name){
        nameInput.sendKeys(name);
    }
    public void inputAlias( String alias){
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }
    public void clickData(){
        dataButton.click();
    }
    public void inputData(String image){
       imageInput.sendKeys(image);
    }
    public void clickSpec(){
        specButton.click();
    }
    public void inputSpec(String sku, String price, String quantity){
        skuInput.sendKeys(sku);
        priceInput.sendKeys(price);
        quantityInput.sendKeys(quantity);
    }
    public void clickRelated(){
        relatedButton.click();
    }

    public void clickCateg(){
        categoriesInput.click();
    }
    public void selectCategories(){
       desktops.click();
    }

    public void exit() {
        drop.click();
    }
    public void clickSave(){
        saveButton.click();
    }
    public void clickGeneral(){
        generalButton.click();
    }

    public void checkMessErrorName(String messError){
        Assert.assertTrue(messErrorName.getText().equals(messError));
    }

    public void checkMessErrorImage(String messError){
        Assert.assertTrue(messErrorImage.getText().equals(messError));
    }



    public CreateProductPage(WebDriver driver) {
        super(driver);
    }
}
