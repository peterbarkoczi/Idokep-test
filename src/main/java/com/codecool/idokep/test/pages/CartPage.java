package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends Page {

    @FindBy(css = "#cart_summary img")
    List<WebElement> productsInCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductsName() {
        List<String> productsName = new ArrayList<>();
        for (WebElement webElement : productsInCart) {
            productsName.add(webElement.getAttribute("alt"));
        }
        return productsName;
    }
}
