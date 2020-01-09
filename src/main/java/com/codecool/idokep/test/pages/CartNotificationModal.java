package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartNotificationModal extends Modal {

    @FindBy(xpath = "//button[@class='autumn_add_to_cart noty']")
    WebElement checkCartButton;

    @FindBy(xpath = "//button[@class='autumn-button noty']")
    WebElement continueShoppingButton;

    public CartNotificationModal(WebDriver driver) {
        super(driver);
    }

    public void clickOnCheckCartButton() {
        checkCartButton.click();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

}
