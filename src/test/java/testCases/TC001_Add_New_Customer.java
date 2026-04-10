package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_Add_New_Customer extends BaseClass {



   @Test(groups = {"Regression","Master"})

    public void addNewCustomer() {
       // this user name and passwrd will expire with in 20 days use
       // use new email to get new username and passwrd other wise it will not work..

       logger.info("*******  Starting TC001_Add_New_Customer *****");
       try {


           LoginPage loginPage = new LoginPage(driver);
           loginPage.setTxtUserName(properties.getProperty("username"));
           loginPage.setTxtPasswrd(properties.getProperty("password"));
           loginPage.setBtnLogin();
           logger.info("***-- Click on my Login Button ***");
           //loginPage.confirmsg();
           AddCustomerPage addCustomerPage = new AddCustomerPage(driver);

           logger.info("***-- Click on AddNew Customer Button ***  ");

           addCustomerPage.setBtnNewcustomer();

           logger.info("*** provided all the customer deatails    *******");

           addCustomerPage.setTxtCustomerName(randomString().toUpperCase());
           addCustomerPage.setBtnGender();
           addCustomerPage.setTxtDateofBirth("10", "01", "1990");
           addCustomerPage.setTxtAdress("80 East 50 Street");
           addCustomerPage.setTxtCity("Queens");
           addCustomerPage.setTxtState("New York");
           addCustomerPage.setTxtPinnum("123456");
           addCustomerPage.setTxtTelenum(randomNumber());
           addCustomerPage.setTxtEmail(randomString() + "@gmail.com");
           addCustomerPage.setTxtPasswrd(randomAlphaNumeric());
           addCustomerPage.setBtnSubmit();

           logger.info("Validating expected message ");
           String confirmation = addCustomerPage.getmsgConfiramtion();
           if(confirmation.equals("Customer Registered Successfully!!!"))
           {
               Assert.assertTrue(true);
           }
           else {
               logger.error("test failed");
               logger.debug("Debug logs..");
               Assert.assertTrue(false);
           }
           //Assert.assertEquals(confirmation, "Customersd Registered Successfully!!!");

   }
catch (Exception e)
{
  Assert.fail();
}
       logger.info("**** Finished TC001_Add_New_Customer ****");
   }


    }

