package pagepackage;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import genrics.BaseTest;
import genrics.WebDriverCommonLib;

public class Flight_Booking extends BaseTest {

	@FindBy(xpath="//span[text()=' Flights ']")WebElement Flights;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchView_RoundTrip") WebElement Round_Trip;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")WebElement Departure;
	@FindBy(xpath="//a[@text='Mumbai (BOM)']") WebElement City1;
    @FindBy(xpath="//option[text()='INR']")WebElement Currency;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT") WebElement ArrivalCity;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT") WebElement To;
	@FindBy(xpath="//a[@class='ui-state-default' and @data-date='28']") WebElement Depart_Date;
	@FindBy(id="custom_date_picker_id_2") WebElement Return_Date;
	@FindBy(xpath="//a[@class='ui-state-default' and @data-date='30']") WebElement date2;
	@FindBy(id="divpaxinfo") WebElement Passenger;
	@FindBy(name="ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_ADT") WebElement Adult_DropDown;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD") WebElement Child_DropDown;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit") WebElement Search;
	@FindBy(xpath="//table[@id='availabilityTable0']/descendant::span[@class='bound-city uppercase']")WebElement DEPARTURE_FLIGHT;




	public Flight_Booking(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}




	public void book_Spicejet_com() throws InterruptedException, AWTException 

	{

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebDriverCommonLib wd=new WebDriverCommonLib();
		Actions as=new Actions(driver);
		Robot rb=new Robot();


		Flights.click();
		Round_Trip.click();

		wd.javaScript(0, 100);

		//Destination Part
		Departure.click();
		as.moveToElement(City1).click().build().perform();

		To.sendKeys("del");
		wd.wait(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		//Travel Date Part	
		Depart_Date.click();
		wd.wait(1000);

		if (Return_Date.isEnabled()==true) {
			System.out.println("It's a round trip");	
		}
		else {

			System.out.println("Its Not a round trip");
			Assert.assertTrue(false);
		}

		Return_Date.click();
		date2.click();

		//Passenger Part	
		Passenger.click();
		wd.selectTheOptionOfDropdown(Adult_DropDown, 2);
		Thread.sleep(1000);
		wd.selectTheOptionOfDropdown(Child_DropDown, 2);
		
		//Currency Validation
		if (Currency.isDisplayed()==true) {
			
			System.out.println("Indian Currency Selected");
		}
		else {
			System.out.println("Other than Indian Currency Selected");
			Assert.assertTrue(false);
		}

		
		Search.click();
		
		String title = driver.getTitle();

		//Verification Part	
		Assert.assertEquals(title.contains("Cheap Air Tickets Online, International Flights to India, Cheap International Flight Deals | SpiceJet Airlines"), true);
		Assert.assertEquals(DEPARTURE_FLIGHT.isDisplayed(), true);



	}

}
