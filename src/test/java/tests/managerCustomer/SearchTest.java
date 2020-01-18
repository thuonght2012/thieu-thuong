package tests.managerCustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import tests.ProviderTest;

import java.util.ArrayList;
import java.util.List;

public class SearchTest extends ProviderTest {
    List<WebElement> listCustomer = new ArrayList<WebElement>();

    @When("I click customer tab")
    public void clickCustomerTab() throws InterruptedException {
        Thread.sleep(5000);
        getCustomerPage().setClickTab();
    }

    @And("I type value as (.*) on search box")
    public void getKeySearch(String key) throws InterruptedException {
        Thread.sleep(5000);
        listCustomer = getCustomerPage().getListCustomer();
        Thread.sleep(5000);
        getCustomerPage().setKeySearch(key);
    }

    @Then("I verify search success with keyword as (.*)")
    public void verify(String keySearch) throws InterruptedException {
        Thread.sleep(7000);
        getCustomerPage().verifySearchSuccess(keySearch, listCustomer);
    }



}
