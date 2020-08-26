package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot{

	
	public String capture(WebDriver driver,String testName) {
		String date = new Date().toString().replace(":", "-");
	 String	photo_path=System.getProperty("user.dir")+"/defects/"+testName+date+".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(photo_path);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
		System.out.println("failed to take screenshot");
		}
		return photo_path;
	}
	
	
}
