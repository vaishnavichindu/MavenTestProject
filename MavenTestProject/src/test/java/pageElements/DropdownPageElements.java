package pageElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.DriverManager;

public class DropdownPageElements extends DriverManager {
	WebDriver driver;
	Select obj;
	//DriverManager d;
	public DropdownPageElements(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	//	 d = new DriverManager();
	} 
	
	@FindBy(xpath= "//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a")
	public WebElement inputForm;
	
	@FindBy(xpath= "/html/body/section/div/div/div[1]/div/div/ul/li[4]/a")
	public WebElement select;
	
	@FindBy(id= "single-input-field")
	public WebElement dropdown;
	
	@FindBy(id="multi-select-field")
	public WebElement  dropdown_multiple;
	
	
	@FindBy(id="button-all")
	public WebElement  getSeletced;
	
	@FindBy(xpath="/html/body/section/div/div/div[1]/div/div/ul/li[2]/a")
	public WebElement  checkbox_demo;
	
	@FindBy(id="gridCheck")
	public WebElement  grid_check;
	
	@FindBy(id="message-one")
	public WebElement  message;
	
	@FindBy(xpath="/html/body/section/div/div/div[1]/div/div/ul/li[3]/a")
	public WebElement  radioButton_demo;
	
	@FindBy(id="inlineRadio1")
	public WebElement  radio1;
	
	@FindBy(id="button-one")
	public WebElement  show_SelectedValue;
	
	@FindBy(tagName="a")
	public List<WebElement> list;
	
	@FindBy(id="alert-modal")
	public WebElement alertModel;
	
	@FindBy(xpath="/html/body/section/div/div/div[1]/div/div/ul/li[5]/a")
	public WebElement javaScriptAlert;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[3]/div/div[2]/button")
	public WebElement clickForPrompt;
	
	@FindBy(id="prompt-demo")
	public WebElement alertMessage;
	
	@FindBy(id="uploadfile_0")
	public WebElement uploadpage;
	
	@FindBy(id="terms")
	public WebElement terms;
	
	@FindBy(name="send")
	public WebElement send;
	
	public void inputforclick() throws InterruptedException {
	    click(inputForm);
	}

	
	public void dropdownSelect() throws InterruptedException {
		
		select.click();
		dropdown(this.dropdown,3); 


	}

	public void dropdown_multiple() throws InterruptedException {
		// TODO Auto-generated method stub

		select.click();
		dropdownMultiple(this.dropdown_multiple, 1, 2);
		
		
		
	}
	public void radioButton() throws InterruptedException
	{ 
		click(radioButton_demo);
		Thread.sleep(3000);
		click(radio1);
		Thread.sleep(3000);
		click(show_SelectedValue);
		Thread.sleep(3000);
		String outMessage= getText(message);
		Thread.sleep(3000);
		 if(outMessage.contains("Male"))
		   {
		   Assert.assertTrue(true);
		   }
		   else
		   {
		   Assert.fail("Wrong");
		   }
		
		
	}
	public void checkBox() throws InterruptedException
	{ 
		click(checkbox_demo);
		Thread.sleep(3000);
		click(grid_check);
		
		Thread.sleep(3000);
		String outMessage= getText(message);
		Thread.sleep(3000);
		 if(outMessage.contains("Success - Check box is checked"))
		   {
		   Assert.assertTrue(true);
		   }
		   else
		   {
		   Assert.fail("Wrong");
		   }
	}

	public void linkchecker() {
		// TODO Auto-generated method stub
		for(WebElement w:list)
		{
			System.out.println(w.getText());
		}
		
	}
	public void alert() throws InterruptedException
	{
		click(alertModel);
		  Thread.sleep(3000);
	       click(javaScriptAlert);
	       Thread.sleep(3000);
	      scrolltoElement(clickForPrompt,this.driver);
	      Thread.sleep(3000);
	       click(clickForPrompt);
	       Thread.sleep(3000);
	    Alert(this.driver,"accept","vaishnavi");
	       	String alertMessage=getText(this.alertMessage);
	       
	       if(alertMessage.contains("vaishnavi"))
	       {
	    	   Assert.assertTrue(true);
	    	   System.out.println("passed");
	       }
	       else
	       {
	    	   Assert.fail("not found");
	       }
	       Thread.sleep(3000);
	}
	public void file_upload()
	{
		sendKeys(uploadpage,"‪C:\\Users\\user\\Downloads\\Testing.docx");
		click(terms);
		click(send);
	}
	

}

	

