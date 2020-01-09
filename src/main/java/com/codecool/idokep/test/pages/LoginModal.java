package com.codecool.idokep.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginModal extends Modal {
    private HomePage homePage;
    private String username;
    private String password;

    @FindBy(id = "user")
    private WebElement usernameField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    LoginModal(WebDriver driver, HomePage homePage, String username, String password) {
        super(driver);
        this.homePage = homePage;
        this.username = username;
        this.password = password;
    }

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    private void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    private void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void login() {
        enterUsername(username);
        enterPassword(password);
        passwordField.sendKeys(Keys.ENTER);
    }
}
