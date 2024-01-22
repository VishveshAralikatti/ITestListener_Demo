package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilities.MyBrowserEvents;

public class TestBase {
	
	public static WebDriver driver=null;
	
	public static void getBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis\\SL\\Demo\\src\\test\\resource\\chromedriver.exe");
		  driver= new ChromeDriver();
		  driver.get("http://demowebshop.tricentis.com/");
		  EventFiringWebDriver ed = new EventFiringWebDriver(driver);
		  MyBrowserEvents be= new MyBrowserEvents();
		  ed.register(be);
		  
		  //driver now is your eventFiring driver(before was just normal browser)
		  driver = ed;
	}

}
