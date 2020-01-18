package pages.loginCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class LoginPage {
    @FindBy(id = "userSelect")
    WebElement userSelect;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement btnSubmit;
    @FindBy(xpath = "//span[contains(text(),'Harry Potter')]")
    WebElement checkInfoLogin;
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement checkButtonLogout;
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement btnClickCustomerLogin;

    public void setBtnClickCustomerLogin(){
        btnClickCustomerLogin.click();
    }

    public void setUserSelect(String username){
        userSelect.click();
        List<WebElement> listUser = userSelect.findElements(By.tagName("option"));
        for (WebElement user : listUser) {
            if (user.getText().equals(username)) {
                Select userSelects = new Select(userSelect);
                userSelects.selectByVisibleText(username);
                break;
            }
        }
    }
    public boolean checkLoginButtonIsShown() {
        if(btnSubmit.isDisplayed() ){
//            && checkInfoLogin.getText().equals(name)
            System.out.println("Login button is appeared");
            return true;
        }
        else{
            System.out.println("The name is not selected and login button is not appeared");
            return false;
        }
    }
    public void setBtnSubmit(){
        if(checkLoginButtonIsShown()){
            btnSubmit.click();
        }
        else{
            System.out.println("Element not present");
        }

    }

    public void setCheckInfoLogin(String name) {
        Assert.assertEquals(checkInfoLogin.getText(), name, "The info of user is failed!");
        System.out.println(checkInfoLogin.getText());
    }
    public void setCheckLoginSuccess() {
        WebElement checkButtonLogout1 = checkButtonLogout;
        Assert.assertTrue(checkButtonLogout1.isDisplayed());
    }

}
