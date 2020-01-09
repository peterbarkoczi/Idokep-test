package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{

    @FindBy(css = ".login-reg #show-panel[titlee='login-panel']")
    private WebElement loginButton;

    @FindBy(css = ".login-reg div[titlee='login-panel'] a")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
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

    public void login(String username, String password) {
        navigateToHomePage();
        LoginModal loginModal = clickLogin(username, password);
        loginModal.login();
    }

}
