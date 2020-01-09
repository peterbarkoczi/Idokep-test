package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CartPage extends Page {

    @FindBy(css = "#cart_summary img")
    List<WebElement> productsInCart;

    @FindBy(id = "cart_quantity_up_8_0_0_0")
    WebElement firstItemIncreaseAmount;

    @FindBy(id = "cart_quantity_down_8_0_0_0")
    WebElement firstItemDecreaseAmount;

    @FindBy(xpath = "//input[@name='quantity_8_0_0_0']")
    WebElement firstItemTotalAmount;

    @FindBy(id = "10_0_0_0")
    WebElement secondItemDeleteButton;

    private int amount;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProducts() {
        List<String> productsName = new ArrayList<>();
        for (WebElement webElement : productsInCart) {
            productsName.add(webElement.getAttribute("alt"));
        }
        return productsName;
    }

    private void getAmount() {
        amount = Integer.parseInt(firstItemTotalAmount.getAttribute("value"));
    }

    public void increaseFirstItemAmount() {
        getAmount();
        firstItemIncreaseAmount.click();
        amount += 1;
    }

    public void decreaseFirstItemAmount() {
        getAmount();
        firstItemDecreaseAmount.click();
        amount -= 1;
    }

    public int getFirstItemTotalAmount() {
        wait.until((ExpectedCondition<Boolean>) driver -> firstItemTotalAmount.getAttribute("value").equals(String.valueOf(amount)));
        return Integer.parseInt(firstItemTotalAmount.getAttribute("value"));
    }

    public boolean isItemDisappeared(int product) {
        wait.until(ExpectedConditions.invisibilityOf(productsInCart.get(product - 1)));
        return true;
    }

    public void clickOnSecondItemDeleteButton() {
        secondItemDeleteButton.click();
    }

}
