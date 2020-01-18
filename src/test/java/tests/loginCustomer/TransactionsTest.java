package tests.loginCustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.ProviderTest;

public class TransactionsTest extends ProviderTest {
    String amountBeforeAdd = "";
    String dateTime = "";
    @When("I can login successfully with the account as (.*)")
    public void loginCustomer(String username) throws InterruptedException {
        Thread.sleep(6000);
        getLoginPage().setBtnClickCustomerLogin();
        Thread.sleep(7000);
        getLoginPage().setUserSelect(username);
        Thread.sleep(6000);
        getLoginPage().setBtnSubmit();
    }
    @And("I deposited into account (.*)")
    public void deposit(String deposit) throws InterruptedException {
        Thread.sleep(6000);
        getDepositPage().setBtnDeposit();
        Thread.sleep(7000);
        amountBeforeAdd= getDepositPage().getBalance();
        Thread.sleep(5000);
        getDepositPage().setInputAmount(deposit);
        Thread.sleep(5000);
        getDepositPage().setBtnSubmitDeposit();
        Thread.sleep(5000);
        dateTime=getCommonPage().getDateTime();
        Thread.sleep(5000);
        getDepositPage().verifyAddDepositAmountSuccessfully(amountBeforeAdd, deposit);
    }
    @And("I deposited extra into account (.*)")
    public void extraDeposit(String deposit) throws InterruptedException {
        Thread.sleep(5000);
        amountBeforeAdd= getDepositPage().getBalance();
        getDepositPage().setInputAmount(deposit);
        Thread.sleep(5000);
        getDepositPage().setBtnSubmitDeposit();
        Thread.sleep(5000);
        getDepositPage().verifyAddDepositAmountSuccessfully(amountBeforeAdd, deposit);
    }
    @And("I withdrawal into account (.*)")
    public void setWithdrawal(String withdrawal) throws InterruptedException {
        Thread.sleep(5000);
        getWithdrawlPage().setBtnWithdrawal();
        Thread.sleep(7000);
        getWithdrawlPage().setInputWithdrawal(withdrawal);
        Thread.sleep(5000);
        getWithdrawlPage().setBtnSubmitWithdrawal();
    }

    @And("I click on Transactions button")
    public void clickBtnTransactions() throws InterruptedException {
        Thread.sleep(5000);
        getTransactionsPage().setBtnTransactions();
    }
    @Then("I verify table is appeared and show deposit success as (.*)")
    public void checkTable(String deposit) throws InterruptedException {
        Thread.sleep(5000);
        getTransactionsPage().verifyTable(deposit, dateTime);
        Thread.sleep(5000);
        getTransactionsPage().clickDeleteButton();
    }
    @When("I click button Reset to delete all transactions")
    public void clickBtnReset() throws InterruptedException {
        Thread.sleep(5000);
        getTransactionsPage().setBtnReset();
    }
    @Then("I verify reset table successfully")
    public void verifyTableAfterReset() throws InterruptedException {
        Thread.sleep(5000);
        getTransactionsPage().verifyTableAfterReset();
    }
    @And("I click button Back to back Account page")
    public void setClickBtnBack() throws InterruptedException {
        Thread.sleep(5000);
        getTransactionsPage().setBtnBack();
    }
    @And("I verify balance amount and reset successfully")
    public void balance() throws InterruptedException {
        Thread.sleep(5000);
        getTransactionsPage().verifyBack();
    }
}
