package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedMainPage {
    public UnitedMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@role=\"tablist\"]/a")
    public List<WebElement> mainManuList;

    @FindBy(xpath = "//div/ul[@class='app-components-BookTravel-bookTravel__travelNav--3RNBj']/li")
    public List<WebElement> bookTravelManu;

    @FindBy(xpath = "//label[@for='roundtrip']/*")
    public List<WebElement> roundTripButtonsList;
    //(0) - for text
    //(1) - for checking
    //(2) - for clicking
    @FindBy(xpath = "//label[@for='oneway']/*")
    public List<WebElement> oneWayButtonsList;
    //(0) - for text
    //(1) - for checking
    //(2) - for clicking


    @FindBy(css = "#award")
    public WebElement bookWithMilesInput;
    //for checking

    @FindBy(xpath = "//label[@for='award']")
    public WebElement bookingWithMilesLabel;

    @FindBy(css = "#flexibleDates")
    public WebElement flexibleDatesInput;
    //for checking

    @FindBy(xpath = "//label[@for='flexibleDates']")
    public WebElement flexibleDatesLabel;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(css = "#autocomplete-item-0")
    public WebElement confirmToFly;

    @FindBy(id = "DepartDate")
    public WebElement dateOfFly;

    @FindBy(xpath = "//button[@class=\"app-components-PassengerSelector-passengers__passengerButton--w8CX7 app-components-BookFlightForm-bookFlightForm__animatedButton--1UzDj\"]")
    public  WebElement numberOfTravelersButton;

    @FindBy(xpath = "//input[contains(@aria-label, 'Adults')]")
    public WebElement numbersOfTravelersInput;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement findFlightsButton;

    @FindBy(id = "cabinType")
    public WebElement typeOfFly;

    @FindBy(xpath = "(//ul[@aria-labelledby='cabinDescriptor'])/li[3]")
    public WebElement businessClass;


}
