package test;

import core.BasePage;
import core.BaseTest;
import core.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;
import page.TheAdminCpnelPage;

public class TC02VerifyLoginSuccessfully  extends BaseTest {
    @Test(dataProvider = "testdata", priority = 1)
    public void tc02(String url, String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        TheAdminCpnelPage theAdminCpnelPage = new TheAdminCpnelPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);
        if(theAdminCpnelPage.isDisplayTheAdminCpnelPage() == false){
            System.out.println("No element");
        }



    }

    @DataProvider(name = "testdata")
    public Object [][] getData() throws Exception {
        return ExcelUtils.getTableArray("TestData.xlsx", "login",  1, 3);

    }

}
