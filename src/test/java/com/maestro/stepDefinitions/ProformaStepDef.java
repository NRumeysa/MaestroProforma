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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        WaitUtils.waitForPageToLoad(10);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("$('#ddDeliveryAddress').select2('open');");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
        wait.until(driver -> searchBox.isDisplayed());

        searchBox.clear();
        searchBox.sendKeys(teslimatAdresi);
        WaitUtils.waitFor(1);
        searchBox.sendKeys(Keys.ENTER);
    }

    @And("kalemler alanindan {string} secer")
    public void kalemlerAlanindanSecer(String kalem) {
        JSUtils.JSscrollIntoView(proformaPage.kalemlerLink);
        WaitUtils.waitForClickablility(proformaPage.kalemlerLink, 10);
        proformaPage.kalemlerLink.click();

        Driver.getDriver().navigate().refresh();
        WaitUtils.waitFor(2);
        // Refresh sonrası elementleri yeniden initialize et
        PageFactory.initElements(Driver.getDriver(), proformaPage);

        JSUtils.JSscrollIntoView(proformaPage.kalemlerLink);
        WaitUtils.waitForClickablility(proformaPage.kalemlerLink, 10);
        proformaPage.kalemlerLink.click();

        WaitUtils.waitForPageToLoad(10);
        WaitUtils.waitForClickablility(proformaPage.urunEkleButon, 15);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", proformaPage.urunEkleButon);

        WaitUtils.waitForVisibility(proformaPage.kapatButon, 10);
        WaitUtils.waitForClickablility(proformaPage.kapatButon, 10);
        proformaPage.kapatButon.click();
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
        proformaPage.musteriText.click(); // focus'u tarih alanından çıkarmak için
    }

    @And("Kalemler alanindan veri secilmeye calisildiginda")
    public void kalemlerAlanindanVeriSecilmeyeCalisildiginda() {
        JSUtils.JSscrollIntoView(proformaPage.kalemlerLink);
        WaitUtils.waitForClickablility(proformaPage.kalemlerLink, 10);
        proformaPage.kalemlerLink.click();

        WaitUtils.waitForClickablility(proformaPage.urunEkleButon, 10);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", proformaPage.urunEkleButon);
    }

    @Then("Sistem hata mesajı göstermelidir")
    public void sistemHataMesajiGostermelidir() {
        String expectedErrorMessage = "AddProduct(): String was not recognized as a valid DateTime.";
        WaitUtils.waitForVisibility(proformaPage.hataMesaji, 10);
        Assert.assertEquals("Hata mesajı beklendiği gibi değil", 
            expectedErrorMessage, proformaPage.hataMesaji.getText());
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















}
