package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class NewPropertiesPOM {
private WebDriver driver; 
	
	public NewPropertiesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(className="wp-menu-name")
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement propertiesoption;
	
	@FindBy(linkText="Add New")
	private WebElement addnew;
	
	@FindBy(id="title")
	private WebElement entertitle;
	
	@FindBy(id="editable-post-name")
	private WebElement titleinlink;
	
	@FindBy(xpath="//button[contains(text(),'Text')]")
	private WebElement texttab;
	
	@FindBy(id="content")
	private WebElement textbox;
	
	@FindBy(className="word-count")
	private WebElement wordcount;
	
	public void clickproperties() {
		
		try {
			this.propertiesoption.click(); 
			String title = driver.getTitle();
			Assert.assertEquals(title,"Properties ‹ Real Estate — WordPress");
			Reporter.log("All Properties page is open.");
			addnew.isDisplayed();
			Reporter.log("Add New Button is available.");
		}
		catch(AssertionError e){
			Reporter.log("Assertion error is" + e +"." );
		}
		catch(NoSuchElementException e) {
			Reporter.log("Element not found error is" + e +"." );
		}
		
	}
	
	public void clickaddnew() {
		try {
		this.addnew.click(); 
		String title = driver.getTitle();
		Assert.assertEquals(title,"Add Property ‹ Real Estate — WordPress");
		Reporter.log("Add new property page is open.");
		
		}
		catch(AssertionError e){
			Reporter.log("Assertion error is" + e +"."  );
		}
		catch(NoSuchElementException e) {
			Reporter.log("Element not found error is" + e +"." );
		}
	}
	
	public void sendtitle() {
		try {
			this.entertitle.sendKeys("new launch");
			this.texttab.click();
			this.titleinlink.isDisplayed();
			Reporter.log("Entered credentials in Enter title textbox should are displayed.");
		}
		catch(NoSuchElementException e) {
			Reporter.log("Element not found error is" + e +"." );
	}
	}
	
	public void sendtotexttab() throws InterruptedException {
		try {
		
		this.textbox.sendKeys("new launch");
		Thread.sleep(2000);
		String count = this.wordcount.getText();
		System.out.println(count);
		int num = Integer.parseInt(count);
		if(num==2)
		{
			Reporter.log("Entered credentials in textbox should are displayed.");
		}
		else
		{
			Reporter.log("Entered credentials in textbox should are not displayed.");
		}
		}
		catch(NoSuchElementException e) {
			Reporter.log("Element not found error is" + e +".");
		}
	}
}
