package pages;


import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.ExcelRead;
import utilities.ExcelWrite;
import utilities.MyListener;

@Listeners(value=MyListener.class)
public class LoginTest extends TestBase {
	
	WebDriver d;
	LoginPage l;
	HomePage h;
	
	ExcelRead e= new ExcelRead();
	ExcelWrite w = new ExcelWrite();
	static int rowNum=0;

	@DataProvider
	public Object[][] loginData() throws IOException
	{
		int LastRow=e.getLastRow("C:\\Users\\Vishvesh\\Desktop\\TestData.xls", "Sheet1");

		Object[][] mydata = new Object[LastRow+1][2];
		for(int i=0;i<=LastRow;i++)
		{
		mydata[i][0]=e.readExcel("C:\\Users\\Vishvesh\\Desktop\\TestData.xls", "Sheet1", i, 0);
		mydata[i][1]=e.readExcel("C:\\Users\\Vishvesh\\Desktop\\TestData.xls", "Sheet1", i, 1);
		}
		return mydata;
	}
	
  @Test(dataProvider="loginData")
  public void testLogin(String u,String p) throws InterruptedException, IOException {
	  h.clickLoginLink();
	  l.enterLoginDetails(u, p);
	  try
	  {
		  l.clickLogout();
		  w.writeExcel("C:\\Users\\Vishvesh\\Desktop\\TestData.xls", "Sheet1", rowNum, 2, "Pass");
	  }
	  catch(Exception e)
	  {
		Assert.fail("Sign Out is not Present"); 
		w.writeExcel("C:\\Users\\Vishvesh\\Desktop\\TestData.xls", "Sheet1", rowNum, 2, "Fail");
		
	  }
	  rowNum=rowNum+1;
  }
  
  @BeforeTest
  public void setup()
  {
	  getBrowser();
	  h= new HomePage();
	  l= new LoginPage();
  }
}
