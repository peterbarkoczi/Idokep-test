package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WeatherPage {

    @FindBy(className = "rovid-elorejelzes")
    private WebElement briefForecast;

    @FindBy(className = "idokep_logo")
    private WebElement logo;

    @FindBy(className = "oltozet")
    private WebElement recommendedClothing;

    @FindBy(css = ".login-reg #show-panel[titlee='login-panel']")
    private WebElement loginButton;

    @FindBy(css = ".login-reg div[titlee='login-panel'] a")
    private WebElement logoutButton;

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

    public String getRecommendedClothing() {
        return recommendedClothing.getText();
    }

    public LoginModal clickLogin(String username, String password) {
        loginButton.click();
        return new LoginModal(driver, this, username, password);
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

}