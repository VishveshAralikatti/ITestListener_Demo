package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelWrite {
	
	HSSFWorkbook file;
	HSSFSheet s;
	public void writeExcel(String path,String SheetName,int r,int c,String result) throws IOException
	{
		FileInputStream fin=new FileInputStream(path);
		file=new HSSFWorkbook(fin);
		s=file.getSheet(SheetName);
		s.getRow(r).createCell(c).setCellValue(result);
		FileOutputStream fout = new FileOutputStream(path);
		file.write(fout);
		fout.flush();
		file.close();
	}
	public static void main(String args[]) throws IOException
	{
		ExcelWrite e= new ExcelWrite();
	    e.writeExcel("C:\\Users\\Vishvesh\\Desktop\\TestData.xls", "Sheet1", 0, 2, "Pass");
		

		}

}
