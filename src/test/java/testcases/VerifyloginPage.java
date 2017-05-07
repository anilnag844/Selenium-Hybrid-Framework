package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;
import pages.HomePage;
import pages.loginPage;
import utility.Helper;

public class VerifyloginPage {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeMethod
	public void setup(){
	    extent = new ExtentReports("./reports/TestReport.html",true);
		test = extent.startTest("Login Test ", "SLogin sucessfull");
		driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getconfig().getaplicationurl());
		test.log(LogStatus.INFO, "Application is up and runing");
		test.log(LogStatus.PASS, "Login Sucessfull");
	}
	
	@Test
	public void testHomePage() throws InterruptedException{
		loginPage login=PageFactory.initElements(driver, loginPage.class);
		login.userlogin(DataProviderFactory.getExcel().getdata(0, 0, 0), DataProviderFactory.getExcel().getdata(0, 0, 1));
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("pathtest"));
		Thread.sleep(5000);
		
		String val=driver.getTitle();
        System.out.println(val);
		Assert.assertTrue(val.contains("WordPress Demo Install › Log In"));	
		test.log(LogStatus.PASS, "Step details");
		
		
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			String path=Helper.tackscreenshot(driver, result.getName());
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(path));
		}
		
		//BrowserFactory.closebrowser(driver);
		extent.endTest(test);
		extent.flush();
	}
	

}
