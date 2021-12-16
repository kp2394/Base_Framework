package hrdemoapp;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Base_class{
	//private WebDriver driver;
	@FindBy(how = How.XPATH, using = "//*[@id='menu_admin_viewAdminModule']")
	private static WebElement mnuAdmin;
	@FindBy(how = How.XPATH, using = "//*[@id='menu_admin_UserManagement']")
	private static WebElement mnuUserManagement;
	
	@FindBy(how = How.XPATH, using = "//*[@id='menu_admin_viewSystemUsers']")
	private static WebElement mnuUsers;
	@FindBy(how = How.XPATH, using = "//*[@id='welcome']")
	private static WebElement lnkWelcome;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Logout']")
	private static WebElement lnkLogout;
	@FindBy(how = How.XPATH, using = "//*[@id='welcome']")
	private static WebElement txtWelcome;
	
	@FindBy(how = How.XPATH, using = "//*[@id='menu_pim_viewPimModule']")
	private static WebElement lnkPIM;
	@FindBy(how = How.XPATH, using = "//*[@id='menu_pim_viewEmployeeList']")
	private static WebElement lnkEmpList;
	
	public HomePage(WebDriver driver) {
		System.out.println("In HomePage Constructor");
		Base_class.driver = driver;
		PageFactory.initElements(driver, this);
		
		logger = Logger.getLogger(HomePage.class.getName());
		System.out.println("After InitElement HomePage");
	}
	
	public String getWelcomeText() {
		//System.out.println("getting welcome text");
		logger.info("Getting Welcome text");
		return txtWelcome.getText();
	}
	
	public void clickAdminLink() {
		//System.out.println("Clicking on Admin Link");
		logger.info("Clicking on Admin Link");
		clickLink(mnuAdmin);
	}
	
	public void clickUserManagementLink() {
		logger.info("Clicking User Management link");
		clickLink(mnuUserManagement);
	}
	
	public Users clickUsersLink() {
		logger.info("Clicking Users link");
		clickLink(mnuUsers);
		return new Users();
	}
	
	public static void clickLogout() {
		try {
			Thread.sleep(5000);
			}catch(InterruptedException e1) {
				//TODO Auto-generated catch block
				e1.printStackTrace();
			}
		clickLink(lnkWelcome);
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickLink(lnkLogout);
	}
	
	public Employee hoverPIMEmployeeLst() throws InterruptedException {
		logger.info("Hovering on PIM and Employee list link");
		wdWait.until(ExpectedConditions.visibilityOf(lnkPIM));
		mouseMove(lnkPIM);
		wdWait.until(ExpectedConditions.visibilityOf(lnkEmpList));
		clickLink(lnkEmpList);
		return new Employee(Base_class.driver);
	}

}
