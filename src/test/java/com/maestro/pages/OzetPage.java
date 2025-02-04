package com.maestro.pages;

import com.maestro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OzetPage {

    public OzetPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Özet')]")
    public WebElement ozetTitle;

    @FindBy(id = "collapse5")
    public WebElement ozetHepsi;

    @FindBy(xpath = "(//label[contains(text(), 'Müşteri')])[3]")
    public WebElement ozetMusteriBox;

    @FindBy(xpath = "(//span[contains(text(), 'Kalemler')])[2]")
    public WebElement ozetKalemlerTitle;

    @FindBy(xpath = "//a[contains(text(),'Tahsilat Planı')]")
    public WebElement ozetTahsilatPlaniTitle;



}
