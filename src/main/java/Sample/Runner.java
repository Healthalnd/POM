package Sample;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Runner {
	private  WebDriver driver;
	
	
  @Test
  public void f() {
	  
	  System.out.println("Execution Start");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://www.google.com");
	  String search ="Google Search";
	  WebElement search_button=driver.findElement(By.xpath(".//*[@type='submit']"));
	  String text=search_button.getAttribute("value");
	  Assert.assertEquals(text, search,"Text Nit Found");
	  System.out.println("Execution End");
	  
  }
  @BeforeClass
  public void beforeClass() {
 /* System.setProperty("webdriver.gecko.driver", "C:\\\\2017\\\\Study\\\\geckodriver-v0.15.0-win64\\\\geckodriver.exe");
  File pathToBinary = new File("C:\\Users\\c003574\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
  FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
  FirefoxProfile firefoxProfile = new FirefoxProfile();
    driver = new FirefoxDriver(ffBinary,firefoxProfile);*/
	  
	System.setProperty("webdriver.gecko.driver", "C:\\\\2017\\\\Study\\\\geckodriver-v0.24.0-win64\\\\geckodriver.exe");
	System.setProperty("webdriver.firefox.bin", "C:\\\\Users\\\\c003574\\\\AppData\\\\Local\\\\Mozilla Firefox\\\\firefox.exe");
	System.setProperty("webdriver.firefox.marionette", "true");
	
	/*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
	driver = new FirefoxDriver(capabilities);*/
	

	
	driver= new FirefoxDriver();
	
	/*DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability("marionatte", false);
	FirefoxOptions opt = new FirefoxOptions();
	opt.merge(dc);
	 driver =  new FirefoxDriver(opt);*/
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
