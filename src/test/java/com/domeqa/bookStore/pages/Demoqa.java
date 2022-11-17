package com.domeqa.bookStore.pages;


import com.domeqa.bookStore.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


}
