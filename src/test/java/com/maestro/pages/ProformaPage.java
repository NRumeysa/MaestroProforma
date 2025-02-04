package com.maestro.pages;

import com.maestro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProformaPage {

    public ProformaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "PageContent_spnPageTitle")
    public WebElement proformaListesiTitle;

    @FindBy(id = "btnNew")
    public WebElement newButton;

    @FindBy(id = "txtTransactionDate")
    public WebElement dateBox;

    @FindBy(id = "select2-ddAccount-container")
    public WebElement accountDropdown;

    @FindBy(id = "select2-ddAccountPerson-container")
    public WebElement yetkiliDropdown;

    @FindBy(id = "select2-ddInvoiceAddress-container")
    public WebElement faturaAddresDropdown;

    @FindBy(id = "select2-ddDeliveryAddress-container")
    public WebElement teslimatAddresDropdown;

    @FindBy(id = "select2-ddCurrency-container")
    public WebElement paraBirimiDropdown;

    @FindBy(id = "select2-ddPersonnel-container")
    public WebElement personelDropdown;

    @FindBy(id = "select2-ddProductPriceGroup-container")
    public WebElement fiyatGrubuDropdown;

    @FindBy(xpath= "//input[@placeholder='Etiket Seçiniz']")
    public WebElement etiketDropdown;

    @FindBy(xpath= "//*[@onclick='project.openPopup()']")
    public WebElement projeButton;

    @FindBy(xpath= "//*[@onclick='AddProjectProducts()']")
    public WebElement urunAktarButton;

    @FindBy(id = "txtDeliveryDate")
    public WebElement teslimatTarihiBox;

    @FindBy(id = "txtMaturityDate")
    public WebElement vadeTarihiBox;

    @FindBy(id = "spnImportFileName")
    public WebElement iceAktarButton;




    //---------------------------Yazdırma Parametreleri-----------------------------------------

    @FindBy(id = "cbShowSUTCode")
    public WebElement sutKoduCheckbox;

    @FindBy(id = "cbShowUTSCode")
    public WebElement utsKoduCheckbox;

    @FindBy(id = "cbShowProductBarcode")
    public WebElement urunBarkodCheckbox;

    @FindBy(id = "cbShowProductPicture")
    public WebElement urunResimCheckbox;

    @FindBy(id = "cbShowProductDescription")
    public WebElement urunAciklamaCheckbox;

    @FindBy(id = "cbShowProductAccessory")
    public WebElement urunAksesuarCheckbox;

    @FindBy(id = "cbSignature")
    public WebElement imzaCheckbox;

    @FindBy(id = "cbCargoIncluded")
    public WebElement kargoDahilCheckbox;

    @FindBy(id = "cbShowUnitPrice")
    public WebElement birimFiyatCheckbox;

    @FindBy(id = "cbRowTax")
    public WebElement satirKdvCheckbox;

    @FindBy(id = "cbRowDiscount")
    public WebElement satirIskCheckbox;

    @FindBy(id = "cbSubRowDiscount")
    public WebElement satIskTopCheckbox;

    @FindBy(id = "cbAvgDiscountRate")
    public WebElement topIskCheckbox;

    @FindBy(id = "cbSubTaxValue")
    public WebElement kdvTutarCheckbox;

    @FindBy(id = "cbSubTax")
    public WebElement kdvToplamCheckbox;

    @FindBy(id = "cbSubDiscount")
    public WebElement gnlIskTopCheckbox;

    @FindBy(id = "cbHideSubTotalFlag")
    public WebElement altToplamCheckbox;

    @FindBy(id = "cbShowGrossTotal")
    public WebElement brutToplamCheckbox;

    @FindBy(id = "cbShowNetTotal")
    public WebElement netToplamCheckbox;

    @FindBy(id = "cbItemGeneralTotal")
    public WebElement satGTopCheckbox;

    @FindBy(id = "cbGroupTotal")
    public WebElement grupTopCheckbox;

    @FindBy(id = "cbHideCoverPage")
    public WebElement kapakSayfaCheckbox;

    @FindBy(id = "cbDescriptionAsEntry")
    public WebElement aciklamaGirisCheckbox;

    @FindBy(id = "cbShowBankDetailsOnLastPage")
    public WebElement bankaBilgileriCheckbox;

    @FindBy(id = "cbHideCustomerAndBankDetails")
    public WebElement musteriOnayiCheckbox;

    @FindBy(id = "cbPersonnelInformation")
    public WebElement personelBilgisiCheckbox;

    @FindBy(id = "cbInstitutionInformation")
    public WebElement kurumBilgisiCheckbox;

    //--------------------------safir özel parametreler--------------------------------------------

    @FindBy(id = "txtSubject")
    public WebElement konuBox;

    @FindBy(id = "txtCountNr")
    public WebElement sayiBox;

    @FindBy(id = "txtPaymentDay")
    public WebElement odemeGunBox;

    @FindBy(id = "select2-ddPaymentType-container")
    public WebElement odemeTipiDropdown;

    @FindBy(id = "txtDeliveryDay")
    public WebElement teslimatGunBox;

    @FindBy(id = "select2-ddOfferType-container")
    public WebElement teklifTipiDropdown;

    @FindBy(id = "cbDealerSaleFlag")
    public WebElement hasvetCheckbox;

    @FindBy(id = "txtDealerRateInfo")
    public WebElement oranBox;



//      Kaydet   |    Kaydet/Yazdır    |    Listeye Dön   alanı

    @FindBy(xpath = "(//a[contains(text(),'Kaydet')])[3]")
    public WebElement genelKaydetButton;

    @FindBy(xpath = "(//a[contains(text(),'Kaydet/Yazdır')])[4]")
    public WebElement genelKaydetYazdirButton;

    @FindBy(xpath = "//a[contains(text(),'Listeye Dön')]")
    public WebElement listeyeDonButton;










}
