package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebshopPage extends Page {

    @FindBy(className = "carousel_prev")
    WebElement browsePrev;

    @FindBy(className = "carousel_next")
    WebElement browseNext;

    @FindBy(xpath = "//img[@alt='Kültéri IP kamera']")
    WebElement cameraThumbnail;

    public WebshopPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToWebshop() {
        driver.get("https://shop.idokep.hu");
    }

    public void clickOnProductThumbnail() {
        cameraThumbnail.click();
    }

}
