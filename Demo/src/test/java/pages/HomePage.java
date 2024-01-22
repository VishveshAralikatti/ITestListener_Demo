package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{
	
	@FindBy(linkText = "Log in")
	static WebElement Link_Login;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, LoginPage.class);

	}
	
	public void clickLoginLink()
	{
		Link_Login.click();
	}

}
