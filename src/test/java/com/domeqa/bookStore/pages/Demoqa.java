package com.domeqa.bookStore.pages;


import com.domeqa.bookStore.utilities.Driver;
import org.bouncycastle.util.Store;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Demoqa {

    public Demoqa() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[id=\"userName\"]")
    public WebElement userInput;

    @FindBy(id = "password")
    public WebElement userPassword;

    @FindBy (css = "button[id=\"login\"]")
    public WebElement loginButton;

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[6]")
    public WebElement bookStoreApplication;

    @FindBy(id = "see-book-Git Pocket Guide")
    public WebElement book;

    @FindBy(id = "addNewRecordButton")
    public List<WebElement> addToYourCollection;// Alert var

    @FindBy(xpath = "//span[.='Profile']")
    public WebElement profileButton;

    @FindBy(xpath = "//span[@id='see-book-Git Pocket Guide']/a")
    public WebElement storedBook;

    @FindBy(xpath = "//*[local-name()='svg']/*[@d='M16 132h416c8.837 0 16-7.163 16-16V76c0-8.837-7.163-16-16-16H16C7.163 60 0 67.163 0 76v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16z']")
    public WebElement deleteButton;

    @FindBy(id = "closeSmallModal-ok")
    public WebElement htmlAlertOKButton;

    @FindBy(xpath = "//div[.='No rows found']")
    public WebElement noRowsText;


}