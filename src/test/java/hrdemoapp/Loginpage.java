package hrdemoapp;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Base_class{
	@FindBy(how = How.XPATH, using ="//*[@id='txtUsername']")
	private static WebElement txtUserName;
	@FindBy(how = How.XPATH, using ="//*[@id='txtPassword']")
	private static WebElement txtPassword;
	@FindBy(how = How.XPATH, using ="//*[@id='btnLogin']")
	private static WebElement btnLogin;
	
	
	public Loginpage() {
		Base_class.driver = driver;
		PageFactory.initElements(driver, this);
		logger = java.util.logging.Logger.getLogger(Loginpage.class.getName());	
	}
	
	public void enterUserName(String userName) {
		logger.info("Entering Username");
		enterText(txtUserName, userName);
	}
	
	public void enterPassword(String password) {
		logger.info("Entering Password");
		enterText(txtPassword, password);
	}
	
	public HomePage clickLogin() {
		logger.info("Clicking Login Button");
		clickButton(btnLogin);
		return new HomePage(driver);
	}

	
}
