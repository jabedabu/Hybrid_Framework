package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC01_LoginTest extends BaseClass {

    @Test(groups = {"Sanity","Master"})

    public void logintestVarification(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setTxtUserName(properties.getProperty("username"));
        loginPage.setTxtPasswrd(properties.getProperty("password"));
        loginPage.setBtnLogin();

      String confirm=  loginPage.confirmsg();
        Assert.assertEquals(confirm,"Welcome To Manager's Page of Guru99 Bank");

        /*
  if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
  {
       Assert.assertTrue(true);
    }
  else {
      Assert.assertTrue(false);
  }

         */
    }

}
