package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.CreateProductPage;
import page.LoginPage;

public class TC06VerifyNameRequiredFieldInProductsPage extends BaseTest {
    @Test(dataProvider = "testdata", priority = 7)
    public void tc06(String url, String username, String password, String alias,
                     String image, String sku, String price, String quantity, String messError){
        LoginPage loginPage = new LoginPage(getDriver());
        CatalogPage catalogPage = new CatalogPage(getDriver());
        CreateProductPage createProductPage = new CreateProductPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        catalogPage.clickCatalog();
        catalogPage.clickProducts();
        catalogPage.clickButtonCreate();
        createProductPage.inputAlias(alias);
        createProductPage.clickData();
        createProductPage.inputData(image);
        createProductPage.clickSpec();
        createProductPage.inputSpec(sku, price, quantity);
        createProductPage.clickRelated();
        createProductPage.clickCateg();
        createProductPage.selectCategories();
        createProductPage.exit();
        createProductPage.clickSave();
        createProductPage.clickGeneral();
        createProductPage.checkMessErrorName(messError);


    }

    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "tc06",  1, 9);

    }
}
