package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebshopPage extends Page {

    @FindBy(className = "carousel_next")
    WebElement browseNext;

    @FindBy(xpath = "//img[@alt='Kültéri IP kamera']")
    WebElement cameraThumbnail;

    @FindBy(xpath = "//li[@class='ajax_block_product item']")
    List<WebElement> products;

    @FindBy(xpath = "//a[@rel='ajax_id_product_8']")
    WebElement cameraAddToCartButton;

    @FindBy(xpath = "//a[@rel='ajax_id_product_10']")
    WebElement weatherStationAddToCartButton;


    public WebshopPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToWebshop() {
        driver.get("https://shop.idokep.hu");
    }

    public void clickOnProductThumbnail() {
        clickOn(cameraThumbnail);
    }

    public void clickOnNextArrow() {
        clickOn(browseNext);
    }

    public boolean isNextElementDisplayed() {
        return products.get(4).isDisplayed();
    }

    public void addCameraToCart() {
        clickOn(cameraAddToCartButton);
    }

    public void addWeatherStationToCart() {
        clickOn(weatherStationAddToCartButton);
    }


}
