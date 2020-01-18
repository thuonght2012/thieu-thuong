package tests.managerCustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import runner.TestRunner;
import tests.ProviderTest;

import java.util.List;

public class OpenAccountTest extends ProviderTest {
    String accountNumber = "null";

    @When("^I choose account as (.*) and currency as (.*)$")
    public void openAccount(String fullName, String currency) throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().clickOpenUserSelect();
        Thread.sleep(5000);
        getOpenAccountPage().getUserInformation(fullName);
        Thread.sleep(5000);
        getOpenAccountPage().getCurrency(currency);
    }

    @And("^I click process button")
    public void click_process_button() throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().clickProcessButton();
        Thread.sleep(5000);
        accountNumber = getOpenAccountPage().getTextAccountNumberPopup();
        Thread.sleep(5000);

    }

    @Then("^I verify that user is already opened with first name as (.*) and last name as (.*)$")
    public void verifyOpenAccountSuccessfully(String firstName, String lastName) throws InterruptedException {
        Thread.sleep(5000);
        getCommonPage().closeAlertPopup();
        Thread.sleep(5000);
        getCustomerPage().setClickTab();
        Thread.sleep(7000);
        getCustomerPage().verifyAccountNumberUser(firstName, lastName, accountNumber);
        Thread.sleep(5000);
    }
}