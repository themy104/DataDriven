package page;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateProductCategoryPage extends BasePage {

    @FindBy(id = "productcategory-name")
    private WebElement nameInput;

    @FindBy(id = "productcategory-alias")
    private WebElement aliasInput;

    @FindBy(id = "productcategory-image")
    private WebElement imageInput;

    @FindBy(xpath = "//div[@class = \"note-editable panel-body\"]")
    private WebElement descriptionInput;

    @FindBy(id = "productcategory-metakeywords")
    private WebElement metaKeywordsInput;

    @FindBy(id = "productcategory-metadescription")
    private WebElement metaDescriptionInput;

    @FindBy(id = "productcategory-code")
    private WebElement codeInput;

    @FindBy(id = "save")
    private WebElement saveButton;

    @FindBy(xpath = "//div[text()=\"Name cannot be blank.\"]")
    private WebElement messErrorName;

    @FindBy(xpath = "//div[text()=\"Image cannot be blank.\"]")
    private WebElement messErrorImage;

    @FindBy(xpath = "//div[text()=\"Code cannot be blank.\"]")
    private WebElement messErrorCode;

    public CreateProductCategoryPage(WebDriver driver) {
        super(driver);
    }

    /*public void input(String name, String alias, String image,String description, String metaKeyWords,
                          String metaDescription *//*String code*//* ){
        nameInput.sendKeys(name);
        aliasInput.sendKeys(alias);
        imageInput.click();
        imageInput.sendKeys(image);
        imageInput.sendKeys(Keys.ENTER);
        descriptionInput.sendKeys(description);
        metaKeywordsInput.sendKeys(metaKeyWords);
        metaDescriptionInput.sendKeys(metaDescription);
        *//*Integer.parseInt(code);
        codeInput.sendKeys(code);*//*

    }*/

    public void input(String name, String alias,String image, String code){
        nameInput.sendKeys(name);
        aliasInput.sendKeys(alias);
        imageInput.sendKeys(image);
        codeInput.sendKeys(code);
    }

    public void input2(String name, String alias,String image){
        nameInput.sendKeys(name);
        aliasInput.sendKeys(alias);
        imageInput.sendKeys(image);
    }

    public void input1(String name, String alias,String code){
        nameInput.sendKeys(name);
        aliasInput.sendKeys(alias);
        //imageInput.sendKeys(image);
        codeInput.sendKeys(code);
    }



    public void checkMessErrorName(String messError){
        Assert.assertTrue(messErrorName.getText().equals(messError));
    }

    public void checkMessErrorImage(String messError){
        Assert.assertTrue(messErrorImage.getText().equals(messError));
    }

    public void checkMessErrorCode(String messError){
        Assert.assertTrue(messErrorCode.getText().equals(messError));
    }

    public void clickSave(){
        saveButton.click();
    }
}
