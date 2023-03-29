package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageElements.DropdownPageElements;
import utility.DriverManager;

public class testcaseaction {
	WebDriver driver;
	//String expectedUrl = "https://demo.guru99.com/test/drag_drop.html";
	String expectedUrl="http://www.facebook.com/";
	DropdownPageElements ob;
  @Test(priority=0,enabled=true)
  public void actions_001() throws InterruptedException {
	  Actions action = new Actions(driver);
	  WebElement txtUsername = driver.findElement(By.id("email"));

	  Actions builder = new Actions(driver);
//	WebElement  source = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a")); 
//	WebElement  target = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li")); 
//	 action.moveToElement(element).click().build().perform();
//	 action.doubleClick(element).build().perform();
//	 action.clickAndHold(element).release().build().perform();
//	 action.click(element).sendKeys("hello").build().perform();
//	 action.contextClick().build().perform();  
//	 action.dragAndDrop(source,target).build().perform();
//	 Thread.sleep(3000);
	  builder
		.moveToElement(txtUsername)
		.click()
		.keyDown(txtUsername, Keys.SHIFT)
		.sendKeys(txtUsername, "hello")
		.keyUp(txtUsername, Keys.SHIFT)
		.doubleClick(txtUsername)
		.contextClick()
		.build().perform() ;

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
