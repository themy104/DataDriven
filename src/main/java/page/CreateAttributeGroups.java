package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CreateAttributeGroups extends BasePage {

    @FindBy(id = "productattributegroup-name")
    private WebElement attributeGroupName;

    @FindBy(id = "productattributegroup-sort_order")
    private WebElement sortOrder;

    @FindBy(id = "save")
    private WebElement save;

    @FindBys(@FindBy(xpath= "//tr" ))
    private List<WebElement> table;



    public boolean isDisplay(){
        return attributeGroupName.isDisplayed()
                && sortOrder.isDisplayed();
    }

    public  void  checkName(String name) {
        int rows_count = table.size();
        for (int row = 0; row < rows_count; row++) {
            List<WebElement> Colums_row = table.get(row).
                    findElements(By.tagName("td"));
            for(WebElement column:Colums_row){
                if (column.getText().equals(name)){
                    System.out.println("Find element");
                    break;
                }
            }
        }
    }


    public void inputName(String name){
        attributeGroupName.sendKeys(name);
    }

    public void save(){
        save.click();
    }
    public CreateAttributeGroups(WebDriver driver) {
        super(driver);
    }
}
