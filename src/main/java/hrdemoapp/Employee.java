package hrdemoapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class Employee extends Base_class{
	public Employee(WebDriver driver) {
		Base_class.driver = driver;
		PageFactory.initElements(driver, this);
		
		logger = Logger.getLogger(Employee.class.getName());
	}

}
