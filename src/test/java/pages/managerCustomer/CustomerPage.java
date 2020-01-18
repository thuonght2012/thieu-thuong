package pages.managerCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import runner.TestRunner;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class CustomerPage {
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchBox;
    @FindBy(tagName = "table")
    WebElement customerTable;
    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement clickTab;


    public void setDeleteBtn(String firstName, String lastName, String postcode, String accountNumber) {

        List<WebElement> rows = customerTable.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (cols.get(0).getText().equals(firstName) && cols.get(1).getText().equals(lastName)
                    && cols.get(2).getText().equals(postcode) && cols.get(3).getText().contains(accountNumber)) {
                TestRunner.driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[5]/button")).click();
            }
        }
    }

    public void checkDeleteCustomerSuccessfully(String firstName, String lastName, String postcode, String accountNumber, boolean verify) {
        WebElement listTable = customerTable;
        List<WebElement> rows = listTable.findElements(By.tagName("tr"));
        boolean check = true;
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> tdElement = rows.get(i).findElements(By.tagName("td"));
            if (tdElement.get(0).getText().equals(firstName)
                    && tdElement.get(1).getText().equals(lastName)
                    && tdElement.get(2).getText().equals(postcode)
                    && tdElement.get(3).getText().equals(accountNumber)) {
                check = false;
            }
        }
        if (verify) {
            if (!check) Assert.assertEquals(1, 0);
        }
    }

    public void checkDeleteCustomerUnsuccessfully(String firstName, String lastName, String postcode, String accountNumber, boolean verify) {
        WebElement listTable = customerTable;
        List<WebElement> rows = listTable.findElements(By.tagName("tr"));
        boolean check = true;
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> tdElement = rows.get(i).findElements(By.tagName("td"));
            if (tdElement.get(0).getText().equals(firstName)
                    && tdElement.get(1).getText().equals(lastName)
                    && tdElement.get(2).getText().equals(postcode)
                    && tdElement.get(3).getText().equals(accountNumber)) {
                check = false;
            }
        }
        if (verify) {
            if (!check) Assert.assertEquals(1, 0);
        }
    }



    public void verifyAccountNumberUser(String firstName, String lastname, String accountnumber) throws InterruptedException {
        WebElement listTable = customerTable;
        List<WebElement> rows = listTable.findElements(By.tagName("tr"));
        boolean check = false;
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> tdElement = rows.get(i).findElements(By.tagName("td"));
            if (tdElement.get(0).getText().contains(firstName)
                    && tdElement.get(1).getText().contains(lastname)
                    && tdElement.get(3).getText().contains(accountnumber)) {
                check = true;
            }
        }
        Assert.assertEquals(check, true);
    }

    public void setClickTab() {
        clickTab.click();
    }

    public void setKeySearch(String keySearch) {
        if (searchBox.isDisplayed()) {
            searchBox.clear();
        }
        if (!searchBox.equals(null)) {
            searchBox.sendKeys(keySearch);
        }
    }

    public List<WebElement> getListCustomer() {
        return customerTable.findElements(By.tagName("tr"));
    }

    public void verifySearchSuccess(String key, List<WebElement> listCustomer) {
        List<WebElement> newList = new ArrayList<WebElement>();

        for (int i = 0; i < listCustomer.size(); i++) {
            try {
                List<WebElement> columns = listCustomer.get(i).findElements(By.tagName("td"));
                if ((columns.get(0).getText().contains(key)) || (columns.get(1).getText().contains(key))
                        || (columns.get(2).getText().contains(key))) {
                    newList.add(listCustomer.get(i));
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        List<WebElement> listCus = customerTable.findElements(By.xpath("tbody/tr"));

        if (newList.containsAll(listCus) == true) {
            assertEquals(1, 1);
        } else {
            assertEquals(0, 1);
        }
    }

}
