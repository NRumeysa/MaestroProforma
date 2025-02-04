package com.maestro.pages;

import com.maestro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TahsilatPlaniPage {

    public TahsilatPlaniPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='heading3']")
    public WebElement tahsilatPlaniTitle;

    @FindBy(id = "txtPaymentDate")
    public WebElement tahsilatPlaniTarihBox;

    @FindBy(id = "select2-ddPayType-container")
    public WebElement tahsilatPlaniOdemeTipiBox;

    @FindBy(id = "txtPaymentAmount")
    public WebElement tahsilatPlaniTutarBox;

    @FindBy(id = "txtPaymentOrderNr")
    public WebElement tahsilatPlaniTaksitSayisiBox;

    @FindBy(id = "select2-ddPaymentCurrency-container")
    public WebElement tahsilatPlaniParaBirimiBox;

    @FindBy(id = "txtPaymentDescription")
    public WebElement tahsilatPlaniAciklamaBox;

    @FindBy(xpath = "//*[@onclick='AddPayment()']")
    public WebElement tahsilatPlaniEkleButton;

    @FindBy(id = "btnDeleteAllPayment")
    public WebElement tahsilatPlaniTumunuSilButton;

    @FindBy(xpath = "//select[@name='tblPayment_length']")
    public WebElement tahsilatPlaniKayitDrapdown;

    @FindBy(xpath = "(//th[contains(text(), 'Sil')])[3]")
    public WebElement tahsilatPlaniSilTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Ödeme Tarihi')])[1]")
    public WebElement tahsilatPlaniOdemeTarihiTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Tutar')])[7]")
    public WebElement tahsilatPlaniTutarTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Açıklama')])[3]")
    public WebElement tahsilatPlaniAciklamaTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Takas Detayı')]")
    public WebElement tahsilatPlaniTaksitDetayiTitle;

    @FindBy(id = "tblPayment_filter")
    public WebElement tahsilatPlaniSearchBox;

    @FindBy(xpath = "//*[@name='tblPayment_length']")
    public WebElement TahsilatPlaniKayitDrapdown;

    @FindBy(id = "tblPayment_info")
    public WebElement tahsilatPlaniInfo;

    @FindBy(xpath = "(//th[contains(text(),'Toplam')])[2]")
    public WebElement tahsilatPlaniToplamTitle;

    @FindBy(xpath = "//th[contains(text(),'Ödeme Toplamı')]")
    public WebElement tahsilatPlaniOdemeToplamTitle;

    @FindBy(xpath = "(//th[contains(text(),'Kalan')])[2]")
    public WebElement tahsilatPlaniKalanTitle;

    @FindBy(xpath = "(//th[contains(text(),'Ortalama Vade')])[1]")
    public WebElement tahsilatPlaniOrtalamaVadeTitle;

    @FindBy(id = "tblPayment_next")
    public WebElement tahsilatPlaniNextButton;

    @FindBy(id = "tblPayment_previous")
    public WebElement tahsilatPlaniPreviousButton;





}
