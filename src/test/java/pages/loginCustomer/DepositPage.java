package pages.loginCustomer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Integer.parseInt;
import static org.testng.Assert.assertEquals;

public class DepositPage {
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement btnDeposit;
    @FindBy(xpath = "//div[4]//form//input")
    WebElement inputAmount;
    @FindBy(xpath = "//div[4]//form/button")
    WebElement btnSubmit;
    @FindBy(xpath = "//div[2]/strong[2]")
    WebElement balance;
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement message;

    public void setBtnDeposit() {
        btnDeposit.click();
    }

    public void setInputAmount(String deposit) {
        inputAmount.clear();
        inputAmount.sendKeys(deposit);
    }

    public void setBtnSubmitDeposit() {
        btnSubmit.click();
    }

    public String getBalance() {
        return this.balance.getText();
    }

    public void verifyAddDepositAmountSuccessfully(String balanceBeforeAdd, String amount) throws InterruptedException {
        int balance = parseInt(balanceBeforeAdd) + parseInt(amount);
        Thread.sleep(3000);
        assertEquals(parseInt(getBalance()), balance);
        Thread.sleep(3000);
        assertEquals(message.getText(), "Deposit Successful");
        Thread.sleep(3000);
    }

}
