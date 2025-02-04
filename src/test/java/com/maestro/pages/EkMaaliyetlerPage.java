package com.maestro.pages;

import com.maestro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EkMaaliyetlerPage {

    public EkMaaliyetlerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "heading8")
    public WebElement ekMaaliyetlerTitle;

    @FindBy(id = "txtCostDate")
    public WebElement ekMaaliyetlerTarihBox;

    @FindBy(id = "select2-ddCostType-container")
    public WebElement ekMaaliyetlerMaaliyetTipiDropdown;

    @FindBy(xpath = "//*[contains(@onclick, \"CostTypePopup('ddCostType')\")]")
    public WebElement ekMaaliyetMaaliyetTipiEkleButton;

    @FindBy(xpath = "//h5[contains(text(),'Maliyet Tipi')]")
    public WebElement ekMaaliyetlerMaaliyetEkleTitle; //iframe içeirisinde!!!!

    @FindBy(xpath = "(//input[@name='Name'])[2]")
    public WebElement ekMaaliyetlerMaaliyetEkleAdi;  //iframe

    @FindBy(id = "cbStatusFlag")
    public WebElement ekMaaliyetlerMaaliyetEkleAktifMi; //iframe

    @FindBy(xpath = "//button[contains(text(), 'Kaydet')]")
    public WebElement ekMaaliyetlerMaaliyetEkleKaydetButton; //iframe

    @FindBy(xpath = "//button[contains(text(), 'Vazgeç')]")
    public WebElement ekMaaliyetlerMaaliyetEkleVazgecButton; //iframe

    @FindBy(id = "txtCompanyTitle")
    public WebElement ekMaaliyetlerFirmaAdiBox;

    @FindBy(id = "txtCostAmount")
    public WebElement ekMaaliyetlerTutarBox;

    @FindBy(id = "ddCostCurrency")
    public WebElement ekMaaliyetlerParaBirimiDropdown;

    @FindBy(id = "txtCostDescription")
    public WebElement ekMaaliyetlerAciklamaBox;

    @FindBy(xpath = "//*[@onclick='AddCost()']")
    public WebElement ekMaaliyetlerEkleButton;

    @FindBy(id = "tblInvoiceCost_length")
    public WebElement ekMaaliyetlerKayitSayisiDropdown;

    @FindBy(xpath = "(//th[contains(text(), 'Sil')])[1]")
    public WebElement ekMaaliyetlerSilTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Tarih')])[2]")
    public WebElement ekMaaliyetlerTarihTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Personel')])[1]")
    public WebElement ekMaaliyetlerPersonelTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Maliyet Tipi')])[1]")
    public WebElement ekMaaliyetlerMaliyetTipiTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Firma Adı')])[1]")
    public WebElement ekMaaliyetlerFirmaAdiTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Tutar')])[5]")
    public WebElement ekMaaliyetlerTutarTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Açıklama')])[1]")
    public WebElement ekMaaliyetlerAciklamaTitle;

    @FindBy(id = "tblInvoiceCost_info")
    public WebElement ekMaaliyetlerInfo;

    @FindBy(id = "tblInvoiceCost_previous")
    public WebElement ekMaaliyetlerPreviousPage;

    @FindBy(id = "tblInvoiceCost_next")
    public WebElement ekMaaliyetlerNextPage;

    @FindBy(xpath = "//*[contains(text(), 'Maliyet Toplam')]")
    public WebElement ekMaaliyetlerMaliyetToplam;




}
