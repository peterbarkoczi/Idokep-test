package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.CartNotificationModal;
import com.codecool.idokep.test.pages.CartPage;
import com.codecool.idokep.test.pages.ProductDetailPage;
import com.codecool.idokep.test.pages.WebshopPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WebshopTest extends BaseTest{

    WebshopPage webshopPage;
    ProductDetailPage productDetailPage;
    CartNotificationModal cartNotificationModal;
    CartPage cartPage;

    @BeforeEach
    void setup() {
        webshopPage = new WebshopPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartNotificationModal = new CartNotificationModal(driver);
        cartPage = new CartPage(driver);
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

    @Test
    void addProductToCartTest() {
        List<String> expectedResult = Arrays.asList("Kültéri IP kamera", "WS 9750");
        webshopPage.addCameraToCart();
        cartNotificationModal.clickOnContinueShoppingButton();
        webshopPage.addWeatherStationToCart();
        cartNotificationModal.clickOnCheckCartButton();
        assertEquals(expectedResult, cartPage.getProductsName());
    }

}
