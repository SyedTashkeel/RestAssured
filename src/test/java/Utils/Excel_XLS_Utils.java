package Utils;

//import org.apache.poi.hssf.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import org.apache.poi.*;

//This program is throwing exception since older version of excel (2003 and above...) is not available to execute this test.

public class Excel_XLS_Utils {

	public static void main(String[] arg) {
		
		getRowCount();
					
	}
	
	public static void getRowCount() {
		
		try{
			
			String excelPath = "./Data/oldTestData.xls";
		
			InputStream file = new FileInputStream(excelPath);
			
			HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file));
			HSSFSheet sheet = workbook.getSheet("Sheet1");
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of Row:"+rowCount);
			
		} catch(Exception e) { 
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
						
		}
	}
}
