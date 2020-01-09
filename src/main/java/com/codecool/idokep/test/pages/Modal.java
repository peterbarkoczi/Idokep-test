package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class Modal extends Page {

    @FindBy(id = "close-panel")
    WebElement closeButton;

    @FindBy(css = "div[class='bekuld'] input[type='submit'][value='Belépés']")
    private WebElement submitButton;

    Modal(WebDriver driver) {
        super(driver);
    }


    public WebElement getSubmitButton() {
        return submitButton;
    }

}
