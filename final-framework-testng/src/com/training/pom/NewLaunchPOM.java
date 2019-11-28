package com.training.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class NewLaunchPOM {
private WebDriver driver; 
	
	public NewLaunchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="ab-item")
	private WebElement realestateicon;
	
	@FindBy(linkText="New Launch ")
	private WebElement newlaunch;
	
	@FindBy(linkText="Nullam hendrerit Apartments")
	private WebElement apartment;
	
	@FindBy(xpath="//button[@class='slick-arrow']")
	private WebElement nextarrow;
	
	@FindBy(xpath="//input[@name='your-name']")
	private WebElement name;
	
	@FindBy(xpath="//input[@name='your-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='your-subject']")
	private WebElement subject;
	
	@FindBy(xpath="//input[@name='your-message']")
	private WebElement message;
	
	@FindBy(xpath="//input[@value='Send']")
	private WebElement send;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/div/div[2]/div/div[2]/form/div[2]")
	private WebElement msg;
	
	@FindBy(id="amount")
	private WebElement saleprice;
	
	@FindBy(id="downpayment")
	private WebElement downpayment;
	
	@FindBy(id="years")
	private WebElement loanterm;
	
	@FindBy(id="interest")
	private WebElement interestrate;
	
	@FindBy(className="calc-button")
	private WebElement calculate;
	
	@FindBy(className="calc-output")
	private WebElement caloutput;
	
	public void clickrealestateicon() throws NoSuchElementException {
		
		this.realestateicon.click();
		if(driver.getTitle()=="Real Estate") {
			Reporter.log("Website main page is available.");
		}
		else {
			Reporter.log("Bug Found: Website main page is not available.");
		}
	}
	
	public void clicknullamapartment() throws NoSuchElementException {
		Actions act = new Actions(driver);
		act.moveToElement(this.newlaunch);
		this.apartment.click();
		Reporter.log("Details of Nullam hendrerit apartment are displayed.");
		
	}
	
	public void clicknext() throws NoSuchElementException {
		this.nextarrow.click();
		Reporter.log("New image should is loaded");
	}

	public void sendname(String name) {
		this.name.clear();
		this.name.sendKeys(name);
		Reporter.log("Entered details in Your Name textbox of Enquiries window are displayed.");
	}
	
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
		Reporter.log("Entered details in Email textbox of Enquiries window is displayed.");
	}
	
	public void sendsubject(String subject) {
		this.subject.clear();
		this.subject.sendKeys(subject);
		Reporter.log("Entered details in Subject textbox of Enquiries window is displayed.");
	}
	
	public void sendmessage(String message) {
		this.message.clear();
		this.message.sendKeys(message);
	}
	
	public void clicksend() throws NoSuchElementException {
		this.send.click();
		String alertmsg = msg.getAttribute("value");
		String expectedmsg = "Thanks you for your message. It has been sent message is displayed";
		if(alertmsg==expectedmsg) {
			Reporter.log("Expected success message is displayed");
		}
		else {
			Reporter.log("Bug found: Unexpected message" + alertmsg);
		}
	}
	
	public void sendamount(String saleprice) {
		this.saleprice.clear();
		this.saleprice.sendKeys(saleprice);
		Reporter.log("Entered price in Sale Price textbox of Mortgage Calculator is displayed.");
	}
	
	public void senddownpayment(String downpayment) {
		this.downpayment.clear();
		this.downpayment.sendKeys(downpayment);
		Reporter.log("Entered price in Down Payment textbox of Mortgage Calculator is displayed.");
	}
	
	public void sendloanterm(String loanterm) {
		this.loanterm.clear();
		this.loanterm.sendKeys(loanterm);
		Reporter.log("Entered price in Loan Term textbox of Mortgage Calculator is displayed.");
	}
	
	public void sendinterestrate(String interestrate) {
		this.interestrate.clear();
		this.interestrate.sendKeys(interestrate);
		Reporter.log("Entered price in Interest textbox of Mortgage Calculator is displayed.");
	}
	
	public void clickcalculate() throws NoSuchElementException {
		this.calculate.click();
		String expectedoutput = "1667.11 Rs.";
		if (caloutput.getAttribute("value")== expectedoutput) {
			Reporter.log("Monthly Payment: 1667.11 Rs. message is displayed");
		}
		else{
			Reporter.log("Bug Found: Monthly Payment: 1667.11 Rs. message is not displayed");
		}
	}
}
