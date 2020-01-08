package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends Page {

    @FindBy(xpath = "//h1[@itemprop='name']")
    WebElement productNameHeader;

    @FindBy(id = "short_description_content")
    WebElement productLead;

    @FindBy(id = "more_info_sheets")
    WebElement productDescription;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productNameHeader.getText();
    }

    public boolean isLeadDisplayed() {
        return productLead.isDisplayed();
    }

    public boolean isDescriptionDisplayed() {
        return productDescription.isDisplayed();
    }

}
