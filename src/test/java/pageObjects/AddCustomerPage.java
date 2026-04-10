package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends BasePage {

    public AddCustomerPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[text()='New Customer']")
    WebElement btnNewcustomer;

    @FindBy(name="name")
    WebElement txtCustomerName;

    @FindBy(xpath = "//input[@name='rad1'][1]")
    WebElement btnGender;
    @FindBy(id="dob")
    WebElement txtDateofBirth;
     @FindBy(name="addr")
    WebElement txtAdress;
    @FindBy(name="city")
    WebElement txtCity;
    @FindBy(name="state")
    WebElement txtState;
    @FindBy(name="pinno")
    WebElement txtPinnum;
    @FindBy(name="telephoneno")
    WebElement txtTelenum;

    @FindBy(name="emailid")
    WebElement txtEmail;
    @FindBy(name="password")
    WebElement txtPasswrd;
    @FindBy(name="sub")
    WebElement btnSubmit;
    @FindBy(xpath = "//p[text()='Customer Registered Successfully!!!']")
    WebElement msgConfirmation;

    public void setBtnNewcustomer(){
        btnNewcustomer.click();
    }
    public void setTxtCustomerName(String customerName){
        txtCustomerName.sendKeys(customerName);
    }
    public void setBtnGender(){
        btnGender.click();
    }
    public void setTxtDateofBirth(String month,String date,String year){
        txtDateofBirth.sendKeys(month);
        txtDateofBirth.sendKeys(date);
        txtDateofBirth.sendKeys(year);
    }

public void setTxtAdress(String adress){
        txtAdress.sendKeys(adress);
}
public void setTxtCity(String city){
        txtCity.sendKeys(city);
}

    public void setTxtState(String state){
        txtState.sendKeys(state);
    }

    public void setTxtPinnum(String pinnum){
        txtPinnum.sendKeys(pinnum);
    }

    public void setTxtTelenum(String telenum){
        txtTelenum.sendKeys(telenum);
    }

    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setTxtPasswrd(String pwd){
        txtPasswrd.sendKeys(pwd);
    }
    public void setBtnSubmit(){
        btnSubmit.click();
    }
    public  String getmsgConfiramtion(){
        try {
           return( msgConfirmation.getText());
        }
        catch (Exception e){
            return (e.getMessage());
        }
    }


}
// name=pinno
//name=city
//name=state