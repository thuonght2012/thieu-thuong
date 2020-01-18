package pages.loginCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static java.lang.Integer.parseInt;

public class TransactionsPage {
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement btnTransactions;
    @FindBy(tagName = "table")
    WebElement checkTable;
    @FindBy(xpath = "//div[2]/table")
    WebElement table;
    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    WebElement btnReset;
    @FindBy(xpath = "//button[contains(text(),'Back')]")
    WebElement btnBack;
    @FindBy(xpath = "//div[2]/strong[2]")
    WebElement balance;

    public void setBtnTransactions() {
        btnTransactions.click();
    }

    public void verifyTable(String deposit, String dateTime) {
        if (checkTable.isDisplayed()) {
            List<WebElement> allRows = table.findElements(By.tagName("tr"));
            for (int i = 1; i < allRows.size(); i++) {
                List<WebElement> cells = allRows.get(i).findElements(By.tagName("td"));
                if (cells.get(0).getText().contains(dateTime) && cells.get(1).getText().contains(deposit)) {
                    Assert.assertEquals(cells.get(1).getText(),deposit);
                    Assert.assertEquals(cells.get(0).getText(),dateTime);
                    break;
                }
            }
        } else System.out.println("Table form is not appeared");
    }

    public void setBtnReset() {
        btnReset.click();
    }

    public void verifyTableAfterReset() {
        if (checkTable.isDisplayed()) {
            List<WebElement> allRows = table.findElements(By.tagName("tr"));
            Assert.assertEquals(allRows.size()-1,0);
        }
    }

    public void setBtnBack() {
        btnBack.click();
    }

    public void verifyBack() {
        if (balance.getText().equals("0")) {
            System.out.println("Reset and back successfully");
        }
    }

    public void clickDeleteButton() {
        int sum = 0;
        int sumCredit = 0;
        int sumDebit = 0;
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (cols.get(2).getText().equals("Credit")) {
                sumCredit += parseInt(cols.get(1).getText());
            } else {
                sumDebit = sumDebit + parseInt(cols.get(1).getText());
            }
        }
        sum = sum + (sumCredit - sumDebit);
        Assert.assertEquals(sum,parseInt("4000"));
    }
}
