package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CreateAttributes extends BasePage {
    public CreateAttributes(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "productattribute-name")
    private WebElement attributeName;

    @FindBy(id = "s2id_productattribute-attribute_group")
    private WebElement attributeGroup;

    @FindBy(xpath = "//div[text()= \"Memory\"]")
    private WebElement memory;

    @FindBy(id = "save")
    private WebElement save;

    @FindBys(@FindBy(xpath= "//tr" ))
    private List<WebElement> table;

    public void inputName(String name){
        attributeName.sendKeys(name);
    }
    public void clickGroup(){
        attributeGroup.click();
    }
    public void clickMemory(){
        memory.click();
    }
    public void save(){
        save.click();
    }

    public  void  checkName(String name) {
        int rows_count = table.size();
        for (int row = 0; row < rows_count; row++) {
            List<WebElement> Colums_row = table.get(row).
                    findElements(By.tagName("td"));
            for(WebElement column:Colums_row){
                if (column.getText().equals(name)&&column.getText().equals("Memory")){
                    System.out.println("Find element");
                    break;
                }
            }
        }
    }

}
