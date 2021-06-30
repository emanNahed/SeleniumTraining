package com.crm.qa.base;


import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//to initialize all of properties
//inheritace concept, all other will extend this class
public class TestBase {
    public static WebDriver driver;
    public static Properties properties;

    public TestBase(){
        //read prop

        try {
            properties = new Properties();
            FileInputStream ip = new FileInputStream(TestUtil.configPropPath);
            properties.load(ip);
        }
        catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void init(){
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, TestUtil.firefoxDriverPath);

        String browserName = properties.getProperty("browser");
        // you can check for each browser and init driver upon to that, just change browser name form config package to change the browser.
        if(browserName.equals("foreFox")){
            driver= new FirefoxDriver();
        }
        else if(browserName.equals("chrome")){
            driver= new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));

    }
}
