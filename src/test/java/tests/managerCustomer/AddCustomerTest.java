package tests.managerCustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.ProviderTest;

public class AddCustomerTest extends ProviderTest {

    @When("^I type first name as (.*), last name as (.*), post code as (.*)$")
    public void inputUserInformation(String firstName, String lastName, String postcode) throws InterruptedException {
        Thread.sleep(6000);
        getAddCustomerPage().setInformation(firstName, lastName, postcode);
    }


    @And("^I click submit$")
    public void clickSubmit() throws InterruptedException {
        getAddCustomerPage().clickSubmit();
    }

    @Then("^I verify that system is already added customer as (.*) successfully$")
    public void verifyCustomerAddSuccessfully(String fullName) throws InterruptedException {
        Thread.sleep(5000);
        getCommonPage().closeAlertPopup();
        Thread.sleep(5000);
        getOpenAccountPage().clickOpenAccountTab();
        Thread.sleep(5000);
        getOpenAccountPage().clickOpenUserSelect();
        Thread.sleep(5000);
        getOpenAccountPage().checkUserInformation(fullName, true);
        Thread.sleep(5000);
        getOpenAccountPage().getUserInformation(fullName);
    }


    @Then("^I verify that system is already added customer as (.*) unsuccessfully")
    public void verifyCustomerAddUnSuccessfully(String fullName) throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().clickOpenAccountTab();
        Thread.sleep(5000);
        getOpenAccountPage().clickOpenUserSelect();
        Thread.sleep(5000);
        getOpenAccountPage().checkUserInformation(fullName, false);
        Thread.sleep(5000);
    }
}
