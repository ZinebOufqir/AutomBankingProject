package com.inetBanking.testCases;

import com.inetBanking.pageObjects.CustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC_AddCustomerTest__003 extends BaseClass{

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        driver.get(baseUrl);
        LoginPage lp = new LoginPage(driver);
        lp.setUserNAME(username);
        lp.setPassword(password);
        lp.clickSubmit(driver);

        Thread.sleep(3000);

        CustomerPage cp = new CustomerPage(driver);

        cp.clickAddNewCustomer();

        cp.custName("Zineb");
        cp.custGender("Female");
        cp.custDOB("28", "01", "2000");
        Thread.sleep(3000);
        cp.custAddress("Sale, ****, ****");
        cp.custCity("Sale");
        cp.custState("Morocco");
        cp.custPIN(8900598);
        cp.custMobile("0987678");

        cp.custEmail(randomString()+"@gmail.com");
        cp.custPassword("abcdef");

        Thread.sleep(3000);


        cp.clickSubmit();

        Thread.sleep(3000);

        boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(res==true){
            Assert.assertTrue(true);
            System.out.println("Test case passed ....");
        }
        else {
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
            System.out.println("Test case failed ....");
        }
    }

}
