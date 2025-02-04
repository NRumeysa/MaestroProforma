package com.maestro.pages;

import com.maestro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KalemlerPage {

    public KalemlerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "heading2")
    public WebElement kalemlerTitle;

    //---------------------------------------------ürün listesi alanı

    @FindBy(id = "headingOne")
    public WebElement urunListesiTitle;

    @FindBy(id = "select2-ddProductBrand-container")
    public WebElement markaDropdown;

    @FindBy(id = "select2-ddProductGroup1-container")
    public WebElement anaGrupDropdown;

    @FindBy(id = "select2-ddProductGroup2-container")
    public WebElement araGrupDropdown;

    @FindBy(id = "select2-ddProductGroup3-container")
    public WebElement altGrupDropdown;

    @FindBy(id = "select2-ddProductType-container")
    public WebElement urunTipiDropdown;

    @FindBy(id = "ddCommonParams")
    public WebElement ekParametreDropdown;

    @FindBy(id = "select2-ddCustomFilter-container")
    public WebElement ozelFiltreDropdown;

    @FindBy(xpath= "//button[@onclick='ProductAdvancedSearch(true)']")
    public WebElement searchButton;

    @FindBy(xpath= "//button[.='Temizle']")
    public WebElement clearButton;

    @FindBy(id = "tblProductList_length")
    public WebElement urubnListesiKayitDropdown;

    @FindBy(xpath = "//input[@aria-controls='tblProductList']")
    public WebElement urunSearchBox;

    @FindBy(xpath = "//*[@onclick='AddProduct(59434)']")
    public WebElement urunEkleButton;

    @FindBy(xpath = "(//th[contains(text(),'Kodu')])[1]")
    public WebElement urunKoduTitle;

    @FindBy(xpath = "(//th[contains(text(),'Marka')])[2]")
    public WebElement urunMarkaTitle;

    @FindBy(xpath = "(//th[contains(text(),'Adı')])[1]")
    public WebElement urunAdTitle;

    @FindBy(xpath = "(//th[contains(text(),'Ana Grubu')])[1]")
    public WebElement anaGrubuTitle;

    @FindBy(xpath = "(//th[contains(text(),'Alt Grubu')])[1]")
    public WebElement altGrubuTitle;

    @FindBy(xpath = "(//th[contains(text(),'Fiyat')])[1]")
    public WebElement fiyatTitle;

    @FindBy(xpath = "(//th[contains(text(),'Kdv')])[1]")
    public WebElement kdvTitle;

    @FindBy(xpath = "(//th[contains(text(),'Stok')])[1]")
    public WebElement stokTitle;

    @FindBy(xpath = "//*[@onclick='GetProductRanOutTimeByIDProduct(59434)']")
    public WebElement stokAdetButton; //vh3 kansayım cihazı

    @FindBy(xpath = "(//*[@onclick='GetReservedByIDProduct(59434)'])[1]")
    public WebElement rezerveAdetButton; //vh3 rezerve

    @FindBy(xpath = "(//*[@onclick='GetReservedByIDProduct(59434)'])[2]")
    public WebElement ihaleRezerveAdetButton; //vh3 ihale rezerve

    @FindBy(xpath = "//*[@onclick='GetPurchaseReservedByIDProduct(59434)']")
    public WebElement alisRezerveAdetButton; //vh3 alış rezerve

    @FindBy(xpath = "//*[@onclick='GetPriorityByIDProduct(59434)']")
    public WebElement sevkiyatTalebiButton; //vh3 sevkiyat talebi

    @FindBy(xpath = "//*[@onclick='GetLockedQuantityByIDProduct(59434)']")
    public WebElement kilitliMiktarButton; //vh3 kilitli miktar

    @FindBy(id = "tblProductList_next")
    public WebElement urunNextPageButton;

    @FindBy(id = "tblProductList_previous")
    public WebElement previousPageButton;

    @FindBy(xpath = "(//li[@class='paginate_button '])[2]")
    public WebElement urunPage3Button;

    @FindBy(id = "tblProductList_info")
    public WebElement urunListesiInfo;


    //---------------------------------------------paketler alanı


    @FindBy(xpath = "//a[contains(text(), 'Paketler')] ")
    public WebElement paketlerTitle;

    @FindBy(id = "tblPackageList_length")
    public WebElement paketKayitDropdown;

    @FindBy(id = "tblPackageList_filter")
    public WebElement paketSearchBox;

    @FindBy(xpath = "//*[@onclick='AddPackage(57)']")
    public WebElement paketEkleButton;

    @FindBy(xpath = "(//th[contains(text(), 'Adı')])[3]")
    public WebElement paketAdTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Toplam')])[1]")
    public WebElement paketToplamTitle;

    @FindBy(id = "tblPackageList_next")
    public WebElement paketNextPageButton;

    @FindBy(id = "tblPackageList_previous")
    public WebElement paketPreviousPageButton;

    @FindBy(xpath = "(//li[@class='paginate_button '])[1]")
    public WebElement paketPage5Button;

    @FindBy(id = "tblPackageList_info")
    public WebElement paketInfo;

    //---------------------------------------------Ayrılmış Ürün Listesi alanı
    //----2.EL alanı

    @FindBy(xpath = "//a[@href='#collapseThree']")
    public WebElement ayrilmisUrunListesiTitle;

    @FindBy(xpath = "//span[contains(text(), '2. EL')]")
    public WebElement ikinciElTitle;

    @FindBy(className = "tblDividedProduct_0_length")
    public WebElement ikinciElKayitDropdown;

    @FindBy(xpath = "//a[@onclick='AddProduct(58460)']")
    public WebElement ikinciElUrunEkleButton;

    @FindBy(id = "tblDividedProduct_0_filter")
    public WebElement ikinciElSearchBox;

    @FindBy(xpath = "(//th[contains(text(), 'Kodu')])[3]")
    public WebElement ikinciElKoduTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Marka')])[4]")
    public WebElement ikinciElMarkaTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Adı')])[4]")
    public WebElement ikinciElAdTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Ana Grubu')])[3]")
    public WebElement ikinciElAnaGrubuTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Alt Grubu')])[3]")
    public WebElement ikinciElAltGrubuTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Fiyatı')])[1]")
    public WebElement ikinciElFiyatTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Kdv')])[3]")
    public WebElement ikinciElKdvTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Stok')])[3]")
    public WebElement ikinciElStokTitle;

    @FindBy(id = "tblDividedProduct_0_info")
    public WebElement ikinciElInfo;

    @FindBy(id = "tblDividedProduct_0_next")
    public WebElement ikinciElNextPageButton;

    @FindBy(id = "tblDividedProduct_0_previous")
    public WebElement ikinciElPreviousPageButton;

    //----Safir alanı

    @FindBy(xpath = "//span[contains(text(),'SAFİR')]")
    public WebElement safirTitle;

    @FindBy(xpath = "//*[@name='tblDividedProduct_1_length']")
    public WebElement safirKayitDropdown;

    @FindBy(id = "tblDividedProduct_1_filter")
    public WebElement safirSearchBox;

    @FindBy(xpath = "//a[@onclick = 'AddProduct(60662)']")
    public WebElement safirUrunEkleButton;

    @FindBy(xpath = "(//th[contains(text(), 'Kodu')])[4]")
    public WebElement safirKoduTitle;

    @FindBy(xpath = "((//th[contains(text(), 'Marka')])[5]")
    public WebElement safirMarkaTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Adı')])[5]")
    public WebElement safirAdTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Ana Grubu')])[4]")
    public WebElement safirAnaGrubuTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Alt Grubu')])[4]")
    public WebElement safirAltGrubuTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Fiyatı')])[2]")
    public WebElement safirFiyatTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Kdv')])[4]")
    public WebElement safirKdvTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Stok')])[4]")
    public WebElement safirStokTitle;

    @FindBy(id = "tblDividedProduct_1_info")
    public WebElement safirInfo;

    @FindBy(id = "tblDividedProduct_1_next")
    public WebElement safirNextPageButton;

    @FindBy(id = "tblDividedProduct_1_previous")
    public WebElement safirPreviousPageButton;

    //----Travmavet alanı

    @FindBy(xpath = "//span[contains(text(), 'TRAVMAVET')]")
    public WebElement travmavetTitle;

    @FindBy(xpath = "//*[@name='tblDividedProduct_2_length']")
    public WebElement travmavetKayitDropdown;

    @FindBy(id = "tblDividedProduct_2_filter")
    public WebElement travmavetSearchBox;

    @FindBy(xpath = "//*[@onclick='AddProduct(61483)']")
    public WebElement travmavetUrunEkleButton;

    @FindBy(xpath = "(//th[contains(text(), 'Kodu')])[5]")
    public WebElement travmavetKoduTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Marka')])[6]")
    public WebElement travmavetMarkaTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Adı')])[6]")
    public WebElement travmavetAdTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Ana Grubu')])[5]")
    public WebElement travmavetAnaGrubuTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Alt Grubu')])[5]")
    public WebElement travmavetAltGrubuTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Fiyatı')])[3]")
    public WebElement travmavetFiyatTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Kdv')])[5]")
    public WebElement travmavetKdvTitle;

    @FindBy(xpath = "(//th[contains(text(), 'Stok')])[5]")
    public WebElement travmavetStokTitle;

    @FindBy(id ="tblDividedProduct_2_info")
    public WebElement travmavetInfo;

    @FindBy(id ="tblDividedProduct_2_next")
    public WebElement travmavetNextPageButton;

    @FindBy(id ="tblDividedProduct_2_previous")
    public WebElement travmavetPreviousPageButton;


    //----Seçilen Kalemler alanı

    @FindBy(xpath = "(//div/span[contains(text(), 'Kalemler')])[1]")
    public WebElement secilenKalemlerTitle;

    @FindBy(xpath = "//*[@onclick='AllDeleteItem()']")
    public WebElement secilenKalemlerTumunuSilButton;

    @FindBy(xpath = "//a[contains(text(),'Özelleştir')]")
    public WebElement secilenKalemlerOzellestirButton;

    @FindBy(id = "btnTaxRate")
    public WebElement secilenKalemlerKdvButton; //kdv oranı dorpdown

    @FindBy(xpath = "//*[@onclick='ChangeTaxRate(0)']")
    public WebElement secilenKalemlerKdvYuzde0;

    @FindBy(id = "ChangeTaxRate(-1)")
    public WebElement secilenKalemlerUrunKartiKdvOrani;

    @FindBy(xpath = "(//*[@id='tblOrderItemList_previous'])[1]")
    public WebElement secilenKalemlerSearchBox;

    @FindBy(xpath = "//*[@name='tblOrderItemList_length']")
    public WebElement secilenKalemlerKayitDropdown;

    @FindBy(xpath = "//*[contains(text(),'Çıkış Depo')]")
    public WebElement secilenKalemlerCikisDepoTitle;

    @FindBy(xpath = "(//th[contains(text(),'Adı')])[7]")
    public WebElement secilenKalemlerAdTitle;

    @FindBy(xpath = "((//th[contains(text(),'Maliyet')])[1]")
    public WebElement secilenKalemlerMaliyetTitle;

    @FindBy(xpath = "//th[contains(text(),'M. Isk. %')]")
    public WebElement secilenKalemlerMaliyetIskontoTitle;

    @FindBy(xpath = "(//th[contains(text(),'Fiyat')])[6]")
    public WebElement secilenKalemlerFiyatTitle;

    @FindBy(xpath = "(//th[contains(text(),'Kdv %')]")
    public WebElement secilenKalemlerKdvTitle;

    @FindBy(xpath = "(//th[contains(text(),'Tutar')])[1]")
    public WebElement secilenKalemlerTutarTitle;

    @FindBy(xpath = "(//th[contains(text(),'Net Tutar')])[1]")
    public WebElement secilenKalemlerNetTutarTitle;

    @FindBy(xpath = "(//th[contains(text(),'Top. Tutar')])[1]")
    public WebElement secilenKalemlerToplamTutarTitle;

    @FindBy(xpath = "(//th[contains(text(),'Giriş Depo')])[1]")
    public WebElement secilenKalemlerGirisDepoTitle;

    @FindBy(id = "tblOrderItemList_info")
    public WebElement secilenKalemlerInfo;

    @FindBy(id = "tblOrderItemList_next")
    public WebElement secilenKalemlerNextPageButton;

    @FindBy(xpath = "(//*[@id='tblOrderItemList_previous'])[2]")
    public WebElement secilenKalemlerPreviousPageButton;

    @FindBy(xpath = "//*[contains(text(), 'Maliyet ve Brüt Kârlılık')]")
    public WebElement maliyetVeBrutKarlikTitle;

    @FindBy(xpath = "(//*[contains(text(), 'İskonto')])[2]")
    public WebElement iskontoTitle;

    @FindBy(xpath = "(//*[contains(text(), 'Alt Toplam')])[2]")
    public WebElement altToplamTitle;

    @FindBy(xpath = "//*[contains(text(), 'Grup Bazlı İskonto Oluştur')]")
    public WebElement grupBazliIskontoOlusturButton;

    @FindBy(xpath = "//*[contains(text(), 'Maliyet İskontosunu Satış İskontosuna Uygula')]")
    public WebElement maliyetIskontoSatIskontoButton;




}
