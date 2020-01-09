package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.CartNotificationModal;
import com.codecool.idokep.test.pages.CartPage;
import com.codecool.idokep.test.pages.ProductDetailPage;
import com.codecool.idokep.test.pages.SearchResultsPage;
import com.codecool.idokep.test.pages.WebshopPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebshopTest extends BaseTest {

    WebshopPage webshopPage;
    ProductDetailPage productDetailPage;
    CartNotificationModal cartNotificationModal;
    CartPage cartPage;
    SearchResultsPage searchResultsPage;

    @BeforeEach
    void setup() {
        webshopPage = new WebshopPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartNotificationModal = new CartNotificationModal(driver);
        cartPage = new CartPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
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

    @ParameterizedTest
    @CsvFileSource(resources = "/searchkeys.csv", numLinesToSkip = 1)
    void searchItems(String searchKey) {
        webshopPage.setSearchKey(searchKey);
        assertTrue(searchResultsPage.getFirstSearchResult().equalsIgnoreCase(searchKey));
    }

}
