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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.GmailPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
//import com.training.pom.properties;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealestateComplexTests {

	private WebDriver driver;
	private String baseUrl;
	private GmailPOM gmailPage;
	private LoginPOM loginPage;
	private RegisterPOM registerpage;
	private static Properties properties;
	private ScreenShot screenShot;
	private String gmailurl;
	private DBSelectuser dbselectuser;

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
		dbselectuser = new DBSelectuser();
		// open the browser 
		driver.get(baseUrl);
		Reporter.log("Url is open.");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

//  To verify whether application allows multiple users to get registered upon entering valid credentials	
	@Test(enabled=false,priority=1,dataProvider="excel-inputs",dataProviderClass = LoginDataProviders.class)
 	public void RETC_061(String Email, String FirstName, String LastName) {
		
		registerpage.clickusericon();
		registerpage.clickRegistertab();
		registerpage.sendEmail(Email);
		registerpage.sendfirstName(FirstName);
		registerpage.sendlastName(LastName);
		screenShot.captureScreenShot("screenshots/ComplexRegisteruser1");
		registerpage.clickRegisterBtn();
		screenShot.captureScreenShot("screenshots/ComplexRegisteruser2");
		registerpage.verifymsg();
	
	}	
//  To verify whether details entered by user during registration get displayed in database	
	@Test(enabled=false,priority=2)
	public void RETC_062() {
		
		registerpage.clickusericon();
		registerpage.clickRegistertab();
		registerpage.sendEmail(properties.getProperty("userID1"));
		registerpage.sendfirstName(properties.getProperty("firstname"));
		registerpage.sendlastName(properties.getProperty("lastname"));
		screenShot.captureScreenShot("screenshots/Complexretc_062_1");
		registerpage.clickRegisterBtn();
		registerpage.verifymsg();
		screenShot.captureScreenShot("screenshots/Complexretc_062_2");
		dbselectuser.checkuser(properties.getProperty("firstname"));
	}

	@Test(enabled=true,priority=1,dataProvider="excel-inputs1",dataProviderClass = LoginDataProviders.class)
 	public void RETC_063(String Email, String FirstName, String LastName) {
		
		registerpage.clickusericon();
		registerpage.clickRegistertab();
		registerpage.sendEmail(Email);
		registerpage.sendfirstName(FirstName);
		registerpage.sendlastName(LastName);
		screenShot.captureScreenShot("screenshots/ComplexRegisteruser3");
		registerpage.clickRegisterBtn();
		screenShot.captureScreenShot("screenshots/ComplexRegisteruser4");
		registerpage.verifymsg();
	
	}	
}
