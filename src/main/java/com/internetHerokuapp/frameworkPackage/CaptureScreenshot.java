package com.internetHerokuapp.frameworkPackage;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

import dataProvider.ConfigFileReader;

public class CaptureScreenshot {
	
	public CaptureScreenshot() {
		
	}
	
	public static void getScreenshot(WebDriver driver, String filepath) {
		try {
			ConfigFileReader reader = new ConfigFileReader();
			System.out.println("################## In getScreenshot method #######################");
			TakesScreenshot ts = (TakesScreenshot)driver;
			System.out.println("before getScreenshotAs");
			File source = ts.getScreenshotAs(OutputType.FILE);
			System.out.println("after getScreenshotAs");
			FileHandler.copy(source, new File(reader.getFilePath()));
		} catch(WebDriverException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getDateTimeStamp() {
		Date oDate;
		String[] sDatePart;
		String sDateStamp;
		oDate = new Date();
		System.out.println(oDate.toString());
		sDatePart = oDate.toString().split(" ");
		sDateStamp = sDatePart[5] + "_" + sDatePart[1] + "_" + sDatePart[2] + "_" + sDatePart[3] ;
		sDateStamp = sDateStamp.replace(":", "_");
		System.out.println(sDateStamp);
		return sDateStamp;
	}
}
