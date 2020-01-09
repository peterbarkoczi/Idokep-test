package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends Page {

    @FindBy(xpath = "//div[@class='product_list_details_left']//descendant ::a[1]")
    WebElement searchResultsTop;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstSearchResult() {
        return searchResultsTop.getText();
    }
}
