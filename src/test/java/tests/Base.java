package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {
        WebDriver driver;
        WebDriverWait explicitWait;
        Wait fluentWait;
        UnitedMainPage unitedMainPage;
        FlightsPage flightsPage;

        @BeforeMethod
        public void setup() {

            driver = Driver.getDriver();
            explicitWait = new WebDriverWait(driver, Integer.parseInt(ConfigReader.getProperty("explicitWait")));
            fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
            unitedMainPage = new UnitedMainPage(driver);
            flightsPage = new FlightsPage(driver);
        }

        @AfterMethod
        public void teardown() {
            Driver.quitDriver();

        }
}
