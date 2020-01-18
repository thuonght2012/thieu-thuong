package tests;

import org.openqa.selenium.support.PageFactory;
import pages.*;
import pages.managerCustomer.AddCustomerPage;
import pages.loginCustomer.DepositPage;
import pages.loginCustomer.LoginPage;
import pages.loginCustomer.TransactionsPage;
import pages.loginCustomer.WithdrawalPage;
import pages.managerCustomer.CustomerPage;
import pages.managerCustomer.OpenAccountPage;
import runner.TestRunner;

public class ProviderTest {
    private static AddCustomerPage addCustomerPage;
    private static OpenAccountPage openAccountPage;
    private static CommonPage commonPage;
    private static CustomerPage customerPage;
    private static LoginPage loginPage;
    private static DepositPage depositPage;
    private static WithdrawalPage withdrawlPage;
    private static TransactionsPage transactionsPage;


    public static AddCustomerPage getAddCustomerPage() {
//        if (loginPage == null) {
        addCustomerPage = PageFactory.initElements(TestRunner.driver, AddCustomerPage.class);
//        }
        return addCustomerPage;
    }
    public static OpenAccountPage getOpenAccountPage() {
//        if (loginPage == null) {
        openAccountPage = PageFactory.initElements(TestRunner.driver, OpenAccountPage.class);
//        }
        return openAccountPage;
    }

    public static CustomerPage getCustomerPage() {
//        if (loginPage == null) {
        customerPage = PageFactory.initElements(TestRunner.driver, CustomerPage.class);
//        }
        return customerPage;
    }
    public static LoginPage getLoginPage() {
//        if (loginPage == null) {
        loginPage = PageFactory.initElements(TestRunner.driver, LoginPage.class);
//        }
        return loginPage;
    }
    public static DepositPage getDepositPage() {
//        if (depositPage == null) {
        depositPage = PageFactory.initElements(TestRunner.driver, DepositPage.class);
//        }
        return depositPage;
    }
    public static WithdrawalPage getWithdrawlPage() {
        if (withdrawlPage == null) {
            withdrawlPage = PageFactory.initElements(TestRunner.driver, WithdrawalPage.class);
        }
        return withdrawlPage;
    }
    public static TransactionsPage getTransactionsPage() {
//        if (transactionsPage == null) {
        transactionsPage = PageFactory.initElements(TestRunner.driver, TransactionsPage.class);
//        }
        return transactionsPage;
    }
    public static CommonPage getCommonPage() {
//        if (transactionsPage == null) {
        commonPage = PageFactory.initElements(TestRunner.driver, CommonPage.class);
//        }
        return commonPage;
    }

}
