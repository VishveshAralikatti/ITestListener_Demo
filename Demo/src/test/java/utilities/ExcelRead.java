package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelRead {
	
	HSSFWorkbook file;
	HSSFSheet s;
	public String readExcel(String path,String sheetNo,int r,int c) throws IOException
	{
		FileInputStream fin = new FileInputStream(path);
		file = new HSSFWorkbook(fin);
		s=file.getSheet(sheetNo);
	//s=file.getSheetAt(sheetNo);
		String data=s.getRow(r).getCell(c).getStringCellValue();
		file.close();
		return data;
	}
	
	public int getLastRow(String path,String SheetName) throws IOException
	{
		FileInputStream fin = new FileInputStream(path);
		file = new HSSFWorkbook(fin);
		s=file.getSheet(SheetName);
		int LastRow=s.getLastRowNum();
		return LastRow;
	}
	
	public static void main(String args[]) throws IOException
	{
		ExcelRead e= new ExcelRead();
		int LastRow=e.getLastRow("C:\\Users\\Vishvesh\\Desktop\\TestData.xls", "Sheet1");
		for(int i=0;i<=LastRow;i++)
		{
		String Username=e.readExcel("C:\\Users\\Vishvesh\\Desktop\\TestData.xls", "Sheet1", i, 0);
		String Password=e.readExcel("C:\\Users\\Vishvesh\\Desktop\\TestData.xls", "Sheet1", i, 0);
		System.out.print("Username "+ i+" "+Username+" ");
		System.out.print("Password "+ i+" "+Password+" ");
		System.out.println(" ");

		}
	}

}
