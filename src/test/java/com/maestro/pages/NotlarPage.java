package com.maestro.pages;

import com.maestro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotlarPage {

    public NotlarPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[contains(text(), \"Notlar\")]")
    public WebElement notlarTitle;

    @FindBy(id = "ddInterviewDepartment")
    public WebElement notlarBolumDropdown;

    @FindBy(id = "txtInterviewDescription")
    public WebElement notlarAciklamaBox;

    @FindBy(xpath = "//a[@onclick='AddInterview()']")
    public WebElement notlarEkleButton;

    @FindBy(xpath = "//select[@name='tblInterviews_length']")
    public WebElement notlarKayitDropdown;

    @FindBy(xpath = "(//th[contains(text(), 'Personel')])[3]")
    public WebElement notlarPersonelTitle;

    @FindBy(xpath = "//th[contains(text(), 'Bölüm')]")
    public WebElement notlarBolumTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Not')])[1]")
    public WebElement notlarNotTitle;

    @FindBy(id = "tblInterviews_info")
    public WebElement notlarInfo;

    @FindBy(id = "tblInterviews_filter")
    public WebElement notlarSearchBox;

    @FindBy(id = "tblInterviews_next")
    public WebElement notlarNextButton;

    @FindBy(id = "tblInterviews_previous")
    public WebElement notlarPreviousButton;


}
