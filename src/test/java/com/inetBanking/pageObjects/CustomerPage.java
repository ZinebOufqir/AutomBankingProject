package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage {
    WebDriver driver;

    public CustomerPage(WebDriver idriver){
        driver = idriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.XPATH,using = "/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement addNewCustumer;

    @FindBy(how= How.NAME,using = "name")
    @CacheLookup
    WebElement name;

    @FindBy(how= How.NAME,using = "rad1")
    @CacheLookup
    WebElement gender;

    @FindBy(how= How.ID_OR_NAME,using = "dob")
    @CacheLookup
    WebElement dateOfBirth;

    @FindBy(how= How.NAME,using = "addr")
    @CacheLookup
    WebElement address;

    @FindBy(how= How.NAME,using = "city")
    @CacheLookup
    WebElement city;

    @FindBy(how= How.NAME,using = "state")
    @CacheLookup
    WebElement state;

    @FindBy(how= How.NAME,using = "pinno")
    @CacheLookup
    WebElement pin;

    @FindBy(how= How.NAME,using = "telephoneno")
    @CacheLookup
    WebElement mobile;

    @FindBy(how= How.NAME,using = "emailid")
    @CacheLookup
    WebElement email;

    @FindBy(how= How.NAME,using = "password")
    @CacheLookup
    WebElement password;

    @FindBy(how= How.NAME,using = "sub")
    @CacheLookup
    WebElement btnSubmit;

    public void clickAddNewCustomer(){
        addNewCustumer.click();
    }
    public void custName(String dname){
        name.sendKeys(dname);
    }

    public void custGender(String dgender){
        gender.sendKeys(dgender);
    }

    public void custDOB (String mm, String dd, String yy ){
        dateOfBirth.sendKeys(mm);
        dateOfBirth.sendKeys(dd);
        dateOfBirth.sendKeys(yy);
    }

    public void custAddress(String daddress){
        address.sendKeys(daddress);
    }

    public void custCity(String dcity){
        city.sendKeys(dcity);
    }
    public void custState(String dstate){
        state.sendKeys(dstate);
    }

    public void custPIN(int dpin){
        pin.sendKeys(String.valueOf(dpin));
    }

    public void custMobile(String dmobile){
        mobile.sendKeys(dmobile);
    }

    public void custEmail(String demail){
        email.sendKeys(demail);
    }

    public void custPassword(String dpwd){
        password.sendKeys(dpwd);
    }

    public void clickSubmit(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
    }

}
