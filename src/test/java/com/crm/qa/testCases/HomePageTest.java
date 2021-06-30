package com.crm.qa.testCases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{
    LoginPage loginPage;
    TestUtil testUtil;

    HomePage homePage;
    public HomePageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        init();
        loginPage= new LoginPage();

        String username= properties.getProperty("username");
        String password= properties.getProperty("password");

        homePage = loginPage.login(username, password);
    }


    @Test
    public void verifyHomePageTitle(){
        String title = homePage.getTitle();

        Assert.assertEquals(title, TestUtil.HOME_PAGE_TITLE);
    }

    @Test
    public void verifyUserName(){

        //switch to main frame before that

        TestUtil.switchToFrame();
        boolean userName= homePage.getUserName();

        Assert.assertTrue(userName);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}


