package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"Regression","Master"})

    public void verifyAccountRegistration() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickRegisterbtn();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFirstName(randomString().toUpperCase());
        registerPage.setLastName(randomString().toUpperCase());
        registerPage.setEmail(randomString() +"@gmail.com");
        registerPage.setTelephone(randomNumber());
        String password=randomAlphaNumeric();
        registerPage.setTxtPasswrd(password);
        registerPage.setTxtComPasswrd(password);
        registerPage.setClickAgree();
        registerPage.setBtnContinue();
        String confmsg = registerPage.getConfirmationmsg();
        Assert.assertEquals(confmsg, "Your Account Has Been Created!");


    }
}
