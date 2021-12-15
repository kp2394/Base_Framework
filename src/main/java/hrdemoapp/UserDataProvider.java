package hrdemoapp;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class UserDataProvider {
	@DataProvider(name = "Users")
	public Object[][] provideData() throws IOException{
		ExcelReader excelData = new ExcelReader("TestData/UsersData.xlsx");
		int rowCount = excelData.fetchRowCount("Users");
		Object[][] excelColumnData = new Object[rowCount - 1][5];
		
		for(int i=1;i<rowCount;i++) {
			excelColumnData[i-1][0] = excelData.getTestData("Users",i,0);
			excelColumnData[i-1][1] = excelData.getTestData("Users",i,1);
			
			excelColumnData[i-1][2] = excelData.getTestData("Users",i,2);
			excelColumnData[i-1][3] = excelData.getTestData("Users",i,3);
			excelColumnData[i-1][4] = excelData.getTestData("Users",i,4);
			}
		return excelColumnData;
		}

}
