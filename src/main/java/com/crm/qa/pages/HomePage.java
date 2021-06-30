package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {

    @FindBy(className = "headertext")
    WebElement userNameLabel;

    @FindBy(name = "Contacts")
    WebElement contactsLink;

    @FindBy(name= "Deals")
    WebElement dealsLink;

    @FindBy(name= "Tasks")
    WebElement tasksLink;


    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean getUserName(){
        return userNameLabel.isDisplayed();
    }

    public String getTitle(){
        String title = driver.getTitle();

        return title;
    }


    public ContactsPage clickOnContactsLink(){
        contactsLink.click();

        return new ContactsPage();
    }


    public DealsPage clickOnDealLink(){
        dealsLink.click();

        return new DealsPage();
    }
    public TasksPage clickOnTasksLink(){
        tasksLink.click();

        return new TasksPage();
    }
}
