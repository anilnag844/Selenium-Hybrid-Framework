package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
	static WebDriver driver;
	public static WebDriver getBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver",DataProviderFactory.getconfig().getMozillPath());
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.Chrome.driver", DataProviderFactory.getconfig().getChromePath());
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			
			System.setProperty("webdriver.IE.driver", DataProviderFactory.getconfig().getMozillPath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		return driver;
	}
	public static void closebrowser(WebDriver driver)
	{
		driver.quit();
	}

}
