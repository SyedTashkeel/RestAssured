package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

//This program is throwing exception since older version of excel (2003 and above...) is not available to execute this test.

public class Excel_XLSX_Utils {

	public static void main(String[] arg) {
		
		// From method - public static void getRowCount()
		getRowCount();
		
		// From method - public static void getCellData()
		getCellData();		
	}
	
	public static void getRowCount() {
		
		try{
			
			String excelPath = "./Data/newTestData.xlsx";
		
			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of Row:"+rowCount);
			
		} catch(Exception e) { 
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
						
		}
	}
		
	public static void getCellData() {
		
		try{
			
			String excelPath = "./Data/newTestData.xlsx";
		
			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			String value = sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(value);
			
			//Integer (int) is throwing exception, thus using double datatype below
			
			double value1 = sheet.getRow(1).getCell(2).getNumericCellValue();
			System.out.println(value1);
			
			//Thus use Apache.POI Data Formatter to get data in source format
			//getRow(1).getCell(2) as object instead of dataType
			
			DataFormatter formats = new DataFormatter();
			
			Object value2 = formats.formatCellValue(sheet.getRow(1).getCell(2));
			System.out.println(value2);
			
			Object value3 = formats.formatCellValue(sheet.getRow(4).getCell(2));
			System.out.println(value3);
			
		} catch(Exception e) { 
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
						
		}
	}
	
}
