package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @FindBy(className = "rovid-elorejelzes")
    WebElement briefForecast;

    @FindBy(className = "idokep_logo")
    WebElement logo;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        driver.get(baseUrl);
    }

    public String getBriefForecast() {
        return briefForecast.getText();
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }
}
