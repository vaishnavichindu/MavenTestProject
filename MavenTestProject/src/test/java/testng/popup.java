package testng;

import org.testng.annotations.Test;

import pageElements.DropdownPageElements;
import utility.DriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class popup {
	WebDriver driver;
	String expectedUrl = "https://demo.guru99.com/popup.php";
	DropdownPageElements ob;
  @Test(priority=0,enabled=true)
  public void popups_001() {
	  driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();			
		
      String MainWindow=driver.getWindowHandle();		
      		
      // To handle all new opened window.				
          Set<String> s1=driver.getWindowHandles();		
      Iterator<String> i1=s1.iterator();		
      		
      while(i1.hasNext())			
      {		
          String ChildWindow=i1.next();	
System.out.println("hiii");	
          		
          if(!MainWindow.equalsIgnoreCase(ChildWindow))			
          {    		
               
                  // Switching to Child window
                  driver.switchTo().window(ChildWindow);	                                                                                                           
                  driver.findElement(By.name("emailid"))
                  .sendKeys("gaurav.3n@gmail.com");                			
                  
                  driver.findElement(By.name("btnLogin")).click();			
                               
			// Closing the Child Window.
                      driver.close();		
          }		
      }		
      // Switching to Parent window i.e Main Window.
          driver.switchTo().window(MainWindow);
	  
  }
  @BeforeTest
	public void beforeTest() {
		DriverManager d = new DriverManager();
		driver = d.launchBrowser("chrome",expectedUrl);
		ob = new DropdownPageElements(driver);

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
