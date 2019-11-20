package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.GmailPOM;
import com.training.pom.LoginPOM;
import com.training.pom.MainPagePOM;
import com.training.pom.MyProfilePagePOM;
//import com.training.pom.properties;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealestateRegisterTests {

	private WebDriver driver;
	private String baseUrl;
	private MainPagePOM mainPage;
	private GmailPOM gmailPage;
	private MyProfilePagePOM myProfilepage;
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
		mainPage = new MainPagePOM(driver); 
		myProfilepage = new MyProfilePagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		gmailurl = properties.getProperty("gmail");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	
	@Test(enabled=true,priority=1)
 	public void RETC_001() {
		GenericMethods.click(mainPage.user_icon);
		GenericMethods.click(myProfilepage.RegisterTab);
		GenericMethods.type(myProfilepage.Email, properties.getProperty("newuser"));
		GenericMethods.type(myProfilepage.FirstName, properties.getProperty("firstname"));
		GenericMethods.type(myProfilepage.LastName, properties.getProperty("lastname"));
		GenericMethods.click(myProfilepage.Registerbtn);
		screenShot.captureScreenShot("screenshots/Registeruser1");
		try {
			myProfilepage.verifymsg();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Error is "+ e);
		}
		
		screenShot.captureScreenShot("screenshots/Registeruser2");
				
	}	
	
	@Test(enabled=true,priority=2)
	public void RETC_002() {
		//optimized code
		GenericMethods.click(mainPage.user_icon);
		GenericMethods.type(myProfilepage.username, properties.getProperty("userID"));
		GenericMethods.type(myProfilepage.password, properties.getProperty("password"));
		screenShot.captureScreenShot("screenshots/Login1");
		GenericMethods.click(myProfilepage.loginbtn);
		screenShot.captureScreenShot("screenshots/Login2");
		try {
		myProfilepage.checkmanageacc();
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Error is "+ e);
		}
		       
	}

	@Test(enabled=true,priority=3)
	public void RECT_003() {
		GenericMethods.click(mainPage.user_icon);
		GenericMethods.click(myProfilepage.forgetpassword);
		GenericMethods.type(myProfilepage.username, properties.getProperty("userID"));
		GenericMethods.click(myProfilepage.resetpwd);
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
		
		//GenericMethods.click(gmailPage.useanotheracc);
		GenericMethods.type(gmailPage.gmailid, properties.getProperty("guserid"));
		GenericMethods.click(gmailPage.nextbtn);
		GenericMethods.type(gmailPage.password, properties.getProperty("gpwd"));
		GenericMethods.click(gmailPage.nextbtn);
		// below code for checking email received
		for(int i=0;i<gmailPage.unreademails.size();i++){
		    if(gmailPage.unreademails.get(i).isDisplayed()==true){
		        // now verify if we received email form a specific mailer.
		         if(gmailPage.unreademails.get(i).getText().equals(properties.getProperty("mailerid"))){
		            System.out.println("Email recieved form " + properties.getProperty("mailerid"));
		            break;
		        }
		         else{
		            System.out.println("No Email form " + properties.getProperty("mailerid"));
		        }
		    }
		
	}
			
	
	}
}
