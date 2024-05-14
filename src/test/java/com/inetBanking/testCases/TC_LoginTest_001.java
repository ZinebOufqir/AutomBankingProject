package com.inetBanking.testCases;

import com.inetBanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
public class TC_LoginTest_001 extends BaseClass {
    @Test
    public void loginTest() throws InterruptedException, IOException {
        driver.get(baseUrl);
        //logger.info("URL is opened");
        LoginPage lp = new LoginPage(driver);
        lp.setUserNAME(username);
       // logger.info("Entered USERNAME ");

        lp.setPassword(password);
        lp.clickSubmit(driver);


        if(driver.getTitle().equals("Guru99 Bank Manager HomePage 123")){

            Assert.assertTrue(true);
        }
        else{
            captureScreen(driver,"loginTest");
            System.out.println(driver.getTitle());
            Assert.assertTrue(false);
        }

    }
}
