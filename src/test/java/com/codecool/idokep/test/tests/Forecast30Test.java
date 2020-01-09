package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.Forecast30Page;
import com.codecool.idokep.test.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Forecast30Test extends BaseTest {
    Forecast30Page forecast30Page;

    @BeforeEach
    public void setup() {
        homePage = new HomePage(driver);
        forecast30Page = new Forecast30Page(driver);
        homePage.load();
    }

    @Test
    public void test30DayForecastHasValidValuesFor30Days() {
        homePage.selectSubMenuInForecastMenu("30 napos előrejelzés");
        Assertions.assertEquals(30, forecast30Page.countMaxTemperatures());
        Assertions.assertEquals(30, forecast30Page.countMinTemperatures());
    }

}