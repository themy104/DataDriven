package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.CreateProductCategoryPage;
import page.LoginPage;

public class TC03_01VerifyNameRequiredFieldInProductCategoriesPage extends BaseTest {
    @Test(dataProvider = "testdata", priority = 3)
    public void tc03_01(String url, String username, String password, String name,
                     String alias, String image, String code, String messError) {
        LoginPage loginPage = new LoginPage(getDriver());
        CatalogPage catalogPage = new CatalogPage(getDriver());
        CreateProductCategoryPage createProductCategoryPage = new CreateProductCategoryPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        catalogPage.clickCatalog();
        catalogPage.clickProductCategories();
        catalogPage.clickButtonCreate();

        createProductCategoryPage.input(name, alias, image, code);
        createProductCategoryPage.clickSave();
        createProductCategoryPage.checkMessErrorName(messError);

    }

    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "tc03_1", 1, 8);
    }



}
