package Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sample.CommonActions;

public class GoogleSearchResultPage {
	@FindBy(partialLinkText="DXC Technology: Global IT Services and Solutions Leader")  WebElement dxcGlassDroorLink;
	 
	WebDriver driver;
	CommonActions CAObj=new CommonActions();
	
	public GoogleSearchResultPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void tab() throws InterruptedException
	{
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		//js.executeScript("window.open()");
		String windowHandle = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		driver.get("https://www.google.com");
		
		//driver.switchTo().window(windowHandle);
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
	    //driver.switchTo().defaultContent();
*/	    
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		dxcGlassDroorLink.sendKeys(selectLinkOpeninNewTab);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		System.out.println(driver.getCurrentUrl());
		
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		
	}
	public void clickLink() throws InterruptedException
	{
		Thread.sleep(3000);
		dxcGlassDroorLink.click();
		Thread.sleep(3000);
		
	}
}
