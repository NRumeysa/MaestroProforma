package com.maestro.pages;

import com.maestro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DosyalarPage {

    public DosyalarPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Dosyalar')]")
    public WebElement dosyalarTitle;

    @FindBy(id = "txtFileName")
    public WebElement dosyaAdiBox;

    @FindBy(id = "fileinput1")
    public WebElement dosyaSecBox;

    @FindBy(xpath = "(//a[contains(text(), 'Kayde')])[2]")
    public WebElement dosyalarKaydetButton;

    @FindBy(xpath = "//select[@name='tblFiles_length']")
    public WebElement dosyalarKayitDropDown;

    @FindBy(id = "tblFiles_filter")
    public WebElement dosyalarSearchBox;

    @FindBy(xpath= "(//th[contains(text(), 'Sil')])[4]")
    public WebElement dosyalarSilTitle;

    @FindBy(xpath= "//th[contains(text(), 'İndir')]")
    public WebElement dosyalarIndirTitle;

    @FindBy(xpath= "(//th[contains(text(), 'Adı')])[9]")
    public WebElement dosyalarAdiTitle;

    @FindBy(id= "tblFiles_info")
    public WebElement dosyalarInfo;

    @FindBy(id= "tblFiles_next")
    public WebElement dosyalarNextButton;

    @FindBy(id= "tblFiles_previous")
    public WebElement dosyalarPreviousButton;




}
