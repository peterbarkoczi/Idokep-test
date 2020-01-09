package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.HomePage;
import com.codecool.idokep.test.pages.LoginModal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LoginTest extends BaseTest {
    private HomePage homePage;

    @BeforeEach
    void setupTest() {
        homePage = new HomePage(driver);
    }

    @ParameterizedTest
    @MethodSource("getCredentialsForLoginTests")
    void loginTest(String username, String password, boolean expectedResult) {
        homePage.login(username, password);
        Assertions.assertEquals(expectedResult, homePage.isLogoutButtonDisplayed());
    }

    private Stream<Arguments> getCredentialsForLoginTests() {
        return Stream.of(
                Arguments.of(username, password, true),
                Arguments.of(username.toUpperCase(), password, false),
                Arguments.of(username, password.toUpperCase(), false),
                Arguments.of("Username", password, false),
                Arguments.of(username, "password", false),
                Arguments.of("", "", false)
        );
    }

}
