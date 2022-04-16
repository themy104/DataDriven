package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.CreateAttributeGroups;
import page.LoginPage;

public class TC08VerifyCreateAttributeGroupPage extends BaseTest {
    @Test(dataProvider = "testdata", priority = 9)
    public void tc08(String url, String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        CatalogPage catalogPage = new CatalogPage(getDriver());
        CreateAttributeGroups createAttributeGroups = new CreateAttributeGroups(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        catalogPage.clickCatalog();
        catalogPage.clickAttributeGroups();
        catalogPage.clickButtonCreate();

        if(createAttributeGroups.isDisplay() == false){
            System.out.println("No element");
        }

    }

    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "login", 1, 3);

    }

}
