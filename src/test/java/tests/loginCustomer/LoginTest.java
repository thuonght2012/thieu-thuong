package tests.loginCustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.ProviderTest;

public class LoginTest extends ProviderTest {
    @When("I click on Login Customer button to login")
    public void clickCustomerLogin() throws InterruptedException {
        Thread.sleep(5000);
        getLoginPage().setBtnClickCustomerLogin();
    }
    @And("I choose account of user as (.*)")
    public void chooseAccount(String username) throws InterruptedException {
        Thread.sleep(6000);
        getLoginPage().setUserSelect(username);
    }
    @And("I click button Login")
    public void clickSubmit() throws InterruptedException {
        Thread.sleep(5000);
        getLoginPage().setBtnSubmit();
    }
    @Then("Verify information of user logged correctly with account as (.*)")
    public void verifyInfoCorrect(String name) throws InterruptedException {
        Thread.sleep(5000);
        getLoginPage().setCheckInfoLogin(name);
    }
}
