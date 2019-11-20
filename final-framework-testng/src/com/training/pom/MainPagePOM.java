package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPagePOM {
	private WebDriver driver; 
	
	public MainPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//below 2 line code is equivalent to driver.findElement(By.classname="fa-user")
	@FindBy(className= "sign-in")
	public WebElement user_icon;
	
	
}
