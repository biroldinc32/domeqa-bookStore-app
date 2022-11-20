package com.domeqa.bookStore.pages;


import com.domeqa.bookStore.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public ProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "label[id=\"userName-value\"]")
    public WebElement profileName;

    @FindBy(css = "button[id=\"gotoStore\"]")
    public WebElement gotoStore;

    @FindBy(xpath = "(//button[@id='submit'])[1]")
    public WebElement logOutButton;


}
