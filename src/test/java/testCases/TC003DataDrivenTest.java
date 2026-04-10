package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.PageLogin;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003DataDrivenTest extends BaseClass {

    @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "Datadriven ")

    public void verify_loginDDT(String email,String pwd,String exp)
    {
        try {


            logger.info(" ***  TC003Datadrivren testing started ********");

            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.setBtnLogin();

            PageLogin pageLogin = new PageLogin(driver);
            pageLogin.setTxtEmail(email);
            pageLogin.setTxtPasswrd(pwd);
            pageLogin.setBtnLogin();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetpage = myAccountPage.isMyAccountPageExists();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetpage == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(true);

                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Ivalid")) {
                if (targetpage == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(false);

                } else {
                    Assert.assertTrue(true);
                }

            }
        }
        catch (Exception e){
            Assert.fail();
        }
        finally {
            logger.info("******---- Testing *** ____Finished------");
        }

        }

}
