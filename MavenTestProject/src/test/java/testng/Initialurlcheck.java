package testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excel.ExcelReader;
import utility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
////////////////////PageObjectModel///////////////////////////////
public class Initialurlcheck extends DriverManager {
	ExcelReader tr = new ExcelReader();
	 String expectedUrl="https://selenium.obsqurazone.com/index.php";
		WebDriver driver;
		By inputform = By.xpath("//*[@id='collapsibleNavbar']/ul/li[2]/a");
		By button = By.id("button-one");
		By message=By.id("message-one");
		By enterMessage=By.id("single-input-field");
		By entervalueA=By.id("value-a");
		By entervalueB=By.id("value-b");
		By getTotal=By.id("button-two");
		By messages=By.id("message-two");
	
		/////////////using data provider//////////
  @Test(priority=0,enabled=true,dataProvider="SearchProvider") 
  public void test_001(String text,String searchKey) throws InterruptedException, IOException
  {
	 
		    click(inputform);
		    
			sendKeys(enterMessage,text);
			
			 click(button);
			 screenshot();

			Thread.sleep(2000);
			String outMessage= getText(message);
			 if(outMessage.contains(text))
			   {
			   Assert.assertTrue(true);
			   }
			   else
			   {
			   Assert.fail("This is failed due to url mismatch");
			   }
			
			 
			  
	  
  }
  
  
  ////////////////getting input from excel///////////////////////////
  
  @Test(priority=1,enabled=false)
  public void excelread_001() throws InterruptedException, IOException 
  {
	  click(inputform);
	    
		sendKeys(enterMessage,tr.excelread(1, 0));
		
		 click(button);
		 screenshot();

		Thread.sleep(2000);
		String outMessage= getText(message);
		 if(outMessage.contains(tr.excelread(1, 0)))
		   {
		   Assert.assertTrue(true);
		   }
		   else
		   {
		   Assert.fail("This is failed due to url mismatch");
		   }
	  
  }
  @Test(priority=2,enabled=false)
  public void test_002() throws InterruptedException, IOException 
  {
	
		
		 sendKeys(entervalueA,"5");
		 Thread.sleep(3000);
		 screenshot();
		sendKeys(entervalueB,"10");
		 Thread.sleep(3000);
	 
	 click(getTotal);
	 
	  String getMessage= getText(messages);
	  if(getMessage.contains("15"))
	   {
	   Assert.assertTrue(true);
	   }
	   else
	   {
	   Assert.fail("This is failed ");
	   }
	  

	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	
	  driver= launchBrowser("firefox",expectedUrl);
	
	 
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  @DataProvider(name="SearchProvider")
  public Object[][] getDataFromDataprovider(){
  return new Object[][] 
  	{
          { "Guru99", "India" },
          { "Krishna", "UK" },
          { "Bhupesh", "USA" }
      };

}
}
