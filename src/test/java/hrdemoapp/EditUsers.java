package hrdemoapp;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditUsers extends Base_class{

	@FindBy(how = How.XPATH, using = "//*[@id='btnSave']")
	private static WebElement btnEdit;
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_chkChangePassword']")
	private static WebElement chkChangePassword;
	
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_password']")
	private static WebElement txtPassword;
	@FindBy(how, How.XPATH, using = "//*[@id='systemUser_confirmPassword']")
	private static WebElement txtConfirmPassword;
	
	public EditUser() {
		System.out.println("In EditUser constructor");
		PageFactory.initElements(driver, this);
		
		logger = Logger.getLogger(EditUser.class.getName());
		}
	public void setTxtPassword(String passwordText) {
		logger.info("Entering Password");
		clickButton(chkChangePassword);
		}
	
	public void clickEditBtn() {
		logger.info("Clicking Edit Button");
		clickButton(btnEdit);
		}
	
	public void setTxtConfirmPassword(String confirmPasswordText) {
		logger.info("Entering confirm password");
		enterText(txtConfirmPassword, confirmPasswordText);
	}
}
