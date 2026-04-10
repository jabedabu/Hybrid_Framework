package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath="//span[text()='My Account']")
    WebElement btnAccount;
    @FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-right']/li[1]/a")
    WebElement btnRegister;
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a")
    WebElement btnLogin;

    public void clickMyAccount(){
        btnAccount.click();
    }
    public void clickRegisterbtn(){
        btnRegister.click();
    }
    public void setBtnLogin(){
        btnLogin.click();
    }
}
