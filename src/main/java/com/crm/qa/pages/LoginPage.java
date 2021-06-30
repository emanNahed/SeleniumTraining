package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {

    //define object repository or Page factory
    //no need to write driver.get...
    @FindBy(name= "username")
    WebElement username;

    @FindBy(name= "password")
    WebElement password;

    @FindBy(id = "loginForm")
    WebElement loginBtn;


    @FindBy(xpath = "//buttong[text(), 'Sign Up']")
    WebElement signupBtn;


    @FindBy(className = "img-responsive")
    WebElement cmrLogo;


    //how to init elements:
    //by create constructor
    public LoginPage(){
        PageFactory.initElements(driver, this /* current class elements*/);
    }

    //actions
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCrmLogo(){
        return cmrLogo.isDisplayed(); // is it available
    }


    //after login I will go to home page, so I'll return it
    public HomePage login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        By loadingImage = By.id("preloader");

        WebDriverWait wait = new WebDriverWait(driver, 50);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));

        this.loginBtn.click();


        return new HomePage();
    }


}
