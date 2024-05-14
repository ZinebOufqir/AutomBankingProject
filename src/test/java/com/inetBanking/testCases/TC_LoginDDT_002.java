package com.inetBanking.testCases;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import java.io.FilePermission;
import java.security.PermissionCollection;

public class TC_LoginDDT_002 extends BaseClass {


    @Test(dataProvider = "LoginData")
     public void loginDDT(String user, String pwd)  {
        LoginPage lp = new LoginPage(driver);
        lp.setUserNAME(user);
        System.out.println("User Name provided!");
        lp.setPassword(pwd);
        System.out.println("Password provided!");
        lp.clickSubmit(driver);

       // Thread.sleep(3000);

        if(isAlertPresent() == true){
            driver.switchTo().alert().accept(); //close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            System.out.println("Login Failed!");
        }
        else {
            Assert.assertTrue(true);
            System.out.println("Login passed!");
            lp.clickLogout();
           // Thread.sleep(3000);
            driver.switchTo().alert().accept(); //close logout alert
            driver.switchTo().defaultContent();
        }
     }

     @DataProvider(name = "LoginData")
     String[][] getData() throws IOException, InvalidFormatException {
       String path= "C:/Users/zoufkir/Documents/Oufkir/inetBankingProject/src/test/java/com/inetBanking/testData/LoginData.xls";
       FilePermission file = new FilePermission(path,"read");
       PermissionCollection permission = file.newPermissionCollection();
       permission.add(file);
       int rowNum = XLUtils.getRowCount(path,"Feuil1");
       int colCount = XLUtils.getCellCount(path,"Feuil1",1);

       String loginData[][] = new String[rowNum][colCount+1];

       for(int i=1;i<=rowNum;i++){
           for (int j=0;j<colCount+1;j++) {
               loginData[i - 1][j] = XLUtils.getCellData(path, "Feuil1", i, j);
           }
       }
       return loginData;
     }
}
