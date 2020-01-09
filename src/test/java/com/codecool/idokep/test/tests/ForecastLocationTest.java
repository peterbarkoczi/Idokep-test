package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.LocationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ForecastLocationTest extends BaseTest {
    LocationPage locationPage;

    @BeforeEach
    public void setup() {
        locationPage = new LocationPage(driver);
    }

    @ParameterizedTest(name = "Test location forecast: {0}")
    @CsvSource({
            "SZEGED",
            "New York",
            "Rio de Janeiro"
    })
    public void testLocationForecast(String location) {
        driver.get(locationPage.getUrl(location));
        Assertions.assertEquals(location.toLowerCase(),
                locationPage.getLocation().toLowerCase());
    }

}

