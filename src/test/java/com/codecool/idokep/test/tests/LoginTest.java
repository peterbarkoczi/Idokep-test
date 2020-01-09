package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.HomePage;
import com.codecool.idokep.test.pages.LoginModal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    private HomePage homePage;

    @BeforeEach
    public void setupTest() {
        homePage = new HomePage(driver);
    }

    @Test
    public void loginTest() {
        homePage.navigateToHomePage();
        homePage = new HomePage(driver);
        LoginModal loginModal = homePage.clickLogin(username, password);
        loginModal.login();
        Assertions.assertTrue(homePage.isLogoutButtonDisplayed());
    }

}
