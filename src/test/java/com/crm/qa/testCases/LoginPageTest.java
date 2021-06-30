package com.crm.qa.testCases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    public LoginPageTest(){
        super(); // will execute super class constructor
    }
    @BeforeMethod
    public void setUp(){
        init(); // from parent class

        loginPage= new LoginPage();
    }

    @Test(priority = 3)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, TestUtil.login_page_title);
    }

    @Test(priority = 2)
    public void crmLogoTest(){
        boolean isValidateLogo= loginPage.validateCrmLogo();

        Assert.assertTrue(true);
    }

    @Test(priority = 1)
    public void loginTest(){
        String userName = properties.getProperty("username");
        String password = properties.getProperty("password");
        homePage= loginPage.login(userName, password);


    }


    @AfterMethod
    public void tearDown(){
        driver.quit(); // why? will I open driver for each class?
    }
}
