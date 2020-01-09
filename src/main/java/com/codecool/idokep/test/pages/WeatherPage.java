package com.codecool.idokep.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class WeatherPage extends Page {

    /*
     * MAIN MENU ITEMS
     */
    @FindBy(id = "eloreoldal")
    WebElement forecastMenu;

    public WeatherPage(WebDriver driver) {
        super(driver);
    }

    public void selectMenu(WebElement mainMenuItem, String subMenuText) {
        hoverOver(mainMenuItem);
        WebElement menuDropDown = mainMenuItem.findElement(By.xpath("./.."));
        List<WebElement> subMenuItems = menuDropDown.findElements(By.tagName("a"));
        for (WebElement subMenuItem : subMenuItems) {
            if (subMenuItem.getText().equals(subMenuText)) {
                subMenuItem.click();
            }
        }
    }

    public void selectSubMenuInForecastMenu(String subMenu) {
        selectMenu(forecastMenu, subMenu);
    }
}
