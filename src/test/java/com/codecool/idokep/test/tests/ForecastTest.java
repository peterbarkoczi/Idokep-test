package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.Forecast30Page;
import com.codecool.idokep.test.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ForecastTest extends BaseTest {
    Forecast30Page forecastPage;

    @BeforeEach
    public void setup() {
        homePage = new HomePage(driver);
        forecastPage = new Forecast30Page(driver);
        homePage.load();
    }

    @Test
    public void test30DayForecastHasValidValuesFor30Days() {
        homePage.selectSubMenuInForecastMenu("30 napos előrejelzés");
        Assertions.assertEquals(30, forecastPage.countMaxTemperatures());
        Assertions.assertEquals(30, forecastPage.countMinTemperatures());
    }

}
