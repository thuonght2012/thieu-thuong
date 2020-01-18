package pages;

import runner.TestRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonPage {

    public void closeAlertPopup() throws InterruptedException {
        TestRunner.driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }
    public String getAlertPopup() throws InterruptedException {
        Thread.sleep(3000);
        return TestRunner.driver.switchTo().alert().getText();
    }

    public  boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
        public String getDateTime() {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            return formattedDate;
        }
}
