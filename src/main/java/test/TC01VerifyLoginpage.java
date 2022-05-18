package test;


import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;



public class TC01VerifyLoginpage extends BaseTest{
    @Test(dataProvider = "testdata", priority = 0)
    public void tc01(String url) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        if(loginPage.isDisplayLoginPage() == false){
            System.out.println("No element");
        }
        System.out.println("Demo");
    }
    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "login",  1, 1);

    }
}