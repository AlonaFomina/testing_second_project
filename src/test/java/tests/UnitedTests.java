package tests;


import com.sun.deploy.util.Waiter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitedTests extends Base{

    @Test(priority = 1,description = "Test Case 1: Validate \"Main menu\" navigation items")
    public void testNavigationItems(){
        driver.get("https://www.united.com/en/us");

        String[] expectedManuList = {"BOOK","MY TRIPS","TRAVEL INFO","MILEAGEPLUS® PROGRAM", "DEALS","HELP" };
        for (int i = 0; i < unitedMainPage.mainManuList.size(); i++) {
            assertEquals(unitedMainPage.mainManuList.get(i).getText(),expectedManuList[i]);
            assertTrue(unitedMainPage.mainManuList.get(i).isDisplayed());
        }
    }

    @Test(priority = 2,description = "Test Case 2: Validate \"Book travel menu\" navigation items")
    public void validateBookTravelNavigationItems(){
        driver.get("https://www.united.com/en/us");
        String[]expectedBookTravelManu = {"Book", "Flight status","Check-in","My trips"};
        for (int i = 0; i <expectedBookTravelManu.length ; i++) {
            assertTrue(unitedMainPage.bookTravelManu.get(i).isDisplayed());
            assertEquals(unitedMainPage.bookTravelManu.get(i).getText(), expectedBookTravelManu[i]);
        }
    }

    @Test(priority = 3,description = "Test Case 3: Validate \"Round-trip\" and \"One-way\" radio buttons")
    public void testAndValidateRadioButtons() {
        driver.get("https://www.united.com/en/us");
        //(0) - for text
        //(1) - for checking
        //(2) - for clicking
       assertEquals(unitedMainPage.roundTripButtonsList.get(0).getText(),"Roundtrip");
       assertEquals(unitedMainPage.oneWayButtonsList.get(0).getText(),"One-way");
       assertTrue(unitedMainPage.roundTripButtonsList.get(2).isEnabled());
       assertTrue(unitedMainPage.oneWayButtonsList.get(2).isEnabled());
       assertTrue(unitedMainPage.roundTripButtonsList.get(1).isSelected());
       unitedMainPage.oneWayButtonsList.get(2).click();
       assertTrue(unitedMainPage.oneWayButtonsList.get(1).isSelected());
       assertTrue(!unitedMainPage.roundTripButtonsList.get(1).isSelected());
    }

    @Test(priority = 4,description = "Test Case 4: Validate \"Book with miles\" and \"Flexible dates\" checkboxes")
    public void validateCheckBoxes() throws InterruptedException {
        driver.get("https://www.united.com/en/us");
        assertTrue(unitedMainPage.bookingWithMilesLabel.isDisplayed());
        assertTrue(unitedMainPage.flexibleDatesLabel.isDisplayed());

        assertTrue(!unitedMainPage.bookWithMilesInput.isSelected()
                &&  unitedMainPage.bookWithMilesInput.isEnabled());
        assertTrue(!unitedMainPage.flexibleDatesInput.isSelected()
                &&  unitedMainPage.flexibleDatesInput.isEnabled());

        unitedMainPage.flexibleDatesLabel.click();
        unitedMainPage.bookingWithMilesLabel.click();

        explicitWait.until(ExpectedConditions.elementToBeSelected(unitedMainPage.bookWithMilesInput));
        explicitWait.until(ExpectedConditions.elementToBeSelected(unitedMainPage.flexibleDatesInput));
        assertTrue(unitedMainPage.bookWithMilesInput.isSelected());
        assertTrue(unitedMainPage.flexibleDatesInput.isSelected());
    }

    @Test(priority = 5,description = "Test Case 5: Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)")
    public void validateDeparture(){
        driver.get("https://www.united.com/en/us");
        unitedMainPage.oneWayButtonsList.get(1).click();

        unitedMainPage.fromInputBox.clear();
        unitedMainPage.fromInputBox.sendKeys("Chicago, IL, US (ORD)");
        unitedMainPage.toInputBox.clear();
        unitedMainPage.toInputBox.sendKeys("Miami, FL, US (MIA)");
        unitedMainPage.confirmToFly.click();
        unitedMainPage.dateOfFly.clear();
        unitedMainPage.dateOfFly.sendKeys("Jan 30");
        unitedMainPage.numberOfTravelersButton.click();
        unitedMainPage.numbersOfTravelersInput.sendKeys("2");
        unitedMainPage.typeOfFly.click();
        unitedMainPage.businessClass.click();
        unitedMainPage.findFlightsButton.click();

        assertEquals(flightsPage.departureInfo.getText(),"Depart: Chicago, IL, US to Miami, FL, US");


    }
}
