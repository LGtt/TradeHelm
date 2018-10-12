package com.kayak.kayakPage;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Tests {

    WebDriver driver;
  

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    
 //   @BeforeMethod
 // public void testGoogleSearch() {
 //     // Optional, if not specified, WebDriver will search your path for chromedriver.
 //     System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

    
    @AfterMethod 
    public void afterMethod(ITestResult result){
        try
          {
	        if(result.getStatus() == ITestResult.SUCCESS)
	        {
	            System.out.println("TEST SUCCESSFUL");
	        }
	
	        else if(result.getStatus() == ITestResult.FAILURE)
	        {
	            System.out.println("TEST FAILED");
	
	        }
	        
	         else if(result.getStatus() == ITestResult.SKIP ){
	
	    
	        	System.out.println("TEST SKIPED");
	
	        }
          }
        catch(Exception e)
        {
          e.printStackTrace();
        }
   //   driver.quit();

    }
    
    
    
    @Test
    public void search() {

    	//Go to the Cars page
        CarsPage carsPage = PageFactory.initElements(driver, CarsPage.class);
        carsPage.go(driver);
        Reporter.log("Navigate to Site");
        //Verify if the Page is right
        Assert.assertEquals(driver.getTitle(), "Car Rentals: Find Cheap Car Rentals & Rental Car Deals - KAYAK");
        Reporter.log("Site Confirmation");
       
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Do the Search in the site
        carsPage.loadSearchWebElements(driver);
        carsPage.searching("San Francisco");
        Reporter.log("Searching in the Site");
        
    }
    
    @Test
    public void findPrice() {
    
    	SearchResultsPage searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
    	searchResultsPage.getLowestPrice(driver);
    	
    } 	
    	/*
      public void DespuescompletarElSearch(){  
        //Search confirmation
        SearchResultsPage searchPage = PageFactory.initElements(driver, SearchResultsPage.class);
        Assert.assertEquals(driver.getTitle(), "Search | ");
        Reporter.log("Search Site Confirmation");

        //Second Search confirmation
        Assert.assertEquals(searchPage.getSearchedFor().getText(), "Search results");
        Reporter.log("Successful searching confirmation");

        //Get the second Result in the search and click on it
        searchPage.getPublication(driver, 2).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Confirm you are in the Correct publication
        Assert.assertEquals(driver.getCurrentUrl(),
                "http://www.sirsidynix.com/blog/2016/05/09/your-cosugi-compendium-everything-you-need-to-know-about");
        Reporter.log("SuccessFull Publication opening");


    }
*/
}