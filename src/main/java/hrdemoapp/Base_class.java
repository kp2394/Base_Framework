package hrdemoapp;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		wdWait = new WebDriverWait(driver, 60);
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
	
	public static void enterText(WebElement elem, String text) {
		wdWait.until(ExpectedConditions.visibilityOf(elem));
		elem.sendKeys(text);
	}
	
	public static void clickButton(WebElement elem){
		wdWait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();
	}
	
	public static void clickLink(WebElement elem) {
		wdWait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();
	}
	
	public static void selectValue(WebElement elem, String selText) {
		wdWait.until(ExpectedConditions.visibilityOf(elem));
		new Select(elem).selectByVisibleText(selText);
	}
	
	public static void deleteOutput() throws IOException{
		if(fileName.exists()) {
			fileName.delete();
		}
		fileName.createNewFile();
		}
	public static void mouseMove(WebElement elem) {
		actions.moveToElement(elem).build().perform();
	}
	public static void doubleClickElement(WebElement elem) {
		actions.doubleClick(elem).build().perform();
	}
	
	public static void fileUpload() {
		//Delay of 2 seconds
		robot.setAutoDelay(2000);
		//Delay of 2 seconds
		
		//Simulates CTRL + C
		stringSelection = new StringSelection("C:\\dummy\\dummy.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		//Simulates CTRL+C
		
		//Simulates CTRL+V
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_CONTROL);	
		robot.keyPress(KeyEvent.VK_V);
		//Simulates CTRL+V
		
		//Simulates ENTER key press
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		//simulates ENTER key press
	}
	
	public static void takeScreenshot(WebDriver driver, String screenshotName) {
		//Create TakesScreenshot object using WebDriver instance
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		//capture the screenshot in the source
		File source = ts.getScreenshotAs(OutputType.FILE);
		//create destination
		String dest = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".png";
		
		//Create the destination File Object
		File destination = new File(dest);
		try {
			//Copy screenshot from source to destination using the FileUtils class
			FileUtils.copyFile(source, destination);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
