package com.maestro.stepDefinitions;

import com.maestro.pages.DashboardPage;
import com.maestro.pages.LoginPage;
import com.maestro.pages.ProformaPage;
import com.maestro.utilities.ConfigReader;
import com.maestro.utilities.Driver;
import com.maestro.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
        WaitUtils.waitForPageToLoad(5);
    }

    @And("tarih bilgisinin otomatik olarak geldigini dogrular")
    public void tarihBilgisininOtomatikOlarakGeldiginiDogrular() {

        proformaPage.dateBox.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement dateBox = proformaPage.dateBox;

        String actualDate = (String) js.executeScript("return arguments[0].value;", dateBox);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String expectedDate = now.format(formatter);

        Assert.assertEquals(expectedDate, actualDate);

    }

    @And("musteri alanindan {string} secer")
    public void musteriAlanindanSecer(String arg0) {
        
    }

    @And("yetkili bilgisinin {string} olarak otomatik geldigini dogrular")
    public void yetkiliBilgisininOlarakOtomatikGeldiginiDogrular(String arg0) {
    }

    @And("fatura bilgisinin {string} olarak otomatik geldigini dogrular")
    public void faturaBilgisininOlarakOtomatikGeldiginiDogrular(String arg0) {
    }

    @And("teslimat alanina {string} girer")
    public void teslimatAlaninaGirer(String arg0) {
    }

    @And("kalemler alanindan {string} secer")
    public void kalemlerAlanindanSecer(String arg0) {
    }

    @When("kaydet butonuna tiklanir")
    public void kaydetButonunaTiklanir() {
    }

    @Then("proformanin basariyla kaydedildigini dogrular")
    public void proformaninBasariylaKaydedildiginiDogrular() {
    }
}
