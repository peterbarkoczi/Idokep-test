package com.codecool.idokep.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Forecast30Page extends WeatherPage {

    @FindBy(className = "min-homerseklet-default")
    List<WebElement> maxTemperatures;

    @FindBy(className = "max-homerseklet-default")
    List<WebElement> minTemperatures;

    private int countTemperatures(List<WebElement> temperatures) {
        int counter = 0;
        for (WebElement temperature : temperatures) {
            try {
                Integer.parseInt(temperature.getText());
                counter++;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return counter;
    }

    public int countMaxTemperatures() {
        return countTemperatures(maxTemperatures);
    }

    public int countMinTemperatures() {
        return countTemperatures(minTemperatures);
    }

    public Forecast30Page(WebDriver driver) {
        super(driver);
    }
}
