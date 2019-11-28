package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test; 

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.GmailPOM;
import com.training.pom.LoginPOM;
import com.training.pom.NewLaunchPOM;
import com.training.pom.NewPropertiesPOM;
import com.training.pom.RegisterPOM;
//import com.training.pom.properties;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealestateMediumTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPage;
	private NewPropertiesPOM propertiespom;
	private static Properties properties;
	private ScreenShot screenShot;
	private NewLaunchPOM newlaunchpage;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void aasetUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		propertiespom = new NewPropertiesPOM(driver);
		loginPage = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		newlaunchpage = new NewLaunchPOM(driver);
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Reporter.log("Url is open.");
	}
	
	@BeforeMethod
	public void adminLogin() {
		loginPage.clickusericon();
		loginPage.sendUserName(properties.getProperty("AdminID"));
		loginPage.sendPassword(properties.getProperty("Adminpwd"));
		loginPage.clickLoginBtn();
		loginPage.verifyadminlogin();		
		Reporter.log("Admin logged in successfully,");
		screenShot.captureScreenShot("screenshots/AdminLogin");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

//	To verify whether application allows admin to add new property with all details	
	@Test(enabled=false,priority=1)
 	public void RETC_031() throws Exception {
		propertiespom.clickproperties();
		propertiespom.clickaddnew();
		propertiespom.sendtitle();
		propertiespom.sendtotexttab();
		screenShot.captureScreenShot("screenshots/newproperty");
		
	}	
	
	@Test(enabled=true,priority=2)
	public void RETC_032() {
		newlaunchpage.clickrealestateicon();
		newlaunchpage.clicknullamapartment();
		newlaunchpage.clicknext();
		newlaunchpage.sendname("selenium");
		newlaunchpage.sendemail("selenium@gmail.com");
		newlaunchpage.sendsubject("apartment");
		newlaunchpage.sendmessage("looking for apartment");
		newlaunchpage.clicksend();
		newlaunchpage.sendamount("40000");
		newlaunchpage.senddownpayment("2000");
		newlaunchpage.sendloanterm("2");
		newlaunchpage.sendinterestrate("5");
		newlaunchpage.clickcalculate();
	}

	@Test(enabled=false,priority=3)
	public void RECT_033() throws Exception {
		propertiespom.clickproperties();
		propertiespom.clickaddnew();
		propertiespom.sendtitle();
		propertiespom.sendtotexttab();
		//screenShot.captureScreenShot("screenshots/newproperty");
		propertiespom.clickpublish();
		propertiespom.clickallproperties();
	}
}
