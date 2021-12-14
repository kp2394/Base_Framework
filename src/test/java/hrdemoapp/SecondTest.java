package hrdemoapp;

import java.io.File;
import java.io.IOException;

import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTest extends Base_class{
	private static File fileName;
	static Login login = new Login(driver);
	static Boolean txtuserNameexists = false;
	
	static HomePage homePage = null;
	static Users usersPage = null;
	static EditUsers editUser = null;
	
	public SecondTest() {
		super();
	}
	
	@BeforeClass
	public static void openBrowser() {
		//extendTest = extendReport.startTest("Edit Users");
		initApp();
	}
	
	@BeforeClass
	public static void openBrowser() throws IOException{
		//extendTest = extendReport.startTest("Create Users");
		deleteOutput();
	}
	
	@AfterClass
	public static void closeBrowser() {
		//extendReport.endTest(extendTest);
		driver.quit();
		//HomePage.clickLogout();
	}
	
	@Test
	public static void loginToApplication() {
		String homepageText = null;
		login.enterUserName(getProperty("USERNAME"));
		login.enterPassword(getProperty("PASSWORD"));
		homePage = login.clickLogin();
		homepageText = homePage.getWelcomeText();
		Assert.assertEquals(homepageText, getProperty("WELCOMEMSG"), getProperty("ERRORMSG"));
		//extendTest.log(LogStatus.PASS, "Welcome message verified");
		}
	
	@Test(dependsOnMethods = "loginToApplication")
	public static void openUsers() {
		homePage.clickAdminLink();
		homePage.clickUserManagementLink();
		usersPage = homePage.clickUsersLink();
		txtuserNameexists = usersPage.userNameDisplayed();
		Assert.assertTrue(txtuserNameexists);
		
		fileName = new File("C:\\Users\\USER\\Desktop\\users.txt");
		String[] returnArray = Utilities.readFile(fileName);
		for(int i = 0; i < returnArray.length;i++) {
			System.out.println("Array item" + i + "="+returnArray[i]);
			usersPage.setTxtSearch(returnArray[i]);
			usersPage.clickSrchBtn();
			editUser = usersPage.clickUserLink();
			readTest();
		}
	}
	
	public static void readTest() {
		editUser.clickEditBtn();
		editUser.chkChangePassword();
		editUser.setTxtPassword("p9121975");
		editUser.clickEditBtn();
	}
	

}
