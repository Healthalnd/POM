package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sample.CommonActions;

public class GoogleHomePage extends CommonActions {
	
	@FindBy(xpath=".//*[@type='submit']") WebElement googleSubmit;
	@FindBy(xpath=".//*[@title='Search']") WebElement googleSearchBox;
	@FindBy(xpath="(.//*[@class='UUbT9']//li[1])[1]") public WebElement dxcGlassDroorLink;
	By name=By.xpath("(.//*[@class='UUbT9']//li[1])[1]"); WebElement dd; 
	WebDriver driver;
	CommonActions CAObj=new CommonActions( );
	
	public GoogleHomePage(WebDriver driver) {

		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void enterValueSearchEngin(String Value)
	{
		googleSearchBox.sendKeys(Value);
	}
			
	public void clickSearchEnginSubmit()
	{
		googleSubmit.click();
	}
	public void clickSearchDXCGlasssDoorLink() throws InterruptedException
	{
		Thread.sleep(3000);
		Actions obj=new Actions(driver);
		obj.moveToElement(dxcGlassDroorLink).perform();
		//CAObj.highlightElement(dxcGlassDroorLink);
		dxcGlassDroorLink.click();
	}
	
	public void TestDXCGlassDoorSearchLink() throws InterruptedException
	{
		this.enterValueSearchEngin("DXC");
		this.clickSearchDXCGlasssDoorLink();
	}
	
	
	
			
}
