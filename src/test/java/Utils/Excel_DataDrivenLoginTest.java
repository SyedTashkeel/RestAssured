package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//This program is throwing exception since older version of excel (2003 and above...) is not available to execute this test.

public class Excel_DataDrivenLoginTest {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public Excel_DataDrivenLoginTest(String excelPath, String sheetName) {
		// TODO Auto-generated constructor stub
		
		try {		
			
			excelPath = "./Data/newTestData.xlsx";
			sheetName = "Sheet1";
						
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			
		} catch(Exception e) { 
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}
	public int getRowCount(int sheetIndex) {
	
			int row = workbook.getSheetAt(sheetIndex).getLastRowNum();
			System.out.println("No of Row:"+row);
			
			row= row+1;
				
			return row;		
	}

		
	public String getData(int sheetNum, int rowNum, int colNum) {
	
		sheet = workbook.getSheetAt(sheetNum);
		
		String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		
		return data;
		
	}	
	
}
