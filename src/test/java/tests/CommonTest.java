package tests;

import cucumber.api.java.en.Given;
import runner.TestRunner;

/**
 * Created by thuong.hoang
 */
public class CommonTest {


    @Given("Open website (.*)$")
    public void user_already_on_home_page(String website) throws InterruptedException {
        Thread.sleep(3000);
        TestRunner.driver.get(website);
        TestRunner.driver.manage().window().maximize();
    }

}
