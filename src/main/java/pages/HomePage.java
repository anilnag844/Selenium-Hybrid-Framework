package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
	}

	@FindBy(xpath=".//*[@id='user_login']") WebElement Username;
	@FindBy(xpath=".//*[@id='user_pass']") WebElement Password;
	@FindBy(xpath=".//*[@id='wp-submit']") WebElement Login;
	
	public void login(String username,String passwd){
		Username.sendKeys(username);
		Password.sendKeys(passwd);
		Login.click();
	}
	public String gethomescreentitle(){
		return driver.getTitle();
	}
	
}
