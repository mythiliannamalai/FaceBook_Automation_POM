package FB.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseClass {
	
	public Logger log = Logger.getLogger(BaseClass.class);
public static WebDriver driver;
public static Properties prop;

public BaseClass() {	   
	try {
		 prop = new Properties();
		    FileInputStream ip;
		ip = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\FB.Automation\\src\\main\\java\\FB\\Config\\properties\\Config.properties");
		prop.load(ip);
	}catch(FileNotFoundException e) {
e.printStackTrace();		
	}catch(IOException e) {
		e.printStackTrace();
	}
	}	
	public void initialization() {
    log.info("Brower Name :"+prop.getProperty("brower"));
String browserName = prop.getProperty("brower");
System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver();
log.info("Application URL :"+ prop.getProperty("url"));
driver.get(prop.getProperty("url"));
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
}
	
	public void failedTest(){
		TakesScreenshot ts=(TakesScreenshot)driver;
		  File SFile = ts.getScreenshotAs(OutputType.FILE);
		  File DFile = new File(".\\FB.ScreenShots\\"+"failedmethod.png");
		  try {
			FileHandler.copy(SFile,DFile);
		} catch (IOException e) {				
			e.printStackTrace();
		}
	}
}