package pages.loginCustomer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawalPage {
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement btnWithdrawal;
    @FindBy(xpath = "//div[4]//form//input")
    WebElement inputWithdrawal;
    @FindBy(xpath = "//div[4]//form/button")
    WebElement btnSubmitWithdrawal;
    @FindBy(xpath = "//div[2]/strong[2]")
    WebElement withdrawalSuccess;
    @FindBy(css = ".error")
    WebElement message;

    public void setBtnWithdrawal() {
        btnWithdrawal.click();
    }

    public void setInputWithdrawal(String deposit) {
        inputWithdrawal.clear();
        inputWithdrawal.sendKeys(deposit);
    }

    public void setBtnSubmitWithdrawal() {
        btnSubmitWithdrawal.click();
    }

    public void verifyWithdrawalSuccessfully() {
        if (message.isDisplayed() && Integer.parseInt(withdrawalSuccess.getText()) >= (Integer.parseInt("1000"))) {
            System.out.println("Withdrawal Successful: 1000");
        } else System.out.println("The customer still has not withdrawn yet");
    }

    public void verifyWithdrawalUnsuccessfully() {
        if (message.isDisplayed() && Integer.parseInt(withdrawalSuccess.getText()) < (Integer.parseInt("3000"))) {
            System.out.println("The customer withdrawal Unsuccessful");
        } else System.out.println("The customer still has not withdrawn yet");
    }


}
