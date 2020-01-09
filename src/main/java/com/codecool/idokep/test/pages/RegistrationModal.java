package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationModal extends Modal {

    @FindBy(id = "reguser")
    WebElement usernameField;

    @FindBy(id = "regemail")
    WebElement emailField;

    @FindBy(id = "regpass")
    WebElement passwordField;

    @FindBy(css = ".regform select[name='varos']")
    WebElement locationSelect;

    @FindBy(id = "szabaly")
    WebElement agreeTermsCheckbox;

    public RegistrationModal(WebDriver driver) {
        super(driver);
    }

    protected void fillInputs(String username, String email, String password, String location) {
        fillUsername(username);
        fillEmail(email);
        fillPassword(password);
        selectLocation(location);
        checkAgreeTerms();
    }

    private void fillUsername(String username) {
        fillInput(usernameField, username);
    }

    private void fillEmail(String email) {
        fillInput(emailField, email);
    }

    private void fillPassword(String password) {
        fillInput(passwordField, password);
    }

    private void selectLocation(String location) {
        fillInput(locationSelect, location);
    }

    private void checkAgreeTerms() {
        selectCheckbox(agreeTermsCheckbox);
    }

    private void unCheckAgreeTerms() {
        unSelectCheckbox(agreeTermsCheckbox);
    }

}
