package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.ProductDetailPage;
import com.codecool.idokep.test.pages.WebshopPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WebshopTest extends BaseTest{

    WebshopPage webshopPage;
    ProductDetailPage productDetailPage;

    @BeforeEach
    void setup() {
        webshopPage = new WebshopPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        webshopPage.navigateToWebshop();
    }

    @Test
    void productDetails() {
        webshopPage.clickOnProductThumbnail();
        assertTrue(productDetailPage.isDescriptionDisplayed() && productDetailPage.isLeadDisplayed());
    }

    @Test
    void nextItemIsDisplayedTest() {
        webshopPage.clickOnNextArrow();
        assertTrue(webshopPage.isNextElementDisplayed());
    }

}
