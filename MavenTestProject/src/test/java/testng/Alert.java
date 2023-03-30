package testng;

import org.testng.annotations.Test;

import pageElements.DropdownPageElements;
import utility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Alert extends DriverManager {
	WebDriver driver;
	String expectedUrl = "https://selenium.obsqurazone.com/index.php";
	DropdownPageElements ob;
	
	
	
  @Test(priority=0,enabled=true)
  public void javaAlert() throws InterruptedException {

	  ob.alert();
  }
  @BeforeTest
	public void beforeTest() {
		DriverManager d = new DriverManager();
		driver = d.launchBrowser("chrome",expectedUrl);
		ob = new DropdownPageElements(driver);
	System.out.println("ss");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
