package pages.managerCustomer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage {
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerBtn;

    public void setInformation(String fistNameInput, String lastNameInput, String postcodeInput) {
        this.firstName.clear();
        if (!fistNameInput.equals("")) {
            this.firstName.sendKeys(fistNameInput);
        }
        this.lastName.clear();
        if (!lastNameInput.equals("")) {
            this.lastName.sendKeys(lastNameInput);
        }
        this.postcode.clear();
        if (!postcodeInput.equals("")) {
            this.postcode.sendKeys(postcodeInput);
        }
    }

    public void clickSubmit() {
        addCustomerBtn.click();
    }

}
