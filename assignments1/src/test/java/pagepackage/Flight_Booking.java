package pagepackage;




import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import genrics.BaseTest;
import genrics.WebDriverCommonLib;

public class Flight_Booking extends BaseTest {
	
	@FindBy(xpath="//span[text()=' Flights ']")private WebElement Flights;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchView_RoundTrip")private WebElement Round_Trip;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")private WebElement DepartureCity;
	@FindBy(xpath="//a[text()=' Mumbai (BOM)']")private WebElement City1;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT")private WebElement ArrivalCity;
	@FindBy(xpath="//a[text()=' Delhi (DEL)']")private WebElement City2;
	@FindBy(xpath="//a[@class='ui-state-default' and @data-date='28']")private WebElement Depart_Date;
	@FindBy(id="custom_date_picker_id_2")private WebElement Return_Date;
	@FindBy(xpath="//a[@class='ui-state-default' and @data-date='30']")private WebElement date2;
	@FindBy(id="divpaxinfo")private WebElement Passenger;
	@FindBy(name="ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_ADT")private WebElement Adult_DropDown;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD")private WebElement Child_DropDown;
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit")private WebElement Search;
	@FindBy(xpath="//table[@id='availabilityTable0']/descendant::span[@class='bound-city uppercase']")private WebElement DEPARTURE_FLIGHT;
	
	public Flight_Booking(WebDriver driver) 
    {
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getFlights() {
		return Flights;
	}


	public WebElement getRound_Trip() {
		return Round_Trip;
	}



	public WebElement getDepartureCity() {
		return DepartureCity;
	}



	public WebElement getCity1() {
		return City1;
	}


	public WebElement getArrivalCity() {
		return ArrivalCity;
	}


	public WebElement getCity2() {
		return City2;
	}


	public WebElement getDepart_Date() {
		return Depart_Date;
	}


	public WebElement getReturn_Date() {
		return Return_Date;
	}


	public WebElement getDate2() {
		return date2;
	}


	public WebElement getPassenger() {
		return Passenger;
	}


	public WebElement getAdult_DropDown() {
		return Adult_DropDown;
	}


	public WebElement getChild_DropDown() {
		return Child_DropDown;
	}


	public WebElement getSearch() {
		return Search;
	}


	public WebElement getDEPARTURE_FLIGHT() {
		return DEPARTURE_FLIGHT;
	}





	public void book_Spicejet_com() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebDriverCommonLib wd=new WebDriverCommonLib();
		Flights.click();
		Round_Trip.click();
		wd.javaScript(0, 100);
		DepartureCity.click();
		City1.click();
		ArrivalCity.click();
		City2.click();
		Depart_Date.click();
		Thread.sleep(2000);
		Return_Date.click();
		date2.click();
		Passenger.click();
		wd.selectTheOptionOfDropdown(Adult_DropDown, 2);
		Thread.sleep(2000);
		wd.selectTheOptionOfDropdown(Child_DropDown, 2);
		Search.click();
		
		Assert.assertEquals(DEPARTURE_FLIGHT.isDisplayed(), true);
		
		
		
		
	}

}
