package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	public static String tackscreenshot(WebDriver driver,String screenshotname){
		
		
		TakesScreenshot tc=(TakesScreenshot)driver;
		File scr=tc.getScreenshotAs(OutputType.FILE);
		String destination="D:\\Framework\\com.learautomation.HybridFramework\\Screenshots\\"+screenshotname+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(scr,new File( destination));
		} catch (IOException e) {
			System.out.println("Failtocapture screen shot"+e.getMessage());
			
		}
		
		return destination;
	}
	
	
	
	
	
	
	
	

}
