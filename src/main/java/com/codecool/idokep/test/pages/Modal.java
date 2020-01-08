package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class Modal {

    @FindBy(id = "close-panel")
    WebElement closeButton;

    @FindBy(css = "#lightbox-panel input[type='submit']")
    WebElement submitButton;

}
