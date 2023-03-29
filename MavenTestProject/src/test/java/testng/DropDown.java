package testng;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pageElements.DropdownPageElements;
import utility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DropDown {
	WebDriver driver;
	String expectedUrl = "https://selenium.obsqurazone.com/index.php";
	DropdownPageElements ob;
	@Test(priority=0,enabled=true) 
	public void multipleElements() 
	{ 
		ob.linkchecker();
	}

	@Test(priority = 0, enabled = false)
	public void Test_001() throws InterruptedException {
		
		
		ob.inputforclick();
		ob.dropdownSelect();

	}

	@Test(priority = 1, enabled = false)
	public void Test_002() throws InterruptedException

	{
		
		ob.dropdown_multiple();
		

	}

	@BeforeTest
	@Parameters({"browser"})
	public void beforeTest(@Optional String browser) {
		DriverManager d = new DriverManager();
		driver = d.launchBrowser(browser,expectedUrl);
		ob = new DropdownPageElements(driver);

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}