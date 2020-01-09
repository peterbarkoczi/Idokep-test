package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl;

    public Page(WebDriver driver) {
        this.driver = driver;
        int timeOutInSeconds = 8;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOutInSeconds), this);
        baseUrl = "https://idokep.hu";
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void hoverOver(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    public void clickOn(WebElement webElement) {
        webElement.click();
    }

    public void navigateTo(String extendedUrl) {
        driver.get(baseUrl + extendedUrl);
    }

    public void navigateToHomePage() {
        driver.get(baseUrl);
    }

}