package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.CreateProductPage;
import page.LoginPage;

public class TC07VerifyImageRequiredFieldInProductsPage extends BaseTest {
    @Test(dataProvider = "testdata", priority = 8)
    public void tc07(String url, String username, String password,String name, String alias,
                      String sku, String price, String quantity, String messError){
        LoginPage loginPage = new LoginPage(getDriver());
        CatalogPage catalogPage = new CatalogPage(getDriver());
        CreateProductPage createProductPage = new CreateProductPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        catalogPage.clickCatalog();
        catalogPage.clickProducts();
        catalogPage.clickButtonCreate();
        createProductPage.inputName(name);
        createProductPage.inputAlias(alias);
        createProductPage.clickData();
        createProductPage.clickSpec();
        createProductPage.inputSpec(sku, price, quantity);
        createProductPage.clickRelated();
        createProductPage.clickCateg();
        createProductPage.selectCategories();
        createProductPage.exit();
        createProductPage.clickSave();
        createProductPage.clickData();
        createProductPage.checkMessErrorImage(messError);


    }

    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "tc07",  1, 9);

    }
}
