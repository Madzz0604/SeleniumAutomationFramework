package com.demo.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.pages.LoginPage;
import com.demo.reports.ExtentManager;
import com.demo.reports.ExtentReportsDemo;
import com.demo.test.BaseTest;

public class DataProviderWithExcel extends BaseTest {
	

	private DataProviderWithExcel() {
		
	}
	
	@Test(dataProvider="excelDataProviderwithHashMap")
	public void login(Map<String,String> map) throws InterruptedException {
		
		//LoginPage login = new LoginPage();
		String actualTitle=new LoginPage()
				          .enterUserName(map.get("username")).enterPassword(map.get("password")).clickLoginButton()
				          .clickUserDropdown().clickLogout()
				          .getLoginTitle();//method chaining
	
		Assert.assertEquals(actualTitle, "Login");
	}
	@Test(dataProvider="dataSheetWithoutExcel")
	public void login(String username,String password) throws InterruptedException {
		
		//LoginPage login = new LoginPage();
		ExtentReportsDemo.createTest("OrangeHRM Login Logout test");
		String actualTitle=new LoginPage()
				          .enterUserName(username).enterPassword(password).clickLoginButton()
				          .clickUserDropdown().clickLogout()
				          .getLoginTitle();//method chaining
	
		Assert.assertEquals(actualTitle, "Login");
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/excel/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("orangeHRM");
		
		int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount][columnCount];
		
		for(int row =1;row<=rowCount;row++) {
			for(int col =0;col<columnCount;col++) {
				
				data[row-1][col]= sheet.getRow(row).getCell(col).getStringCellValue();			
				
			}
			
		}
		return data;
		
	}
	
	@DataProvider

    public Object[][] excelDataProviderwithHashMap() throws IOException {
	String excelPath = System.getProperty("user.dir")+"/src/test/resources/excel/TestData.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("orangeHRM");

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();

        Object[][] dataObject = new Object[rowCount][1];
        for (int row = 0; row < rowCount; row++) {
            HashMap<String, String> data = new HashMap<>();
            for (int col = 0; col < columnCount; col++) {
                String key = sheet.getRow(0).getCell(col).getStringCellValue();
                String value = sheet.getRow(row + 1).getCell(col).getStringCellValue();
                data.put(key, value);
            }
            dataObject[row][0] = data;
        }
      
        return dataObject;
    }
	
	@DataProvider(name="dataSheetWithoutExcel",parallel=false)//for parallel execution if we are using dataprovider and to control thread count we need to mention in testng-xml file
	public Object[][] getDataNoExcel() {
		
		return new Object[][] {
			
			{"Admin","admin123"},
			{"admin123","test"},
			{"Admin","admin123"}, 
			{"Admin","admin123"}
			
		};
	}

}
