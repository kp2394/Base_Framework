package hrdemoapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private XSSFWorkbook workBook;
	private XSSFSheet sheet;
	
	public ExcelReader(String excelPath) throws IOException{
		File fileName = new File(excelPath);
		FileInputStream fileStream = new FileInputStream(fileName);
		workBook = new XSSFWorkbook(fileStream);
	}
	
	public String getTestData(String sheetName,int row, int column) {
		sheet = workBook.getSheet(sheetName);
		String returnData = sheet.getRow(row).getCell(column).getStringCellValue();
		return returnData;
	}
	
	public int fetchRowCount(String sheetName) {
		int rows = workBook.getSheet(sheetName).getLastRowNum();
		rows = rows +1;
		return rows;
	}

}
