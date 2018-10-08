package com.kayak.kayakPage;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarsPage {
	
	private WebDriver driver;
	//placeholder?
	private By locationDisplay;
	private By sanFransisco = By.name("San Francisco");
    
   private By inputLocationDisplay;
   private By inputLocationSearch;
   private By airportSFO; 
   private By inputIniDate;
   private By inputIniTime;
   private By inputEndDate;
   private By inputEndTime;
   private By searchSubmit;
   private By pickCity;

 public void SearchForCar(WebDriver driver){
    this.driver = driver;
    sanFransisco = By.name("San Francisco");
    locationDisplay = By.className("_bpY _q5 _eY _bxO _v _pJ _w _y _q _q4 _s _lA _n _byR");
    inputLocationDisplay = By.xpath("//*[ends-with(@id,'-pickup-display')]");
    inputLocationSearch = By.name("pickup");
    airportSFO = By.id("ap-SFO/13852");
    inputIniDate = By.xpath("//*[ends-with(@id,'-pickup-date-input')]");
    inputIniTime = By.xpath("//*[ends-with(@id,'-pickup-date-time')]");
    inputEndDate = By.xpath("//*[ends-with(@id,'-dropoff-date-input')]");
    inputEndTime = By.xpath("//*[ends-with(@id,'-dropoff-date-time')]");
    searchSubmit = By.xpath("//*[ends-with(@id,'-submit')]");
    pickCity = By.name("pickupcity");
    

 }

   public void go(WebDriver driver) {
        driver.navigate().to("http://www.kayak.com/cars");
    }

    public void searching(String query) {
       
    	//((WebElement) inputLocationDisplay).click();
    	//assertTrue(((WebElement) pickCity).isDisplayed());
        driver.findElement(locationDisplay).click();
    	driver.findElement(pickCity).sendKeys(query);
    	//((WebElement) pickCity).sendKeys(query);
    	//((WebElement) airportSFO).click();
    	//((WebElement) inputLocationSearch).submit();
        driver.findElement(airportSFO).click();
        driver.findElement(inputLocationSearch).submit();
        
    }

}
