package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

//This program is throwing exception since older version of excel (2003 and above...) is not available to execute this test.

public class Excel_XLSX_Constructor {

			static XSSFWorkbook workbook;
			static XSSFSheet sheet;
		
	//Constructor uses same class name
	//Calling this program from another class
			
	public Excel_XLSX_Constructor(String excelPath, String sheetName) {
		
		try{

			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			
		} catch(Exception e) { 
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
						
		}
	}
	
	public static void getRowCount() {
		
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of Row:"+rowCount);
						
	}
		
	public static void getCellData(int rowNum, int colNum) {
	
	//String value output
			//String value = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(value);
			
	//Integer (int) is throwing exception, thus I am using double datatype below
			
			//double value1 = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println(value1);
			
	//Use Apache.POI Data Formatter to get data in source format
	//getRow(1).getCell(2) as object instead of dataType
			
			DataFormatter formats = new DataFormatter();
			
			Object value2 = formats.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			System.out.println(value2);
	}	
}
