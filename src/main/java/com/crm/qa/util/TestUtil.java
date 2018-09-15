package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_LOAD_TIMEOUT =10;
	public static String TESTDATA_SHEET_PATH="F:\\Sample Work Space\\TestCRMProject\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public  void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static void takesScreenShotWhenFailed()
	{
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		try {
			FileUtils.copyFile(srcfile, new File(currentDir+"/screenshots/" + System.currentTimeMillis() +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file =null;
		try {
			 file=new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		int rows=sheet.getLastRowNum();		
		System.out.println("Total Rows: "+rows);
		int cols=sheet.getRow(0).getLastCellNum();
		System.out.println("Total Columns: "+cols);
		Object[][] data=new Object[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int k=0;k<cols;k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				sheet.getRow(i+1).createCell(4).setCellValue("Pass");
				FileOutputStream fos=null;
				try {
					 fos=new FileOutputStream(TESTDATA_SHEET_PATH);
					try {
						book.write(fos);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			}
		
		return data;
		
		
	}
	

}
