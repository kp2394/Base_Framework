package com.internetHerokuapp.frameworkPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dataProvider.ConfigFileReader;


public class BrowserFactory {
	
	public static WebDriver driver;
	
	public BrowserFactory(){
		
	}
	/*
	 * Instantiate the Chrome Driver using ChromeOptions = new ChromeOptions() command.
	 * Decrease/limit the page load timeout of execution using options.setPageLoadStrategy.
	 * 
	 * Set the system property to the name of the webdriver and the path where the driver is present using this command:
	 * setProperty("webdriver.chrome.driver", "/path of chrome driver")
	 * 
	 * maximize the window size
	 * Add implicit waits where you want the execution to wait for a certain time
	 * Add the page load wait that helps in limiting the wait for loading a particular web page.
	 * 
	 * The same Procedure follows for other browsers
	 */
	public static WebDriver getDriver() {
		if(driver==null) {
			ConfigFileReader reader = new ConfigFileReader();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--diasble-notifications", "--headless");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			System.setProperty("webdriver.chrome.driver",reader.getDriverPath());
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);	
		}
		return driver;
	}
}
