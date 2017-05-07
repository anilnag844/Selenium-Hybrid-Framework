package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class loginPage {
	WebDriver driver;
	public loginPage(WebDriver driver){
		this.driver=driver;
	}

	@FindBy(xpath=".//*[@id='user_login']") WebElement Username;
	@FindBy(xpath=".//*[@id='user_pass']") WebElement Password;
	@FindBy(xpath=".//*[@id='wp-submit']") WebElement Login;
	@FindBy(xpath=".//*[@id='wp-submit']") WebElement Myaccount;
	@FindBy(xpath=".//*[@id='wp-submit']") WebElement logout;
	
	By locator=By.xpath(".//*[@id='wp-admin-bar-logout']/a");
	
	
	public void userlogin(String username,String passwd){
		Username.sendKeys(username);
		Password.sendKeys(passwd);
		Login.click();
	}
	
	
	public void userlogout(){
		WebDriverWait wait= new WebDriverWait(driver, 200);
		WebElement we=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		String x=we.getText();
		System.out.println(x);
		Assert.assertEquals(x, "test","userlogout not working properly");
		Myaccount.click();
		logout.click();
	}
	
	
	
	
	
	
	
}
