package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.CreateProductCategoryPage;
import page.LoginPage;

public class TC04 extends BaseTest {
    @Test(dataProvider = "testdata", priority = 0)
    public void test(String url, String username, String password, String name,
                     String alias, String image, String messError) {
        LoginPage loginPage = new LoginPage(getDriver());
        CatalogPage catalogPage = new CatalogPage(getDriver());
        CreateProductCategoryPage createProductCategoryPage = new CreateProductCategoryPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        catalogPage.clickCatalog();
        catalogPage.clickProductCategories();
        catalogPage.clickButtonCreate();

        createProductCategoryPage.input2(name, alias, image);
        createProductCategoryPage.clickSave();
        createProductCategoryPage.checkMessErrorCode(messError);

    }

    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "tc04", 1, 7);
    }
}
