package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.CreateAttributes;
import page.LoginPage;

public class TC10VerifyNewCreateAttribute extends BaseTest {
    @Test(dataProvider = "testdata", priority = 11)
    public void tc10(String url, String username, String password, String name){
        LoginPage loginPage = new LoginPage(getDriver());
        CatalogPage catalogPage = new CatalogPage(getDriver());
        CreateAttributes createAttributes = new CreateAttributes(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        catalogPage.clickCatalog();
        catalogPage.clickAttributes();
        catalogPage.clickButtonCreate();
        createAttributes.inputName(name);
        createAttributes.clickGroup();
        createAttributes.clickMemory();
        createAttributes.save();
        createAttributes.checkName(name);
    }

    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "tc10", 1, 4);

    }
}
