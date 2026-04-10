package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id='input-firstname']")
    WebElement txtFname;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLname;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//*[@id='input-telephone']")
    WebElement txtTelephoneNum;

    @FindBy(xpath = "//*[@id='input-password']")
    WebElement txtPasswrd;

    @FindBy(xpath = "//*[@id='input-confirm']")
    WebElement txtComPasswrd;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement clickAgree;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement btnContinue;
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement msgConfirmation;


    public void setFirstName(String fName){
        txtFname.sendKeys(fName);
    }

    public  void setLastName(String lName){
        txtLname.sendKeys(lName);
    }
    public  void setEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String telephoneNumber){
        txtTelephoneNum.sendKeys(telephoneNumber);
    }
    public void setTxtPasswrd(String pwd){
        txtPasswrd.sendKeys(pwd);
    }
    public void setTxtComPasswrd(String compwd){
        txtComPasswrd.sendKeys(compwd);
    }
    public void setClickAgree(){
        clickAgree.click();
    }
    public void setBtnContinue(){
        btnContinue.click();
    }

public  String getConfirmationmsg(){
       try {
           return (msgConfirmation.getText());
       }
       catch (Exception e){
          return( e.getMessage());
       }


}




}
