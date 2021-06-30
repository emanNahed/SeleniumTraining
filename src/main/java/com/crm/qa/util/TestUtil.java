package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

    public static final String HOME_PAGE_TITLE = "CRMPRO - CRM software for customer relationship management, sales, and support.";
    public static final String USER_NAME = "groupautomation";
    public static long PAGE_LOAD_TIMEOUT = 50;
    public static long IMPLICIT_TIMEOUT= 40;
    public static final String configPropPath= "C:\\Users\\pc\\Desktop\\SeleniumProjects\\src\\main\\java\\com\\crm\\qa\\config\\config.properties";
    public static final String login_page_title= "CRMPRO  - CRM software for customer relationship management, sales, and support.";
    public static final String firefoxDriverPath = "C:\\\\Users\\\\pc\\\\Downloads\\\\selenium-java-3.141.59\\\\geckodriver-v0.29.1-win64\\\\geckodriver.exe";


    public static void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }
}
