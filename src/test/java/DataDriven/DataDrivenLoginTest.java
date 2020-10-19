package DataDriven;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.Excel_DataDrivenLoginTest;
import Utils.Excel_MainClass_Utils;
import Utils.Excel_XLSX_Constructor;

public class DataDrivenLoginTest {
	
WebDriver driver;
	
	@Test(dataProvider="dataInputValue") 	
	public void yahooSignUp(String firstname, String lastname) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://login.yahoo.com/account/create/");
		
		driver.findElement(By.id("usernamereg-firstName")).sendKeys(firstname);
		driver.findElement(By.id("usernamereg-lastName")).sendKeys(lastname);
		driver.findElement(By.linkText("Sign in")).click();
				
		Thread.sleep(3000);
		
		System.out.println(firstname);
		System.out.println(lastname);
		
		Assert.assertEquals("Sign", "Sign");
		
		driver.quit();
		
		Thread.sleep(3000);
		
	}

	@DataProvider(name="dataInputValue")
		public Object[][] inputSheet() {
			
			Excel_DataDrivenLoginTest callDataUtil = new Excel_DataDrivenLoginTest("./Data/newTestData.xlsx","Sheet1");
			
			int rows= callDataUtil.getRowCount(0);
			
			Object[][] data= new Object[rows][2];
			
			for (int i=0;i<rows;i++)
			{
				data[i][0]=callDataUtil.getData(0, i, 0);
				data[i][1]=callDataUtil.getData(0, i, 1);
			}
			return data;
		}

/* Data input using Array hardcoded
 
 	@DataProvider(name="dataInputValue")
	public Object[][] dataInput() {
		
		Object[][] data= new Object[3][2];
		
//Since we are specifying 3 row and 2 columns, passing below array values
		data[0][0] = "Admin";
		data[0][1] = "(1)23456";
		
		data[1][0] = "Admin1";
		data[1][1] = "1(2)3456";
		
		data[2][0] = "Admin2";
		data[2][1] = "12(3)456";
		
		return data;
	} */

}
