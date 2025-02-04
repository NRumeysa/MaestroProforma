package com.maestro.pages;

import com.maestro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[contains(text(),'Satış Yönetimi')]")
    public WebElement satisYonetimiLinki;

    @FindBy(xpath = "(//a[@href=\"OrderListForm.aspx?InvoiceType=4\"])[1]")
    public WebElement proformaLinki;
}
