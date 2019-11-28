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
import com.training.pom.RegisterPOM;
//import com.training.pom.properties;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealestateRegisterTests {

	private WebDriver driver;
	private String baseUrl;
	private GmailPOM gmailPage;
	private LoginPOM loginPage;
	private RegisterPOM registerpage;
	private static Properties properties;
	private ScreenShot screenShot;
	private String gmailurl;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerpage = new RegisterPOM(driver);
		loginPage = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		gmailPage = new GmailPOM(driver);
		gmailurl = properties.getProperty("gmail");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Reporter.log("Url is open.");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	
	@Test(enabled=true,priority=1)
 	public void RETC_001() {
		
		registerpage.clickusericon();
		registerpage.clickRegistertab();
		registerpage.sendEmail(properties.getProperty("newuser"));
		registerpage.sendfirstName(properties.getProperty("firstname"));
		registerpage.sendlastName(properties.getProperty("lastname"));
		registerpage.clickRegisterBtn();
		screenShot.captureScreenShot("screenshots/Registeruser1");
		registerpage.verifymsg();
	
	}	
	
	@Test(enabled=true,priority=2)
	public void RETC_002() {
		
		loginPage.clickusericon();
		loginPage.sendUserName(properties.getProperty("userID"));
		loginPage.sendPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		screenShot.captureScreenShot("screenshots/Login1");
		loginPage.checkmanageacc();
		screenShot.captureScreenShot("screenshots/Login2");
	}

	@Test(enabled=true,priority=3)
	public void RECT_003() {
		loginPage.clickusericon();
		loginPage.clicklostpwd();
		loginPage.sendUserName(properties.getProperty("userID"));
		loginPage.clickresetpwd();
		driver.get(gmailurl); 
		Set<String> winids= driver.getWindowHandles();
		for(String winid:winids)
		{
			driver.switchTo().window(winid);
			String title = driver.getTitle();
			if (title.toLowerCase().contains("gmail"))
			{	
				//System.out.println(title);
				break;
			}
		}
		//gmailPage.clickanotheracc();
		gmailPage.sendUserName(properties.getProperty("guserid"));
		gmailPage.clicknextbtn();
		gmailPage.sendPassword(properties.getProperty("gpwd"));
		gmailPage.clicknextbtn();
		gmailPage.checkemailreceived();
//		For steps below webelements are not available to locate, so below is just logic that can be used.
//		gmailPage.sendPassword(properties.getProperty("password"));
//		gmailPage.resendPassword(properties.getProperty("password"));	
//		loginPage.clickresetpwd();
	}
}
