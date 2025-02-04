package com.maestro.pages;

import com.maestro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EkGelirlerPage {

    public EkGelirlerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "heading9")
    public WebElement ekGelirlerTitle;

    @FindBy(id = "txtIncomeDate")
    public WebElement ekGelirTarihBox;

    @FindBy(id = "select2-ddIncomeType-container")
    public WebElement ekGelirTipiDropDown;

    @FindBy(xpath = "//*[@onclick=\"IncomeTypePopup('ddIncomeType')\"]")
    public WebElement ekGelirTipiEkleButton;

    @FindBy(xpath = "//h5[contains(text(), 'Gelir Tipi')]")
    public WebElement ekGelirlerGelirTipiEkleTitle; //iframe

    @FindBy(xpath = "(//input[@name='Name'])[2]")
    public WebElement ekGelirlerGelirTipiEkleAdi; //iframe

    @FindBy(id = "cbStatusFlag")
    public WebElement ekGelirlerGelirTipiEkleAktifMi; //iframe

    @FindBy(xpath = "//button[contains(text(), 'Kaydet')]")
    public WebElement ekGelirlerGelirTipiEkleKaydetButton; //iframe

    @FindBy(id = "txtIncomeAmount")
    public WebElement ekGelirlerTutarBox;

    @FindBy(id = "ddIncomeCurrency")
    public WebElement ekGelirlerParaBirimiDropDown;

    @FindBy(id = "txtIncomeDescription")
    public WebElement ekGelirlerAciklamaBox;

    @FindBy(xpath = "//*[@onclick='AddIncome()']")
    public WebElement ekGelirlerEkleButton;

    @FindBy(xpath = "//select[@name='tblIncome_length']")
    public WebElement ekGelirlerKayitDropDown;

    @FindBy(xpath = "(//th[contains(text(), 'Sil')])[2]")
    public WebElement ekGelirlerSilTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Tarih')])[3]")
    public WebElement ekGelirlerTarihTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Personel')])[2]")
    public WebElement ekGelirlerPersonelTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Gelir Tipi')])[1]")
    public WebElement ekGelirlerGelirTipiTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Tutar')])[6]")
    public WebElement ekGelirlerTutarTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Açıklama')])[2]")
    public WebElement ekGelirlerAciklamaTitle;

    @FindBy(id = "tblIncome_filter")
    public WebElement ekGelirlerSearchBox;

    @FindBy(id = "tblIncome_info")
    public WebElement ekGelirlerInfo;

    @FindBy(id = "tblIncome_previous")
    public WebElement ekGelirlerPreviousButton;

    @FindBy(xpath = "//span[contains(text(), 'Gelir Toplam')]")
    public WebElement ekGelirlerGelirToplamTitle;


}
