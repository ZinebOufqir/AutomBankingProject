package com.inetBanking.testCases;

import com.inetBanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseUrl = readConfig.getApplicationUrl();
    public String username = readConfig.getUserName();
    public String password= readConfig.getPassword();
    public static WebDriver driver;

   // public static Logger ;


    @Parameters("browser")
    @BeforeClass
    public void setup(String br){
       // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
       // DesiredCapabilities dc = new DesiredCapabilities();
        // dc.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        if(br.equals("chrome")) {
           System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
           driver = new ChromeDriver();
           //logger.info("ebanking");
       }
       else if(br.equals("firefox")){
           System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
           driver = new FirefoxDriver();
       }
       else if(br.equals("ie")){
           System.setProperty("webdriver.gecko.driver", readConfig.getIEPath());
           driver = new EdgeDriver();
       }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((10)));
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    public void captureScreen(WebDriver driver, String tname) throws IOException{
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") +"/Screenshots/" +tname +".png");
        FileUtils.copyFile(source,target);
        System.out.println("ScreenShot Taken");
    }
    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(8);
        return generatedString;
    }

    public static String randomNum(){
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return (generatedString2);
    }
    public boolean isAlertPresent() { //user defined method created to check alert is present or not
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
