package pages.managerCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static tests.ProviderTest.getCommonPage;

public class OpenAccountPage {
    public static WebDriver driver;
    @FindBy(id = "userSelect")
    WebElement userSelect;
    @FindBy(xpath = "//div[2]/div/div[1]/button[2]")
    WebElement openAccountTab;

    @FindBy(id = "currency")
    WebElement currency;

    @FindBy(xpath = "//div[2]/div/div/form/button")
    WebElement processBtn;


    public void clickOpenUserSelect() {
        userSelect.click();

    }

    public void clickOpenAccountTab() {
        openAccountTab.click();
    }

    public void checkUserInformation(String fullNameInput, Boolean success) {

        List<WebElement> userList = userSelect.findElements(By.tagName("option"));
        Boolean check = false;

        for (WebElement user : userList) {
            if (user.getText().equals(fullNameInput)) {
                check = true;
            }
        }
        if (success) {
            if (!check) Assert.assertEquals(1, 0);
        } else {
            if (check) Assert.assertEquals(1, 0);
        }
    }

    public void getUserInformation(String usernameInput) {
        Select userSelects = new Select(userSelect);
        userSelects.selectByVisibleText(usernameInput);
    }

    public void getCurrency(String currencyInput) {
        currency.click();
        Select userSelects = new Select(currency);
        userSelects.selectByVisibleText(currencyInput);
    }

    public void clickProcessButton() {
        processBtn.click();
    }

    public String getTextAccountNumberPopup() throws InterruptedException {
        String getTextArray[] = getCommonPage().getAlertPopup().split(":");
        for (int i = 0; i < getTextArray.length; i++) {
            if (getCommonPage().isNumeric(getTextArray[i]) == true) {
                return getTextArray[i];
            }
        }
        return null;
    }
}


