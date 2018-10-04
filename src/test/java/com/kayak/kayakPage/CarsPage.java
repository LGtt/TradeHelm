package com.kayak.kayakPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarsPage {
	
//	@FindBy[ends-void with(@id, "c8QHJ-pickup-display")]
//	private WebElement locationDisplay;
//placeholder?
	@FindBy(css = "_bpY _q5 _eY _bxO _v _pJ _w _y _q _q4 _s _lA _n _byR")
	private WebElement locationDisplay;
	
    @FindBy(name = "pickup")
    private WebElement linputLocationSearch;
    
  //  @FindBy(name = "San Francisco")
  //  private WebElement AirportSFO;
    
    By inputLocationSearch = By.xpath("//*[ends-with(@id,'_default-create-firstname')]");
   // WebElement CX = driver.findElement(inputLocationSearch);
    
 //   driver.findElement(By.xpath("//*[ends-with(@id,'_default-create-firstname')]"));	
 //  driver.findElement(By.xpath("//*[contains(@id, '_default-create-firstname')]"));
    
    @FindBy(id = "ap-SFO/13852")
    private WebElement SelectAirportSFO;
    
   private By inputIniDate = By.xpath("//*[ends-with(@id,'-pickup-date-input')]");
  //  private WebElement inputIniDate;
    
    @FindBy(id = "Mxjn-pickup-date-time")
    private WebElement inputIniTime;
    
    @FindBy(id = "Mxjn-dropoff-date-input")
    private WebElement inputEndDate;
    
    @FindBy(id = "Mxjn-dropoff-date-time")
    private WebElement inputEndTime;

    @FindBy(id ="Mxjn-submit")
    private WebElement searchSubmit;



    public void go(WebDriver driver) {
        driver.navigate().to("http://www.kayak.com/cars");
    }

    public void searching(String query) {
    	locationDisplay.click();
    	((WebElement) inputLocationSearch).sendKeys(query);
    	((WebElement) inputLocationSearch).submit();
    }

}
