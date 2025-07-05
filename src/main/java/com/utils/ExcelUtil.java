package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtil {
	/**
	 * This Method reads the specified column from given excel sheet
	 * @param FilePath
	 * @param SheetName
	 * @return
	 */
	
	@Test
	public static Object[][] validLocationListData(String FilePath, String SheetName) {
		Object[][] data= null;
		FileInputStream fis = null;
		Workbook book = null;
		try {
			fis = new FileInputStream(FilePath);
			book = new XSSFWorkbook(fis);
			Sheet sheet = book.getSheet(SheetName);
			int lastRow = sheet.getLastRowNum();
			int lastCell = sheet.getRow(0).getLastCellNum();
			data = new Object[lastRow][lastCell];
			
			//Cell cell = row.getCell(0);
			
			for(int i = 1; i <= lastRow; i++ ) {
				Row row = sheet.getRow(i);
				
				for(int j = 0; j < lastCell; j++) {
					Cell cell = row.getCell(j);
					switch(cell.getCellType()) {
					case STRING:
						data[i-1][j] = cell.getStringCellValue(); 
						break;
					case NUMERIC:
	                    data[i - 1][j] = cell.getNumericCellValue();
	                    break;
					default:
						break;
					}
				}
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				book.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return data;
		
	}
	public static void main(String[] args) {
		
	}

}
