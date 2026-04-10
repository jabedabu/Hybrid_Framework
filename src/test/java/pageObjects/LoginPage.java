package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver){
        super(driver);

    }

    @FindBy(xpath = "//*[@name='uid']")
    WebElement txtUserName;
    @FindBy(xpath = "//*[@name='password']")
    WebElement txtPasswrd;
    @FindBy(xpath = "//*[@name='btnLogin']")
    WebElement btnLogin;
    @FindBy(xpath = "//marquee[@class='heading3']")
    WebElement confirmationmsg;
    public void setTxtUserName(String userName){
        txtUserName.sendKeys(userName);
    }
    public void setTxtPasswrd( String passwrd){
        txtPasswrd.sendKeys(passwrd);
    }
    public void setBtnLogin(){
        btnLogin.click();
    }

    public String confirmsg(){
        try {
          return (  confirmationmsg.getText());
        }
        catch (Exception e){
            return (e.getMessage());
        }
    }


}
