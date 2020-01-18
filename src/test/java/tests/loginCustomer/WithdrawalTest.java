package tests.loginCustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.ProviderTest;

public class WithdrawalTest extends ProviderTest {
    String amountBeforeAdd = "";

    @When("I login successfully with the account as (.*)")
    public void loginSuccess(String username) throws InterruptedException {
        Thread.sleep(5000);
        getLoginPage().setBtnClickCustomerLogin();
        Thread.sleep(7000);
        getLoginPage().setUserSelect(username);
        Thread.sleep(6000);
        getLoginPage().setBtnSubmit();
    }

    @And("I deposited into my account (.*)")
    public void depositAmount(String deposit) throws InterruptedException {
        Thread.sleep(5000);
        getDepositPage().setBtnDeposit();
        Thread.sleep(5000);
        amountBeforeAdd = getDepositPage().getBalance();
        Thread.sleep(7000);
        getDepositPage().setInputAmount(deposit);
        Thread.sleep(5000);
        getDepositPage().setBtnSubmitDeposit();
        Thread.sleep(5000);
        getDepositPage().verifyAddDepositAmountSuccessfully(amountBeforeAdd, deposit);
    }

    @And("I click on Withdrawal button")
    public void btnWithdrawal() throws InterruptedException {
        Thread.sleep(5000);
        getWithdrawlPage().setBtnWithdrawal();
    }

    @And("I type amount to be Withdrawal as (.*)")
    public void inputWithdrawal(String withdrawl) throws InterruptedException {
        Thread.sleep(7000);
        getWithdrawlPage().setInputWithdrawal(withdrawl);
    }

    @And("I click on the Withdrawal button to submit withdrawal")
    public void btnSubmitWithdrawal() throws InterruptedException {
        Thread.sleep(5000);
        getWithdrawlPage().setBtnSubmitWithdrawal();
    }

    @Then("I verify user withdrawal successfully")
    public void withdrawalSuccess() throws InterruptedException {
        Thread.sleep(5000);
        getWithdrawlPage().verifyWithdrawalSuccessfully();
    }

    @Then("I verify user withdrawal unsuccessfully")
    public void withdrawalUnsuccessful() throws InterruptedException {
        Thread.sleep(5000);
        getWithdrawlPage().verifyWithdrawalUnsuccessfully();
    }

}
