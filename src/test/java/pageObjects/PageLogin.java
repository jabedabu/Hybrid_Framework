package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLogin extends BasePage{

    public PageLogin(WebDriver driver){
        super(driver);
    }

    @FindBy(id="input-email")
    WebElement txtEmail;
    @FindBy(id="input-password")
    WebElement txtPasswrd;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement btnLogin;

    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTxtPasswrd(String pwd){
        txtPasswrd.sendKeys(pwd);
    }
    public void setBtnLogin(){
        btnLogin.click();
    }
}
