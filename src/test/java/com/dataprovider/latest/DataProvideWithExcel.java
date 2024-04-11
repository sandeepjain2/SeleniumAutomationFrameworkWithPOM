package com.dataprovider.latest;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideWithExcel {


	//@Test(dataProvider = "getExcelData")
	public void test4(String username, String password, String fname, String lname) {
		System.out.println(username);
	}

	//@DataProvider
	public Object[][] getExcelData() throws Throwable {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/Excel/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		//String sheetName;

		//XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rownum = sheet.getLastRowNum();
		System.out.println(rownum);
		int columnum = sheet.getRow(0).getLastCellNum();
		System.out.println(columnum);

		Object[][] data = new Object[rownum][columnum];

		for(int i = 1; i<=rownum; i++) {

			for(int j = 0; j<columnum; j++) {

				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();				 // data[1][0]= abcd //data[0][0]
				Thread.sleep(500);
			
			}
		}
		workbook.close();
		return data;
	}
	
	//when there is large amount of data

	
	@Test(dataProvider = "getExcelData1")
	public void test5(Map <String, String> map) {
		System.out.println(map.get("username"));
	}

	@DataProvider
	public Object[] getExcelData1() throws Throwable {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/Excel/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		//String sheetName;

		//XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rownum = sheet.getLastRowNum();
		System.out.println(rownum);
		int columnum = sheet.getRow(0).getLastCellNum();
		System.out.println(columnum);

		Object[] data = new Object[rownum];
		Map<String, String> map;

		for(int i = 1; i<=rownum; i++) {
			map = new HashMap<>();
			
			for(int j = 0; j<columnum; j++) {
				
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				
				map.put(key, value);

				data[i-1] = map;
				Thread.sleep(500);
			
			}
		}
		workbook.close();
		return data;		
		
	}
	
	

}
