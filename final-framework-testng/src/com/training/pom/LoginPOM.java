package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className= "sign-in")
	private WebElement user_icon;
	
	@FindBy(id="user_login")
	public WebElement username;
	
	@FindBy(id="user_pass")
	public WebElement password;
	
	@FindBy(name="login")
	public WebElement loginbtn;
	
	//@FindBy(linkText=" Lost Your Password?")
	@FindBy(xpath="//a[contains(.,' Lost Your Password?')]")
	public WebElement forgetpassword;
	
	@FindBy(className="sub-nav-title")
	public WebElement manageacc;
	
	@FindBy(xpath="//input[@class='lostpassword-button']")
	public WebElement resetpwd;
	
//	@FindBy(id="login")
//	private WebElement userName; 
//	
//	@FindBy(id="password")
//	private WebElement password;
//	
//	@FindBy(id="formLogin_submitAuth")
//	private WebElement loginBtn; 
	public void clickusericon() {
		this.user_icon.click(); 
	}
	
	public void sendUserName(String userName) {
		this.username.clear();
		this.username.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginbtn.click(); 
	}
	
	public void checkmanageacc() {
		boolean visible = this.manageacc.isDisplayed();
		if (visible==true) {
				Reporter.log("Logged in successfully.");
			}
			else{
				Reporter.log("Not logged in.");
				}
		}
	
	public void clicklostpwd() {
		this.forgetpassword.click(); 
	}
	
	public void clickresetpwd() {
		this.resetpwd.click(); 
	}
	
	public void verifyadminlogin() {
		String title = driver.getTitle();
		Assert.assertEquals(title,"Dashboard ‹ Real Estate — WordPress");
		Reporter.log("Admin dashboard page is open.");
	}
}
