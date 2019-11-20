package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class MyProfilePagePOM {
	private WebDriver driver; 
	String btn;
	public MyProfilePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//below 2 line code is equivalent to driver.findElement(By.classname="fa-user")
	@FindBy(linkText= "Register")
	public WebElement RegisterTab;
	
	@FindBy(id="email")
	public WebElement Email; 
	
	@FindBy(id="first-name")
	public WebElement FirstName;
	
	@FindBy(id="last-name")
	public WebElement LastName; 
	
	@FindBy(className ="register-button")
	public WebElement Registerbtn;
	
	@FindBy(xpath="//div[@class='notification success closeable']")
	public WebElement SuccessNotification;
	
//	@FindBy(className="notification success closeable")
//	public WebElement SuccessNotification;
	
	@FindBy(id="user_login")
	public WebElement username;
	
	@FindBy(id="user_pass")
	public WebElement password;
	
	@FindBy(name="login")
	public WebElement loginbtn;
	
	//@FindBy(linkText=" Lost Your Password?")
	@FindBy(xpath="//a[contains(.,' Lost Your Password?')]")
	public WebElement forgetpassword;
	
//	@FindBy(partialLinkText=" Log Out")
//	public WebElement logoutbtn;
	
	@FindBy(className="sub-nav-title")
	public WebElement manageacc;
	
	@FindBy(xpath="//input[@class='lostpassword-button']")
	public WebElement resetpwd;

	
	public void verifymsg() {
		String msg = SuccessNotification.getText();
		String expmsg= "You have successfully registered to Real Estate. We have emailed your password to the email address you entered.";
		Assert.assertEquals(msg,expmsg);
	}
	
	public void checkmanageacc() {
	boolean visible = manageacc.isDisplayed();
	if (visible==true) {
			System.out.println("Manage account is Visible");
		}
		else{
			System.out.println("Manage account is not Visible");
			}
	}

	
}
