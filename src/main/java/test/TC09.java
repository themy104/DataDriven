package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.CreateAttributeGroups;
import page.LoginPage;

public class TC09 extends BaseTest {
    @Test(dataProvider = "testdata")
    public void test(String url, String username, String password, String name){
        LoginPage loginPage = new LoginPage(getDriver());
        CatalogPage catalogPage = new CatalogPage(getDriver());
        CreateAttributeGroups createAttributeGroups = new CreateAttributeGroups(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        catalogPage.clickCatalog();
        catalogPage.clickAttributeGroups();
        catalogPage.clickButtonCreate();
        createAttributeGroups.inputName(name);
        createAttributeGroups.save();
        createAttributeGroups.checkName(name);
    }

    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "tc09", 1, 4);

    }
}
