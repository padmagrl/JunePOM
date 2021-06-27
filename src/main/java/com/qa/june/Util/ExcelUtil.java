package com.qa.june.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
		//private static String TEST_DATA_SHEET = "./src/test/resources/testData/OpenCartModified.xlsx";
		private static Workbook book;
		private static Sheet sheet;

		public static Object[][] getTestData(String pathOfFile,String sheetName) {

			Object data[][] = null;
			try {
				FileInputStream ip = new FileInputStream(pathOfFile);

				book = WorkbookFactory.create(ip);
				sheet = book.getSheet(sheetName);
				int rows=sheet.getLastRowNum();
				int cols=sheet.getRow(0).getLastCellNum();

				data = new Object[rows][cols];
				

				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						data[i][j] = sheet.getRow(i+1).getCell(j).toString();
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return data;

		}


}
