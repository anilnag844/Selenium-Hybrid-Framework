package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;
import pages.HomePage;

public class VerifyHomePage {
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getconfig().getaplicationurl());
	}
	
	@Test
	public void testHomePage(){
//		driver=BrowserFactory.getBrowser("firefox");
//		driver.get(DataProviderFactory.getconfig().getaplicationurl());
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		String val=home.gethomescreentitle();
				System.out.println(val);
		Assert.assertTrue(val.contains("WordPress Demo Install › Log In"));	
	}
	
	@AfterMethod
	public void teardown(){
	//	BrowserFactory.closebrowser(driver);
	}
	

}
