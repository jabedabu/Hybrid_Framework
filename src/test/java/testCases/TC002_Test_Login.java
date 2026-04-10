package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.PageLogin;
import testBase.BaseClass;

public class TC002_Test_Login extends BaseClass {

    @Test(groups = {"Sanity","Master"})

    public void verify_login(){
        logger.info(" *****   TC002_Test_Login staring ********");
       try {


           HomePage hp = new HomePage(driver);
           hp.clickMyAccount();
           hp.setBtnLogin();

           PageLogin pageLogin = new PageLogin(driver);
           pageLogin.setTxtEmail(properties.getProperty("myemail"));
           pageLogin.setTxtPasswrd(properties.getProperty("mypassword"));
           pageLogin.setBtnLogin();

           MyAccountPage myAccountPage = new MyAccountPage(driver);
           boolean targetpage = myAccountPage.isMyAccountPageExists();
           //Assert.assertEquals(targetpage,true,"Login failed");
           Assert.assertTrue(targetpage);
       }
       catch (Exception e){
           Assert.fail();
       }

        logger.info(" ***   Test login is finished **** ");

    }



}
