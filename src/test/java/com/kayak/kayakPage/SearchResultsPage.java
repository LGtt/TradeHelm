package com.kayak.kayakPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
	
	private WebDriver driver;
	private By lowestPrice;
	private WebElement allElements;
	
	
	

public List <WebElement> getLowestPrice(WebDriver driver){
	    this.driver = driver;
	    lowestPrice = By.xpath("//a[@role = 'button']/div/div/div");

       
	    List <WebElement> allElements = driver.findElements(lowestPrice);
	//	WebElement getPublication = allElements.get(position-1).findElement(By.tagName("div"));
        
		for(WebElement ele :allElements) {
		    System.out.println("Name + Number===>"+ele.getText());
		    String s=ele.getText();
		    s=s.substring(s.indexOf("(")+1, s.indexOf(")"));
		    System.out.println("Number==>"+s);
		}
		
		
		return allElements;
	    
}	
public void setSearchedFor(WebElement allElements) {
    this.allElements = allElements;
}

/*

 //   public WebElement getPublications(int position){
   // 	return getPublication;
    //}


    public WebElement getSearchedFor() {
        return searchedFor;
    }

    public void setSearchedFor(WebElement searchedFor) {
        this.searchedFor = searchedFor;
    }
*/
}

