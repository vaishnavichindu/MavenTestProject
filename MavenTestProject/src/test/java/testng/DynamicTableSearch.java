package testng;

import org.testng.annotations.Test;

import utility.DriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DynamicTableSearch extends DriverManager{
	int j=1;
	WebDriver driver;
	String expectedUrl = "https://selenium.obsqurazone.com/index.php";
  @Test
  public void search() {
	  WebElement table=driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[4]/a"));
	  table.click();
	  WebElement filter=driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[3]/a"));
	  filter.click();
	  List<WebElement> cols=driver.findElements(By.xpath("//table[@id='example']/thead/tr[1]/th"));
	  System.out.println(cols.size());
	  List<WebElement> rows=driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
	  System.out.println(rows.size());
	  List<WebElement> next=driver.findElements(By.xpath("//div[@id='example_paginate']/span/a"));
	  System.out.println(next.size());
//	ss: 
//	for(int j=2;j<next.size();j++)
//	{
//		  for(int i=1;1<rows.size();i++)
//		  {
//	 
//		  WebElement search=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
//		  
//	      String text=search.getText();
//	     if(text.contains("Dai Rios"))
//	       {
//		  Assert.assertTrue(true,"success");
//		  break ss;
//	       }
//	     else
//	     {
//		    continue;
//	     }
//	 }
//	WebElement nexts=(WebElement) driver.findElements(By.xpath("//div[@id='example_paginate']/span/a["+j+"]"));
//	nexts.click();
//  }
	  ss: 
		for(int j=1;j<=next.size();j++)
			{
			
	  for(int i=1;i<=rows.size();i++)
	  {
	  WebElement search=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
     String text=search.getText();
     System.out.println(text);
     if(text.contains("Jena"))
     {
	  Assert.assertTrue(true);
	  System.out.println(i);
	  break ss;
	  
     }
else
{
	 continue;
}
    
	  }
	  WebElement nexts= driver.findElement(By.xpath("//div[@id='example_paginate']/span/a["+j+"]"));
	  nexts.click();
	  
  }
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
