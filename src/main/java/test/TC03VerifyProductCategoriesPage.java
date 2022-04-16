package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.LoginPage;
import page.TheAdminCpnelPage;

public class TC03VerifyProductCategoriesPage extends BaseTest {
    @Test(dataProvider = "testdata", priority = 2)
    public void tc03(String url, String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        CatalogPage catalogPage = new CatalogPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        catalogPage.clickCatalog();
        catalogPage.clickProductCategories();
        if(catalogPage.isDisplay() == false){
            System.out.println("No element");
        }

    }

    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "login", 1, 3);

    }


}
