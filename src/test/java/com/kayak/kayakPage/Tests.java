package com.kayak.kayakPage;

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
//      driver.get("http://www.google.com/xhtml");
        driver.manage().window().maximize();
        
        
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("ChromeDriver");
//        searchBox.submit();
//        Thread.sleep(5000);  // Let the user actually see something!
//        driver.quit();
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
    
    
    
    
    
  
    public void goToSite() {

    	//Testing if the Site URL and loading are OK
        CarsPage carsPage = PageFactory.initElements(driver, CarsPage.class);
        carsPage.go(driver);
        Reporter.log("Navigate to Site");

        Assert.assertEquals(driver.getTitle(), "Encuentra ofertas de alquiler de autos | KAYAK");
        Reporter.log("Site Confirmation");
        
        //search
        
    }


    @Test
    public void search() {

    	//Go to the Cars page
    	CarsPage carsPage = new CarsPage();
    	
    	driver.navigate().to("http://www.kayak.com/cars");
        Reporter.log("Navigate to Site");
        //Do the Search in the site
        carsPage.searching("SFO");
        Reporter.log("Searching in the Site");
        
        
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
