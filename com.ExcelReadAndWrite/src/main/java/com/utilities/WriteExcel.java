package com.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcel {
	public static Sheet sh= null;
	public static Row r= null;
	public static Cell c= null;

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("ReadWrite.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		sh = wb.getSheet("Sheet1");
		if(sh==null) {
			sh = wb.createSheet("Sheet1");
			r = sh.getRow(5);
			if(r==null) 
				r = sh.createRow(5);
			c= r.getCell(3);
			if(c==null)
				c=r.createCell(3);
			c.setCellValue("TheKiranAcademy");

			FileOutputStream fos = new FileOutputStream("ReadWrite.xlsx");
			wb.write(fos);
			wb.close();
			fos.close();
		}
	}
		public static void writeData(int row, int col, String value) throws Exception{
			FileInputStream fis = new FileInputStream("ReadWrite.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			sh = wb.getSheet("Sheet1");
			if(sh==null) {
				sh = wb.createSheet("Sheet1");
				r = sh.getRow(row);
				if(r==null) 
					r = sh.createRow(row);
				c= r.getCell(col);
				if(c==null)
					c=r.createCell(col);
				c.setCellValue(value);

				FileOutputStream fos = new FileOutputStream("ReadWrite.xlsx");
				wb.write(fos);
				wb.close();
				fos.close();
			
			
		}
	}
}

