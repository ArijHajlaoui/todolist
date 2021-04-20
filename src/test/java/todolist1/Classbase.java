package todolist1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Classbase {

	public static WebDriver driver;
    @BeforeMethod
	public void launch() {
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chromedriver");
    	driver = new ChromeDriver();
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
    
    public void getscreen() throws IOException { 
		  long a = System.currentTimeMillis(); 
		  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("/home/arij"+ a +"screenshott.png")); 
		  }
@AfterMethod
    public void close() {
    	driver.quit();
    }
}
