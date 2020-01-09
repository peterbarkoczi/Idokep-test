package com.codecool.idokep.test.tests;

import com.codecool.idokep.test.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    protected String username;
    protected String password;
    protected ChromeDriver driver;
    protected HomePage homePage;

    @BeforeAll
    public void setupTestEnvironment() {
        this.username = System.getenv("IDOKEP_USERNAME");
        this.password = System.getenv("IDOKEP_PASSWORD");
    }

    @BeforeEach
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", getBasePath() + "/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

    public String getBasePath() {
        String basePath;
        try {
            basePath = new File("./").getCanonicalPath();
        } catch (IOException e) {
            basePath = "Driver not found...";
            System.err.println(basePath);
            e.printStackTrace();
        }
        return basePath;
    }

}
