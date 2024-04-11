package hrdemoapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class Users extends Base_class{
	@FindBy(how = How.XPATH, using = "//*[@id='searchSystemUser_userName']")
	private static WebElement txtUserNameSearch;
	@FindBy(how = How.XPATH, using = "//*[@name='btnAdd']")
	private static WebElement btnAdd;
	
	@FindBy(how = How.XPATH, using = "//*[@id='searchSystemUser_userName']")
	private static WebElement txtSearch;
	@FindBy(how = How.XPATH, using = "//*[@id='searchBtn']")
	private static WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using = "//*[@id='resultTable']/tbody/tr[1]/td[2]a")
	private static WebElement lnkResults;
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_userType']")
	private static WebElement drpUserType;
	
	@FindBy(how = How.XPATH, using = "//*[@id='systemUSer_employeeName_empName']")
	private static WebElement txtEmpName;
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_userName']")
	private static WebElement txtUserName;
	
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_status']")
	private static WebElement drpUserStatus;
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_password']")
	private static WebElement txtUserPassword;
	
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_confirmPassword']")
	private static WebElement txtConfirmUserPassword;
	@FindBy(how = How.XPATH, using = "//*[@name='btnSave']")
	private static WebElement btnSave;
	
	private String duserNameText;
	
	public Users() {
		System.out.println("In Users constructor");
		PageFactory.initElements(driver, this);
		
		logger = java.util.logging.Logger.getLogger(Users.class.getName());	
		}
	public Boolean userNameDisplayed() {
		logger.info("Returning username disaplyed information");
		
		return txtUserNameSearch.isDisplayed();
		}
	
	public void clickAdd() {
		logger.info("Clicking Add button");
		clickButton(btnAdd);
		}
	public void setTxtSearch(String searchText) {
		logger.info("Entering search text " + searchText);
		enterText(txtSearch, searchText);
		}
	
	public void selectUserType(String selectText) {
		logger.info("Selecting value: " + selectText);
		selectValue(drpUserType, selectText);
		}
	public void enterEmpName(String empNameText) {
		logger.info("Entering Employee Name:");
		enterText(txtEmpName, empNameText);
	}
	
	public void enterUserName(String userNameText) {
		logger.info("Entering user name");
		enterText(txtUserName, userNameText);
		duserNameText = userNameText;
		}
	public void writeToFile(File file) {
		logger.info("Writing to file");
		
		try (FileWriter writer = new FileWriter(file)){
			writer.write(duserNameText);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectUserStatus(String selectText) {
		logger.info("Selecting user status");
		selectValue(drpUserStatus, selectText);	
		}
	public void clickSrchBtn() {
		logger.info("Clicking search button");
		clickButton(btnSearch);
		}
	
	public void enterPassword(String passwordText) {
		logger.info("Entering password text");
		enterText(txtUserPassword, passwordText);
		}
	public void enterConfPassword(String confPasswordText) {
		logger.info("Entering confirm password text");
		enterText(txtConfirmUserPassword, confPasswordText);
		}
	
	public void clickSave() {
		logger.info("Clicking save button");
		clickButton(btnSave);
		}
	public EditUsers clickUserLink() {
		logger.info("Clicking users link");
		clickButton(lnkResults);
		return new EditUsers();
	}
}
