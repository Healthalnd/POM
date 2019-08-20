package Sample;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Pages.GoogleHomePage;

public class CommonActions {

	WebDriver driver;
	 
	 
	
	public void highlightElement(WebElement ele) throws InterruptedException {
		 PageFactory.initElements(driver, GoogleHomePage.class);
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", ele);
		Thread.sleep(3000);
	}
	
}
