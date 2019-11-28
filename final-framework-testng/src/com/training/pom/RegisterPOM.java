package com.training.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class RegisterPOM {
private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className= "sign-in")
	private WebElement user_icon;
	
	@FindBy(linkText= "Register")
	private WebElement RegisterTab;
	
	@FindBy(id="email")
	private WebElement Email; 
	
	@FindBy(id="first-name")
	private WebElement FirstName;
	
	@FindBy(id="last-name")
	private WebElement LastName; 
	
	@FindBy(className ="register-button")
	private WebElement Registerbtn;
	
	@FindBy(xpath="//div[@class='notification success closeable']")
	private WebElement SuccessNotification;
	
	@FindBy(className="sub-nav-title")
	private WebElement manageacc;
	
	public void clickusericon() {
		this.user_icon.click(); 
		Reporter.log("Login screen is displayed.");
	}
	
	public void clickRegistertab() {
		this.RegisterTab.click(); 
		Reporter.log("Register screen is displayed.");
	}
	
	public void sendEmail(String email) {
		this.Email.clear();
		this.Email.sendKeys(email);
		Reporter.log("Email is entered");
	}
	
	public void sendfirstName(String firstName) {
		this.FirstName.clear();
		this.FirstName.sendKeys(firstName);
		Reporter.log("First name is entered");
	}
	
	public void sendlastName(String lastName) {
		this.LastName.clear();
		this.LastName.sendKeys(lastName);
		Reporter.log("Last name is entered");
	}
	
	public void clickRegisterBtn() {
		this.Registerbtn.click(); 
	}
	
	public void verifymsg() {
		
		String expmsg= "You have successfully registered to Real Estate. We have emailed your password to the email address you entered.";
		try
		{
			String msg = SuccessNotification.getText();
			Assert.assertEquals(msg,expmsg);
		}
		catch(AssertionError e){
			Reporter.log("Test Failed.. Assertion error:  "+ e);
		}
		catch(NoSuchElementException e) {
			Reporter.log("Test Failed.. Element not found error:  "+ e);
		}
		
	}
	
	
}
