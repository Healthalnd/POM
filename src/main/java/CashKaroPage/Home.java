package CashKaroPage;

import static org.testng.Assert.assertEquals;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
 
 
 
import net.sourceforge.tess4j.*;
import java.io.File;
public class Home {
	
	@FindBy(id="link_join") WebElement freeJoinLink;
	@FindBy(id="firstname") WebElement Firstname;
	@FindBy(id="email") WebElement Email;
	@FindBy(id="pwd-txt") WebElement pwdtxt;
	@FindBy(id="mobile_number") WebElement mobile_number;
	@FindBy(id="to_be_check") WebElement to_be_check;
	@FindBy(id="join_free_submit") WebElement join_free_submit;
	WebDriver driver;
	String firstname;
	String email;
	String phonNumber;
	String Password;
	int captchaCount;
	
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickJoinFreeButton () throws InterruptedException
	{
		freeJoinLink.click();
		Thread.sleep(3000);
	}
	
	public void enterSignUpDetails(String firstname,
	String email,
	String phonNumber,
	String Password
	 ) throws Exception {
		
		this.firstname=firstname;
		this.email=email;
		this.Password=Password;
		this.phonNumber=phonNumber;
		this.clickJoinFreeButton();
		Firstname.sendKeys(firstname);
		Email.sendKeys(email);
		mobile_number.sendKeys(phonNumber);
		pwdtxt.sendKeys(Password);
		this.readCapcha();
 
		Thread.sleep(3000);
		
		
		
		
	}
	
	public static File captureElementPicture(WebElement element)
            throws Exception {
 
        // get the WrapsDriver of the WebElement
        WrapsDriver wrapsDriver = (WrapsDriver) element;
 
        // get the entire screenshot from the driver of passed WebElement
        File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver())
                .getScreenshotAs(OutputType.FILE);
 
        // create an instance of buffered image from captured screenshot
        BufferedImage img = ImageIO.read(screen);
 
        // get the width and height of the WebElement using getSize()
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
 
        // create a rectangle using width and height
        Rectangle rect = new Rectangle(width, height);
 
        // get the location of WebElement in a Point.
        // this will provide X & Y co-ordinates of the WebElement
        Point p = element.getLocation();
 
        // create image  for element using its location and size.
        // this will give image data specific to the WebElement
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width,
                rect.height);
 
        // write back the image data for element in File object
        ImageIO.write(dest, "png", screen);
 
        // return the File object containing image data
        return screen;
    }
	
	public void readCapcha() throws Exception
	{
	 
		        // get and capture the picture of the img element used to display the barcode image
		        WebElement barcodeImage = driver.findElement(By.id("security_image"));
		        File imageFile = Home.captureElementPicture(barcodeImage);
		 
		        // get the Tesseract direct interace
		        Tesseract instance = new Tesseract();
		        instance.setLanguage("eng");
		 
		        // the doOCR method of Tesseract will retrive the text
		        // from image captured by Selenium
		        String result = instance.doOCR(imageFile);
		 
		        // check the the result
		        assertEquals("Application number did not match", "123-45678", result.trim());
		        System.out.println("*********"+result.toString());
		    
		}
		
	}
	

