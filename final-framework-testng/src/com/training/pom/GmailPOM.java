package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPOM {
	private WebDriver driver; 
	
	public GmailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//below 2 line code is equivalent to driver.findElement(By.classname="fa-user")
	//@FindBy(className= "fa-user")
	//private WebElement user_icon;
	
	@FindBy(className="BHzsHc")
	public WebElement useanotheracc;
	
	@FindBy(xpath="//input[@name='identifier']")                 //(id="identifierId")
	public WebElement gmailid;
	
	@FindBy(xpath="//span[@class='RveJvd snByac'])")
	public WebElement nextbtn;
	
	@FindBy(xpath="//input[@class='whsOnd zHQkBf']")
	public WebElement password;
	
	@FindBy(xpath="//*[@class='zF']")
	public List<WebElement> unreademails;
	
	
}
