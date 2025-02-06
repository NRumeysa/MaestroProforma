package com.maestro.stepDefinitions;

import com.maestro.pages.DashboardPage;
import com.maestro.pages.LoginPage;
import com.maestro.pages.ProformaPage;
import com.maestro.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProformaStepDef {

    LoginPage loginPage = new LoginPage();
    ProformaPage proformaPage = new ProformaPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("kullanici sisteme giris yapmis durumda")
    public void kullaniciSistemeGirisYapmisDurumda() {
        Driver.getDriver().get("https://medtest.evetmaestro.net/Default.aspx");
        loginPage.email.sendKeys(ConfigReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();

    }

    @And("proforma alt basligina tiklar")
    public void proformaAltBasliginaTiklar() {
        WaitUtils.waitForPageToLoad(10);
        dashboardPage.satisYonetimiLinki.click();
        dashboardPage.proformaLinki.click();

    }

    @And("proforma listesi sayfasinin goruntulendigini dogrular")
    public void proformaListesiSayfasininGoruntulendiginiDogrular() {
        WaitUtils.waitForPageToLoad(10);
        proformaPage.proformaListesiTitle.isDisplayed();
    }

    @And("yeni butonuna tiklar")
    public void yeniButonunaTiklar() {
        proformaPage.newButton.click();
        WaitUtils.waitForPageToLoad(20);
    }

    @And("tarih bilgisinin otomatik olarak geldigini dogrular")
    public void tarihBilgisininOtomatikOlarakGeldiginiDogrular() {
        WaitUtils.waitForClickablility(proformaPage.dateBox, 20);
        proformaPage.dateBox.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement dateBox = proformaPage.dateBox;

        String actualDate = (String) js.executeScript("return arguments[0].value;", dateBox);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String expectedDate = now.format(formatter);

        Assert.assertEquals(expectedDate, actualDate);
        proformaPage.musteriText.click();
    }

    @And("musteri alanindan secer")
    public void musteriAlanindanSecer() {
        WaitUtils.waitForClickablility(proformaPage.accountDropdown, 10);
        proformaPage.accountDropdown.click();
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitFor(2);

        WaitUtils.waitForClickablility(proformaPage.accountDropdown, 10);
        proformaPage.accountDropdown.click();
        WaitUtils.waitForClickablility(proformaPage.musteriSecimiBox, 10);
        proformaPage.musteriSecimiBox.sendKeys("GÜLCAN ELMAS");
        WaitUtils.waitFor(3);
        proformaPage.musteriSecimiBox.sendKeys(Keys.ENTER);
    }

    @And("yetkili bilgisinin {string} olarak otomatik geldigini dogrular")
    public void yetkiliBilgisininOlarakOtomatikGeldiginiDogrular(String expectedYetkili) {

        WaitUtils.waitForClickablility(proformaPage.yetkiliDropdown, 10);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(driver -> {
            String text = proformaPage.yetkiliDropdown.getText();
            return !text.equals("Müşteri Yetkilisi Seçiniz") && !text.isEmpty();
        });

        String actualYetkili = proformaPage.yetkiliDropdown.getText();
        Assert.assertEquals("Yetkili bilgisi beklendiği gibi gelmedi", expectedYetkili, actualYetkili);
    }

    @And("fatura bilgisinin {string} olarak otomatik geldigini dogrular")
    public void faturaBilgisininOlarakOtomatikGeldiginiDogrular(String expectedFatura) {

        WaitUtils.waitForClickablility(proformaPage.faturaAddresDropdown, 10);


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(driver -> {
            String text = proformaPage.faturaAddresDropdown.getText();
            return !text.equals("Fatura Adresi Seçiniz") && !text.isEmpty();
        });


        String actualFatura = proformaPage.faturaAddresDropdown.getText().replaceAll("\\s+", " ").trim();
        expectedFatura = expectedFatura.replaceAll("\\s+", " ").trim();

        Assert.assertEquals("Fatura bilgisi beklendiği gibi gelmedi", expectedFatura, actualFatura);
    }

    @And("teslimat alanina {string} girer")
    public void teslimatAlaninaGirer(String teslimatAdresi) {
        try {
            WaitUtils.waitForPageToLoad(10);
            
            // Select2 container'ın yüklenmesini bekle
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".select2-container--default")));
            
            // Select2'yu JavaScript ile aç
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("$('#ddDeliveryAddress').select2('open');");
            WaitUtils.waitFor(1);
            
            // Search box'ı bul ve değer gir
            By searchBoxLocator = By.cssSelector("span.select2-search.select2-search--dropdown input.select2-search__field");
            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(searchBoxLocator));
            
            searchBox.sendKeys(teslimatAdresi);
            WaitUtils.waitFor(1);
            
            // Dropdown seçeneklerinin yüklenmesini bekle
            By optionLocator = By.cssSelector(".select2-results__option");
            wait.until(ExpectedConditions.presenceOfElementLocated(optionLocator));
            
            // İlk eşleşen seçeneği seç
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(@class, 'select2-results__option') and contains(text(), '" + teslimatAdresi + "')]")));
            option.click();
            
        } catch (Exception e) {
            System.out.println("Teslimat adresi girilirken hata oluştu: " + e.getMessage());
            // Mevcut Select2 durumunu kontrol et
            try {
                WebElement select2Element = Driver.getDriver().findElement(By.id("ddDeliveryAddress"));
                System.out.println("Select2 elementi mevcut: " + select2Element.isDisplayed());
                System.out.println("Select2 class değeri: " + select2Element.getAttribute("class"));
            } catch (Exception ex) {
                System.out.println("Select2 elementi bulunamadı");
            }
            throw e;
        }
    }

    @And("kalemler alanindan {string} secer")
    public void kalemlerAlanindanSecer(String kalem) {
        try {
            // Kalemler linkine scroll ve tıklama
            JSUtils.JSscrollIntoView(proformaPage.kalemlerLink);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(proformaPage.kalemlerLink));
            proformaPage.kalemlerLink.click();
            
            // Ürün ekleme butonunu bekle ve tıkla
            wait.until(ExpectedConditions.elementToBeClickable(proformaPage.urunEkleButon));
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", proformaPage.urunEkleButon);
            
            // Kapatma butonunu bekle ve tıkla
            wait.until(ExpectedConditions.elementToBeClickable(proformaPage.kapatButon));
            proformaPage.kapatButon.click();
            
        } catch (Exception e) {
            System.out.println("Kalemler alanından ürün seçilirken hata oluştu: " + e.getMessage());
            throw e;
        }
    }

    @When("kaydet butonuna tiklanir")
    public void kaydetButonunaTiklanir() {

        ActionsUtils.scrollEnd();
        WaitUtils.waitForClickablility(proformaPage.kaydetButon, 10);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", proformaPage.kaydetButon);
    }

    @Then("proformanin basariyla kaydedildigini dogrular")
    public void proformaninBasariylaKaydedildiginiDogrular() {

        WaitUtils.waitForVisibility(proformaPage.basariliKayitBaslik, 10);
        WaitUtils.waitForVisibility(proformaPage.basariliKayitMesaji, 10);

        String expectedTitle = "VH3 KANSAYIM CİHAZI";
        String expectedMessage = "Ürün sipariş kalemlerine eklendi";

        Assert.assertEquals("Başarılı kayıt başlığı beklendiği gibi değil",
                expectedTitle, proformaPage.basariliKayitBaslik.getText());
        Assert.assertEquals("Başarılı kayıt mesajı beklendiği gibi değil",
                expectedMessage, proformaPage.basariliKayitMesaji.getText());
    }

    //-----------------------------------------tc02---------------------------------------------

    @Given("Kullanıcı hesaba giriş yapmış olmalıdır")
    public void kullaniciHesabaGirisYapmisOlmalidir() {
        kullaniciSistemeGirisYapmisDurumda();
    }

    @And("Tarih alani bos birakilir")
    public void tarihAlaniBosBirakilir() {
        WaitUtils.waitForClickablility(proformaPage.dateBox, 10);
        proformaPage.dateBox.click();
        proformaPage.dateBox.clear();
        
        // JavaScript ile de temizleyelim
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value = '';", proformaPage.dateBox);
        
        // Değerin boş olduğunu kontrol edelim
        String dateValue = proformaPage.dateBox.getDomProperty("value");
        Assert.assertTrue("Tarih alanı boş değil!", dateValue == null || dateValue.isEmpty());
        
        proformaPage.musteriText.click(); // focus'u tarih alanından çıkarmak için
    }

    @And("Kalemler alanindan veri secilmeye calisildiginda")
    public void kalemlerAlanindanVeriSecilmeyeCalisildiginda() {
        try {
            // Kalemler linkine scroll ve tıklama
            JSUtils.JSscrollIntoView(proformaPage.kalemlerLink);
            WaitUtils.waitForClickablility(proformaPage.kalemlerLink, 10);
            proformaPage.kalemlerLink.click();
            
            // Sayfanın yüklenmesini bekle
            WaitUtils.waitForPageToLoad(10);
            
            // Ürün ekleme butonunu bekle ve tıkla
            WaitUtils.waitForClickablility(proformaPage.urunEkleButon, 15);
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", proformaPage.urunEkleButon);
            
            // Hata mesajının görünmesini bekle
            WaitUtils.waitForVisibility(proformaPage.hataMesaji, 10);
            
        } catch (Exception e) {
            System.out.println("Kalemler alanından veri seçilirken hata: " + e.getMessage());
            throw e;
        }
    }

    @Then("Sistem hata mesajı göstermelidir")
    public void sistemHataMesajiGostermelidir() {
        try {
            String expectedErrorMessage = "AddProduct(): String was not recognized as a valid DateTime.";
            WaitUtils.waitForVisibility(proformaPage.hataMesaji, 10);
            
            // Hata mesajının tam metnini yazdıralım
            System.out.println("Görünen hata mesajı: " + proformaPage.hataMesaji.getText());
            
            Assert.assertEquals("Hata mesajı beklendiği gibi değil",
                    expectedErrorMessage, proformaPage.hataMesaji.getText());
        } catch (Exception e) {
            System.out.println("Hata mesajı kontrolü sırasında hata: " + e.getMessage());
            throw e;
        }
    }

    //-----------------------------------------tc03---------------------------------------------

    @And("musteri alani bos birakilir")
    public void musteriAlaniBosBirakilir() {
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitFor(2);

        PageFactory.initElements(Driver.getDriver(), proformaPage);
        proformaPage.musteriText.click(); // tarih focusundan kurtulmak için
    }

    @Then("Sistem Hata mesajı göstermelidir")
    public void sistemmHataMesajiGostermelidir() {
        String expectedErrorMessage = "Müşteri seçiniz";
        WaitUtils.waitForVisibility(proformaPage.hataMesaji, 10);
        Assert.assertEquals("Hata mesajı beklendiği gibi değil",
                expectedErrorMessage, proformaPage.hataMesaji.getText());
    }

    //-----------------------------------------tc04-------------------------------------

    @And("tarih alanina {string} girer")
    public void tarihAlaninaGirer(String tarih) {
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitFor(2);
        PageFactory.initElements(Driver.getDriver(), proformaPage);

        WaitUtils.waitForClickablility(proformaPage.dateBox, 10);
        proformaPage.dateBox.click();
        proformaPage.dateBox.clear();

        // JavaScript ile değeri set et
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value = arguments[1]", proformaPage.dateBox, tarih);

        // Normal yolla da gönder
        proformaPage.dateBox.sendKeys(tarih);
        proformaPage.dateBox.sendKeys(Keys.ENTER);

        // Focus'u değiştir
        proformaPage.musteriText.click();

        // Kontrol et
        WaitUtils.waitFor(1);
        String currentValue = proformaPage.dateBox.getDomProperty("value");
        System.out.println("Girilen değer: " + currentValue); // Debug için
    }

    @Then("sistem hata mesajı göstermelidir")
    public void ssistemHataMesajiGostermelidir() {
        String expectedErrorMessage = "AddProduct(): The string was not recognized as a valid DateTime. There is an unknown word starting at index 0.";
        WaitUtils.waitForVisibility(proformaPage.hataMesaji, 10);
        Assert.assertEquals("Hata mesajı beklendiği gibi değil",
                expectedErrorMessage, proformaPage.hataMesaji.getText());
    }


    //-----------------------------------------tc05-------------------------------------

    @And("musteri alaninda + butonuna tıklanir")
    public void musteriAlanindaButonunaTiklanir() {
        WaitUtils.waitForClickablility(proformaPage.accountDropdown, 10);
        proformaPage.accountDropdown.click();
        WaitUtils.waitFor(2);

        WaitUtils.waitForClickablility(proformaPage.yeniMusteriEkleButon, 10);
        proformaPage.yeniMusteriEkleButon.click();
    }

    @And("Tabela adi alanina {string} girer")
    public void tabelaAdiAlaninaGirer(String arg0) {
        WaitUtils.waitForVisibility(proformaPage.tabelaAdiBox, 5).click();
        proformaPage.tabelaAdiBox.sendKeys(arg0);
        proformaPage.yeniMusteriAdiText.click();

    }

    @And("Kaydet butonuna tiklanir")
    public void kkaydetButonunaTiklanir() {
        proformaPage.yeniMusteriKaydetButon.click();
        WaitUtils.waitForPageToLoad(5);
    }

    @Then("Musteri alaninda {string} secilmis oldugu dogrulanir")
    public void musteriAlanindaSecilmisOlduguDogrulanir(String expectedTabela) {
        // Önce sayfanın yüklenmesini bekleyelim
        WaitUtils.waitForPageToLoad(10);

        // Placeholder olmayan elementi bekleyelim (yani müşteri seçilmiş durumu)
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(
                By.cssSelector("#select2-ddAccount-container .select2-selection__placeholder"),
                "Müşteri Seçiniz"
        ));

        // Seçilen müşteri adını alalım
        String actualMusteriAdi = ((JavascriptExecutor) Driver.getDriver())
                .executeScript("return document.querySelector('#select2-ddAccount-container').innerText")
                .toString().trim();

        System.out.println("Seçilen müşteri: " + actualMusteriAdi);
        Assert.assertEquals("Müşteri adı beklendiği gibi görüntülenmiyor", expectedTabela, actualMusteriAdi);
    }

}
