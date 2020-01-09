package com.codecool.idokep.test.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationPage extends WeatherPage {

    @FindBy(className = "varos-valaszto-gomb-fix")
    WebElement locationButton;

    public LocationPage(WebDriver driver) {
        super(driver);
        this.urlExtension = "elorejelzes/";
    }

    public String getLocation() {
        String buttonText = locationButton.getText();
        return StringUtils.strip(buttonText, " >");
    }

    public String getUrl(String locationName) {
        return this.getUrl() + locationName.replace(" ", "%20");
    }

}
