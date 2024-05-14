package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver= rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(name = "uid")
    @CacheLookup
    WebElement txtUserNAME;

    @FindBy(name="password")
    @CacheLookup
    WebElement password;

    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
    @CacheLookup
    WebElement lnkLogout;

    public void setUserNAME(String uname) {
        txtUserNAME.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickSubmit(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnLogin"))).click();
    }

    public void clickLogout(){
        lnkLogout.click();
    }
}
