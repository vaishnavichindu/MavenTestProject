package testng;

import org.testng.annotations.Test;

import utility.DriverManager;

import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Filedownload {
	WebDriver driver;
	String expectedUrl = "https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/";
  @Test
  public void filedownload() throws InterruptedException {
	  driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");
		Thread.sleep(2000);
		WebElement btnDownload = driver.findElement(By.xpath(".//a[text()='chromedriver_win32.zip']"));
		btnDownload.click();
		
		Thread.sleep(7000);;
	
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\git\\MavenTestProject\\MavenTestProject\\src\\main\\resources\\drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.prompt_for_download", 0);
		prefs.put("download.default_directory","D:\\java");
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
