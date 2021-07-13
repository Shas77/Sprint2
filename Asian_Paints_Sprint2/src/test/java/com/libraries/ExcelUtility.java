package com.libraries;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	public String[] getData(String fileName, String sheetName)
	{
		String data[]=null;
		try
		{
			FileInputStream input = new FileInputStream(fileName);
			XSSFWorkbook workBook = new XSSFWorkbook(input);
			XSSFSheet sheet = workBook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int numRows = sheet.getPhysicalNumberOfRows();
			int numCols = row.getLastCellNum();
			Cell cell;
			data = new String[numRows-1];
			for(int i=1;i<numRows;i++)
			{
				for(int j=0;j<numCols;j++)
					{
						row = sheet.getRow(i);
						cell = row.getCell(j);
						data[i-1] = cell.getStringCellValue();
					}
			}
			workBook.close();
		}
		catch(Exception e)
		{
			System.out.println("The Exception is: "+e.getMessage());
		}
		return data;
	}
}
