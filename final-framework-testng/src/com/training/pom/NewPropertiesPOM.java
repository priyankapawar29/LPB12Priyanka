package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
	
	@FindBy(id="publish")
	private WebElement publish;
	
//	@FindBy(className="wp-heading-inline")
//	private WebElement editpropertyheading;
	
	@FindBy(linkText="View post")
	private WebElement viewpost;
	
	@FindBy(linkText="All Properties")
	private WebElement allproperties;
	
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
			if(this.titleinlink.isDisplayed()) {
			Reporter.log("Entered credentials in Enter title textbox are displayed.");
			}
			else {
				Reporter.log("Bug: Entered credentials in Enter title textbox are displayed.");
			}
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
			Reporter.log("Entered credentials in textbox are displayed.");
		}
		else
		{
			Reporter.log("Bug: Entered credentials in textbox are not displayed.");
		}
		}
		catch(NoSuchElementException e) {
			Reporter.log("Element not found error is" + e +".");
		}
	}
	
	public void clickpublish() {
		try {
		this.publish.click();
		if(viewpost.isDisplayed()) {
			Reporter.log("View Post is visible.");
		}
		else {
			Reporter.log("Bug: View Post is not visible.");
		}
	}
		catch(NoSuchElementException e) {
			Reporter.log("Element not found error is" + e +".");
		}
	}
	
	public void clickallproperties() {
		try {
		this.allproperties.click();

		List<WebElement> rows = driver.findElements(By.xpath("//tbody[@id='the-list']/tr/td"));
		for(WebElement row:rows)
		{
//			System.out.println(row.getText()); // gives all data in a row.
//          Below line code to get data from columns
//	        System.out.println(row.findElements(By.tagName("td")).get(1).getText());
			String firstentry= row.findElements(By.tagName("td")).get(1).getText();
			if (firstentry=="new launch") {
				Reporter.log("Added property is displayed");
			}
			else {
				Reporter.log("Added property is not displayed");
			}
			
		}
		
		
	}
		catch(NoSuchElementException e) {
			Reporter.log("Element not found error is" + e +".");
		}
	}
}
	
