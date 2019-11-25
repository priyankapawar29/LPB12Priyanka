package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class GmailPOM {
	private WebDriver driver; 
	
	public GmailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(className="BHzsHc")
	public WebElement useanotheracc;
	
	@FindBy(xpath="//input[@name='identifier']")               
	public WebElement gmailid;
	
	@FindBy(xpath="//span[@class='RveJvd snByac'])")
	public WebElement nextbtn;
	
	@FindBy(xpath="//input[@class='whsOnd zHQkBf']")
	public WebElement password;
	
	@FindBy(xpath="//*[@class='zF']")
	public List<WebElement> unreademails;
	
	public void clickanotheracc() {
		this.useanotheracc.click(); 
	}
	
	public void sendUserName(String userName) {
		this.gmailid.clear();
		this.gmailid.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	public void clicknextbtn() {
		this.nextbtn.click(); 
	}
	// below code for checking email received
	public void checkemailreceived() {
		for(int i=0;i<unreademails.size();i++){
		    if(unreademails.get(i).isDisplayed()==true){
		        // now verify if we received email form a specific mailer.
		         if(unreademails.get(i).getText().equals("mailerid")){
		            Reporter.log("Email recieved form " + "mailerid");
		            break;
		        }
		         else{
		           Reporter.log("No Email form " + "mailerid");
		           
		        }
		    }
		
	}
	}
}
