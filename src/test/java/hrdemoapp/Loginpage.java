package hrdemoapp;

import org.apache.log4j.Logger;
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
	
	public Login(WebDriver driver) {
		Base_class.driver = driver;
		PageFactory.initElements(driver, this);
		logger = java.util.logging.Logger.getLogger(Login.class.getName());	
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
