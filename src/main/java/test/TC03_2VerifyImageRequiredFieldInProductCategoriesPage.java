package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.CreateProductCategoryPage;
import page.LoginPage;

public class TC03_2VerifyImageRequiredFieldInProductCategoriesPage extends BaseTest {
    @Test(dataProvider = "testdata", priority = 4)
    public void tc03_02(String url, String username, String password, String name,
                     String alias, String code, String messError) {
        LoginPage loginPage = new LoginPage(getDriver());
        CatalogPage catalogPage = new CatalogPage(getDriver());
        CreateProductCategoryPage createProductCategoryPage = new CreateProductCategoryPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        catalogPage.clickCatalog();
        catalogPage.clickProductCategories();
        catalogPage.clickButtonCreate();

        createProductCategoryPage.input1(name, alias, code);
        createProductCategoryPage.clickSave();
        createProductCategoryPage.checkMessErrorImage(messError);

    }

    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "tc03_2", 1, 7);
    }

}
