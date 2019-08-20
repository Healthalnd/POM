package Test;

import java.util.concurrent.TimeUnit;

import org.jboss.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CashKaroPage.Home;
import Pages.GoogleHomePage;
import Pages.GoogleSearchResultPage;

public class CashkaroSignup {
	
	public WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\\\2017\\\\Study\\\\geckodriver-v0.24.0-win64\\\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\\\Users\\\\c003574\\\\AppData\\\\Local\\\\Mozilla Firefox\\\\firefox.exe");
		System.setProperty("webdriver.firefox.marionette", "true");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://cashkaro.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@Test
	public void Validate_DXCGlassDoor_Search_Link() throws Exception{
		
		Home GHPObj=new Home(driver);
		GHPObj.enterSignUpDetails("sakthivel","Shakthivelit@gmail.com","7373299820","Neha1234@");
	
		
	}
	
	
	

}
