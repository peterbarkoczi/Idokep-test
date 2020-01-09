package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.ProductDetailPage;
import com.codecool.idokep.test.pages.SearchResultsPage;
import com.codecool.idokep.test.pages.WebshopPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebshopTest extends BaseTest {

    WebshopPage webshopPage;
    ProductDetailPage productDetailPage;
    SearchResultsPage searchResultsPage;

    @BeforeEach
    void setup() {
        webshopPage = new WebshopPage(driver);
        productDetailPage = new ProductDetailPage(driver);
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

    @ParameterizedTest
    @CsvFileSource(resources = "/searchkeys.csv", numLinesToSkip = 1)
    void searchItems(String searchKey) {
        webshopPage.setSearchKey(searchKey);
        assertTrue(searchResultsPage.getFirstSearchResult().equalsIgnoreCase(searchKey));
    }

}
