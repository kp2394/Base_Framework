package hrdemoapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver extends Base_class {
	private SingletonDriver() {	
	}
	public static WebDriver getSingletonInstance() {
		if(null == driver) {
			System.setProperty("websriver.chrome.driver",".//src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
}
