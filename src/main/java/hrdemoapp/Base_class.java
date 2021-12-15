package hrdemoapp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extendreports.ExtendReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.releventcodes.extendreports.ExtendTest;

//This is the Base Class
public class Base_class {
	public static ExtendReports extentReport;
	public static ExtentTest extendTest;
	static WebDriver driver = null;
	public static Logger logger = null;
	
	//{
	//extendReport = new ExtendReports{
	// "C:\\Users\\USER\\Desktop\extendreport.html");
	//}
	@BeforeTest
	public static void loadLog4j() {
		String log4Jpath = System.getProperty("user.dir") + "/log4j.properties";
		PropertyConfigurator.configure(log4jpath);
	}
	
	public Base_class() {
		//driver = SingletonDriver.getSingletonInstance();
	}
	
	public static void populateDriver() {
		driver = SingletonDriver.getSingletonInstance();
	}
	
	public static void initApp() {
		populateDriver();
		String URL = getPorperty("URL");
		navigtateToURL(URL);
	}
	
	public static Login navigateToURL(String URL) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to(URL);
		return new Login(driver);
	}
	
	static File file = new File(".//src/main/resources/config/config.properties");
	
	public static String getProperty(String propKey) {
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(propKey);
	}
	
	public static void enterTest(WebElement elem, String text) {
		elem.sendKeys(text);
	}
	
	public static void clickButton(WebElement elem){
		elem.click();
	}
	
	public static void clickLink(WebElement elem) {
		elem.click();
	}
	
	public static void selectValue(WebElement elem, String selText) {
		new Select(elem).selectByVisibleText(selText);
	}
	
	public static void deleteOutput() throws IOException{
		if(fileName.exists()) {
			fileName.delete();
		}
		fileName.createNewFile();
		}
}
