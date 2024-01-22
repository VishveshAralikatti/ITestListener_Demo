package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import pages.TestBase;

public class ScreenshotUtiity extends TestBase {
	
	public String takeScreeshot() throws IOException
	{
		TakesScreenshot  ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\Vishvesh\\Pictures\\Screenshots\\myscreenshot_"+System.currentTimeMillis()+".png";
		File target = new File(path);
		FileUtils.copyFile(source, target);
		String targetPath= target.getAbsolutePath();
		return targetPath;
	}

}
