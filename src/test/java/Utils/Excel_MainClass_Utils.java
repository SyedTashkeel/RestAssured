package Utils;

public class Excel_MainClass_Utils {
	
	public static void main(String[] arg) {
		
		String excelPath = "./Data/newTestData.xlsx";
		String sheetName = "Sheet1";
		
		
		Excel_XLSX_Constructor callExcelUtil = new Excel_XLSX_Constructor(excelPath, sheetName);
		
		System.out.println("Record Count:");
		callExcelUtil.getRowCount();
		
		System.out.println();
		System.out.println("Data in Row# 1:FName");
		callExcelUtil.getCellData(1, 0);
		callExcelUtil.getCellData(1, 1);
		callExcelUtil.getCellData(1, 2);
		
		System.out.println();
		System.out.println("Data in Column# 2:Supplier");
		callExcelUtil.getCellData(1, 2);
		callExcelUtil.getCellData(2, 2);
		callExcelUtil.getCellData(3, 2);
		callExcelUtil.getCellData(4, 2);
	}


}
