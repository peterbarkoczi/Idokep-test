package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css = ".login-reg a")
    List<WebElement> allLinksInUserPanel;

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

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void login(String username, String password) {
        navigateToHomePage();
        LoginModal loginModal = clickLogin(username, password);
        loginModal.login();
    }

    public void logout() {
        for (WebElement link : allLinksInUserPanel) {
            if (link.getText().equals("Kijelentkezés")) {
                link.click();
            }
        }
    }

    public List<WebElement> getAllLinksInUserPanel() {
        return allLinksInUserPanel;
    }

}
