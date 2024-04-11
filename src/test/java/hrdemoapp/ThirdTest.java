package hrdemoapp;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThirdTest extends Base_class{
	static int i = 0;
	static Loginpage login = null;
	static HomePage homePage = null;
	static Users usersPage = null;
	static Boolean txtuserNameExists = false;
	
	public ThirdTest() {
		super();
		login = new Loginpage();
	}
	
	@BeforeClass
	public static void openBrowser() throws IOException {
		deleteOutput();
		initApp();
	}
	
	@AfterClass
	public static void closeBrowser() throws IOException {
		driver.quit();
		driver = null;
	}
	
	@Test
	public static void loginToApplication() {
		String homePageText = null;
		login.enterUserName(getProperty("USERNAME"));
		login.enterPassword(getProperty("Password"));
		homePage = login.clickLogin();
		homePageText = homePage.getWelcomeText();
		
		System.out.println(getProperty("WELCOMEMSG"));
		Assert.assertEquals(homePageText, getProperty("WELCOMEMSG"),getProperty("ERRORMSG"));
	}
	
	@Test(dependsOnMethods = "loginToApplication")
	public static void hoverEmployeeLst() throws InterruptedException {
		homePage.hoverPIMEmployeeLst();
	}

}
