package hrdemoapp;

import java.io.File;
import java.io.IOException;

import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;

public class SecondTest extends Base_class{
	private static File fileName;
	static Loginpage login = new Loginpage();
	static Boolean txtuserNameexists = false;
	
	static HomePage homePage = null;
	static Users usersPage = null;
	static EditUsers editUser = null;
	static WebDriverWait wdWait;
	
	public SecondTest() {
		super();
	}
	
	
	@BeforeClass
	public static void openBrowser() throws IOException{
		//extendTest = extendReport.startTest("Create Users");
		deleteOutput();
		
		//extendTest = extendReport.startTest("Edit Users");
				initApp();
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
		
//		fileName = new File("C:\\Users\\USER\\Desktop\\users.txt");
//		String returnArray = FileUtils.readFileToString(fileName);
//		for(int i = 0; i < returnArray.length();i++) {
//			System.out.println("Array item" + i + "="+returnArray[i]);
//			usersPage.setTxtSearch(returnArray[i]);
//			usersPage.clickSrchBtn();
//			editUser = usersPage.clickUserLink();
//			readTest();
//		}
	}
	
	public static void readTest() {
		//Thread.sleep(3000);
		try {
			wdWait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@class='message success fadable']"))));
			System.out.println("After waiting");
		}catch (Exception e) {
			logger.info("Text not found");
		}
		editUser.clickEditBtn();
		editUser.clickChangePassword();
		editUser.setTxtPassword("p9121975");
		editUser.clickEditBtn();
	}
	

}
