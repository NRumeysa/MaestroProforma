package com.maestro.pages;

import com.maestro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "TxtMail")
    public WebElement email;

    @FindBy(id = "TxtPass")
    public WebElement password;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;


}
