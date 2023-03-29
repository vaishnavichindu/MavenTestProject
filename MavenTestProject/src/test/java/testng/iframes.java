package testng;

import org.testng.annotations.Test;

import pageElements.DropdownPageElements;
import utility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class iframes {
	WebDriver driver;
	String expectedUrl="https://www.w3schools.com/html/html_iframe.asp";
  @Test
  public void f() {
	  WebElement iframe=driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/iframe"));
	  driver.switchTo().frame(iframe);
	  driver.findElement(By.xpath("//*[@id=\"topnav\"]/div/div[1]/a[5]")).click();
	  driver.switchTo().defaultContent();
  }

  @BeforeTest
 	public void beforeTest() {
 		DriverManager d = new DriverManager();
 		driver = d.launchBrowser("chrome",expectedUrl);
 		

 	}

 	@AfterTest
 	public void afterTest() {
 		driver.close();
 	}
}
