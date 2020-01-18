package tests.loginCustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.ProviderTest;

public class DepositTest extends ProviderTest {
    String amountBeforeAdd = "";
    @When("I login successfully with account as (.*)")
    public void loginSuccess(String username) throws InterruptedException {
        Thread.sleep(6000);
        getLoginPage().setBtnClickCustomerLogin();
        Thread.sleep(7000);
        getLoginPage().setUserSelect(username);
        Thread.sleep(6000);
        getLoginPage().setBtnSubmit();
    }

    @And("I click on Deposit button")
    public void btnDeposit() throws InterruptedException {
        Thread.sleep(5000);
        amountBeforeAdd= getDepositPage().getBalance();
        Thread.sleep(5000);
        getDepositPage().setBtnDeposit();
    }

    @And("I type amount to be Deposited as (.*)")
    public void inputDeposit(String deposit) throws InterruptedException {
        Thread.sleep(7000);
        getDepositPage().setInputAmount(deposit);
    }

    @And("I click on the Deposit button to submit deposit")
    public void btnSubmitDeposit() throws InterruptedException {
        Thread.sleep(5000);
        getDepositPage().setBtnSubmitDeposit();
    }

    @Then("I verify user deposit successfully with amount as (.*)")
    public void depositSuccess(String amount) throws InterruptedException {
        Thread.sleep(5000);
        getDepositPage().verifyAddDepositAmountSuccessfully(amountBeforeAdd, amount);
    }

}
