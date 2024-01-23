package com.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	public static void main(String[] args) throws Exception {
		DataFormatter df = new DataFormatter(); 
		FileInputStream fis=new FileInputStream("ReadWrite.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rows =sh.getLastRowNum();

		for(int i=0; i<rows; i++) {
			int cols =sh.getRow(i).getLastCellNum();
			for (int j=0;j<cols;j++) {
				Cell c =sh.getRow(i).getCell(j);
				System.out.print(df.formatCellValue(c)+" ");
			}
			System.out.println();
		}
	}

	public static String getCellData(int row, int col) throws Exception{
		DataFormatter df = new DataFormatter(); 
		FileInputStream fis=new FileInputStream("ReadWrite.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Cell c= sh.getRow(row).getCell(col);
		String data= df.formatCellValue(c);
		return data;
	}
	public static int getRows() throws Exception {  
		FileInputStream fis=new FileInputStream("ReadWrite.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		return sh.getLastRowNum();
	}

}
