package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.Alert;

import com.google.common.io.Files;

public class DriverManager {
	 WebDriver driver;	
	 public void scrolltoElement(WebElement element,WebDriver driver) {
			
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		}
	 public void scrolltowindow(WebDriver driver)
	 {
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
	 }
	 
	public WebDriver launchBrowser(String browser, String url)
	{
		
		if(browser.equals("chrome"))
		{
		 System.setProperty("webdriver.chorme.driver", "C:\\Users\\user\\git\\MavenTestProject\\MavenTestProject\\src\\main\\resources\\drivers\\chormedriver.exe");
			driver =new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
             driver.get(url);
			
			driver.manage().window().maximize();
		
		}
		if(browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\git\\MavenTestProject\\MavenTestProject\\src\\main\\resources\\drivers\\msedgedriver.exe");
			driver =new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.get(url);
				
				driver.manage().window().maximize();
				
		}
		if(browser.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\git\\MavenTestProject\\MavenTestProject\\src\\main\\resources\\drivers\\geckodriver.exe");
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get(url);
			 driver.manage().window().maximize();
	          
	       
		}
		return driver;
		
			
	}
	
	public void click(By value) {
		
		WebElement element = driver.findElement(value);
		element.click();
	}
	public String getText(By value)
	{
		WebElement message=driver.findElement(value);
		String msg=message.getText();
		return msg;
	}
	public void sendKeys(By value,String input)
	{
		WebElement element=driver.findElement(value);
		element.sendKeys(input);
	}
	public void click(WebElement element) {
		
		
		element.click();
	}
	public void sendKeys(WebElement element,String input) {
		
		element.sendKeys(input);
	}
	public String getText(WebElement message)
	{
	
		String msg=message.getText();
		return msg;
	}
	public void dropdown(WebElement element,int byIndex) throws InterruptedException
	{
		Select obj=new Select(element);
		boolean re = obj.isMultiple();
		Assert.assertEquals(false, re);
		Thread.sleep(3000);
		obj.selectByIndex(byIndex);
		
	}
	public void dropdown(WebElement element,String byValue) throws InterruptedException
	{
		Select obj=new Select(element);
		boolean re = obj.isMultiple();
		Assert.assertEquals(false, re);
		Thread.sleep(3000);
		obj.selectByValue(byValue);
		
	}
	public void dropdownByVisibleText(WebElement element,String byVisibleText) throws InterruptedException
	{
		Select obj=new Select(element);
		boolean re = obj.isMultiple();
		Assert.assertEquals(false, re);
		Thread.sleep(3000);
		obj.selectByVisibleText(byVisibleText);
		
	}
	public void dropdownMultiple(WebElement element,int byIndex1,int byIndex2) throws InterruptedException
	{
		Select obj1 = new Select(element);

		if (obj1.isMultiple()) {

			Thread.sleep(3000);
			obj1.selectByIndex(byIndex1);
			Thread.sleep(3000);
			obj1.selectByIndex(byIndex2);
			Thread.sleep(3000);
		
	}
		
}
	public void screenshot() throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file
		

          File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
              
          String filename="screenshots".concat(new SimpleDateFormat("yyyyMMddhhmmssms'.txt'").format(new Date()));
          File DestFile=new File("C:\\Users\\user\\git\\MavenTestProject\\MavenTestProject\\src\\test\\resources\\screenshot\\"+filename+".png");
                //Copy file at destination

           FileHandler.copy(SrcFile, DestFile);
		
	}
	public void Alert(WebDriver driver,String action,String value)
	{
		// Switching to Alert        
	       Alert alert = driver.switchTo().alert();		
	       	alert.sendKeys(value);
	       	switch(action)
	       	{
	       	case "accept":alert.accept();
	       					break;
	       	case "dismiss":alert.dismiss();
				break;
				default:System.out.println("invalid entry");
	       					
	       	}
	       	
	       // Capturing alert message.    
	      // String alertMessage= driver.switchTo().alert().getText();
	}
	public void Alert(WebDriver driver,String action)
	{
		// Switching to Alert        
	       Alert alert = driver.switchTo().alert();		
	       	switch(action)
	       	{
	       	case "accept":alert.accept();
	       					break;
	       	case "dismiss":alert.dismiss();
				break;
				default:System.out.println("invalid entry");
	       					
	       	}
	       	
	       // Capturing alert message.    
	      // String alertMessage= driver.switchTo().alert().getText();
	}

}
