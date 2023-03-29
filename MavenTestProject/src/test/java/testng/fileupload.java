package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.*;

import pageElements.DropdownPageElements;
import utility.DriverManager;

public class fileupload extends DriverManager{
	WebDriver driver;
	//String expectedUrl = "https://blueimp.github.io/jQuery-File-Upload/";
	String expectedUrl = "https://demo.guru99.com/test/upload/";

	
	
	@Test(priority=0,enabled=true) 
	public void fileupload_001() 
	{ 
		
		 // enter the file path onto the file-selection input field
		WebElement uploadElement=driver.findElement(By.id("uploadfile_0"));
		uploadElement.sendKeys("C:\\Users\\user\\git\\MavenTestProject\\MavenTestProject\\src\\main\\resources\\ObsqueraStudents.xlsx");

        // check the "I accept the terms of service" check box
       driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
       driver.findElement(By.name("send")).click();
	}

	@Test(priority=1,enabled=false) 
	public void fileupload_002() throws AWTException
	{ 
		

	     //put path to your image in a clipboard
	    
	    WebElement element= driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button"));
	     Actions action = new Actions(driver);
	     action.moveToElement(element).click().build().perform();
	     StringSelection stringSelection = new StringSelection("C:\\whatup.xlsx");
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	        Robot robot = null;
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	        robot.delay(250);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	     
	      // Robot object creation
	    
	}
	@BeforeTest
	
	public void beforeTest() {
		DriverManager d = new DriverManager();
		driver = d.launchBrowser("chrome",expectedUrl);
		

	}

	@AfterTest
	public void afterTest() {
	//	driver.close();
	}
}
