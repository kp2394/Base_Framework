package hrdemoapp;

import java.io.File;

import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class basicTest extends Base_class{
	static int i = 0;
	static Login login = new Login(driver);
	static HomePage homePage = null;
	static Users usersPage = null;
	static Boolean txtuserNameexists = false;
	
	static File fileName;
	
	public basicTest() {
		super();
	}
	
	@BeforeClass
	public static void openBrowser() {
		fileName = new File("C:\\Users\\USER\\Desktop\\users.txt");
		
		initApp();
		}
	
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
		driver = null;
		}
	
	@Test
	public static void loginToApplication() {
		String homepageText = null;
		login.enterUserName(getPreperty("USERNAME"));
		login.enterPassword(getProperty("PASSWORD"));
		homePage = login.clickLogin();
		homepageText = homePage.getWelcomeText();
		
		System.out.println(getProperty("WELCOMEMSG"));
		Assert.assertEquals(homepageText, getProperty("WELCOMEMSG"));
		getProperty("ERRORMSG");
		}
	
	@Test(dependsOnMethods = "loginToApplication")
	public static void openUSers() {
		homePage.clickAdminLink();
		homePage.clickUserManagementLink();
		
		usersPage = homePage.clickUsersLink();
		txtuserNameexists = usersPage.userNameDisplayed();
		Assert.assertTrue(txtuserNameexists);
		}
	
	@Test(dependsOnMethods = "openUsers", dataProvider = "Users", dataProviderClass = UserDataProvider.class)
	public static void addUSers(String userType, String empName, String userName, String password, String confPassword) {
		usersPage.clickAdd();
		usersPage.selectUserType(userType);
		usersPage.enterEmpName(empName);
		usersPage.enterUserName(userName + Utilities.getTimeStamp());
		usersPage.enterPassword(password);
		usersPage.enterConfPassword(confPassword);
		usersPage.clickSave();
		usersPage.writeToFile(fileName);
		txtuserNameexists = usersPage.userNameDisplayed();
		Assert.assertTrue(txtuserNameexists);
	}

}
