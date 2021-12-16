package hrdemoapp;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThirdTest extends Base_class{
	static int i = 0;
	static Login login = null;
	static HomePage homePage = null;
	static Users usersPage = null;
	static Boolean txtuserNameExists = false;
	
	public ThirdTest() {
		super();
		login = new Login(driver);
	}
	
	@BeforeClass
	public static void openBrowser() throws IOException {
		deleteOutput();
		initApp();
	}
	
	@AfterClass
	public static void closeBrowser() throws IOExpection {
		driver.quit();
		driver = null;
	}
	
	@Test
	public static void loginToApplication() {
		String homePageText = null;
		login.enterUserName(getProperty("USERNAME"));
		login.enterPassword(getProperty("Password"));
		homePage = login.clickLogin();
		homepageText = homePage.getWelcomeText();
		
		System.out.println(getProperty("WELCOMEMSG"));
		Assert.assertEquals(homepageText, getProperty("WELCOMEMSG"),getProperty("ERRORMSG"));
	}
	
	@Test(dependsOnMethods = "loginToApplication")
	public static void hoverEmployeeLst() throws InterruptedExpection {
		homePage.hoverPIMEmployeeLst();
	}

}
