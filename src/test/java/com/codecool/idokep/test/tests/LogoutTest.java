package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest {

    @BeforeEach
    public void setup() {
        homePage = new HomePage(driver);
        homePage.login(username, password);
    }

    @Test
    public void testSuccessfulLogout() {
        homePage.logout();
        Assertions.assertTrue(homePage.isLoginButtonDisplayed());
    }

}
