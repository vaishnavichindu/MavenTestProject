package testng;

import org.testng.annotations.Test;

import pageElements.DropdownPageElements;
import utility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class CheckBoxest {
	WebDriver driver;
	String expectedUrl = "https://selenium.obsqurazone.com/index.php";
	DropdownPageElements ob;
	

@Test(priority = 0, enabled = true)
  public void TestCheckBox() throws InterruptedException {
	ob.inputforclick();
	ob.checkBox();
	
  }
@Test(priority = 1, enabled = true)
public void TestRadioButton() throws InterruptedException {
	
	ob.radioButton();
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
