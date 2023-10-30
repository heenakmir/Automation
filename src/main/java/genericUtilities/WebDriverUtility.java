package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class is consist of all generic utility of WebDriver actions
 * @author Heena
 *
 */

public class WebDriverUtility
/**
 * This method is used to maximize the window
 */
{
public void maximiseWindow(WebDriver driver)
{
	driver.manage().window().maximize();//browser is launched and window is maximized
}
/**
 * This method is used to minimize the window
 * @param driver
 */
 public void minimizeWindow(WebDriver driver)
 {
	 driver.manage().window().minimize();
 }
 /**
  * This method will wait for page to load
  * @param driver
  */
 public void WaitForPageLoad(WebDriver driver)
 {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
 }
 /**
  * This method will wait until particular element is visible in DOM
  * @param driver
  * @param element
  */
 public void WaitForElementToBeVisible(WebDriver driver, WebElement element)
 {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOf(element));
 }
 /**
  * This method will wait for particular element to be click able
  * @param driver
  * @param element
  */
 public void waitForElementToBeClickable(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
 }
 /**
  * This method will handle drop down by its index value
  * @param element
  * @param index
  */
 public void handleDropDown(WebElement element,int index)
 {
	Select sel = new Select(element);
	sel.selectByIndex(index);
 }
 /**
  * This method will handle drop down by its value
  * @param element
  * @param value
  */
 public void handleDropDown(WebElement element,String value)
 {
	 Select sel = new Select(element);
	 sel.selectByValue(value);
 }
 /**
  * This method will handle drop down by its visible text
  * @param text
  * @param element
  */
 public void handleDropDown(String text,WebElement element)
 {
	 Select sel = new Select(element);
	 sel.selectByVisibleText(text);
 }
 /**
  * This method will move the mouse to particular element
  * @param driver
  * @param element
  */
 public void mouseHoverAction(WebDriver driver,WebElement element)
 {
         Actions act = new Actions(driver);
         act.moveToElement(element).perform();
 }
 /**
  * This method will move the mouse to given offset values
  * @param driver
  * @param x
  * @param y
  */
 public void mouseHoverAction(WebDriver driver)
 {
	 Actions act = new Actions(driver); 
	 act.moveByOffset(10, 10).perform();
 }
 /**
  * This method will move the mouse to given x&y co-ordinates
  * @param y
  * @param x
  * @param driver
  */
 public void mouseHoverAction(int y,int x,WebDriver driver)
 {
	 Actions act = new Actions(driver); 
	 act.moveToLocation(x, y).perform();
 }
 /**
  * This method is used to right click on element
  * @param driver
  */
 public void mouseHoverAction(WebElement element,WebDriver driver)
 {
	 Actions act = new Actions(driver);
	 act.contextClick(element).perform();
 }
 /**
  * This method will drag and drop element
  * @param driver
  * @param drag
  * @param drop
  */
 public void mouseHoverAction(WebDriver driver,WebElement drag,WebElement drop)
 {
	 Actions act = new Actions(driver);
	 act.dragAndDrop(drag, drop).perform();
 }
 /**
  * This method will perform double click on element
  * @param driver
  * @param element
  */
 public void doubleClickAction(WebDriver driver,WebElement element)
 {
	 Actions act = new Actions(driver); 
	 act.doubleClick(element).perform();
 }
 /**
  * This method is used to switch the frame by index value
  * @param driver
  * @param x
  */
 public void frameHandling(WebDriver driver,int x)
 {
	driver.switchTo().frame(x);
 }
 /**
  * This method will handle the frame by using string
  * @param driver
  * @param nameorID
  */
 public void frameHandling(WebDriver driver,String nameorID)
 {
 driver.switchTo().frame("nameorId");
 }
 /**
  * This method will handle the frame by using Web Element
  * @param element
  * @param driver
  */
 
 public void frameHandling(WebElement element,WebDriver driver)
 {
	 driver.switchTo().frame(element);
 }
 /**
  * This method will scroll Down by action
  * @param driver
  */
 public void scrollDownAction(WebDriver driver)
 {
	 JavascriptExecutor jse = (JavascriptExecutor)driver;
	 jse.executeScript("window.scrollBy(0,2000);", "");
 }
 /**
  * This method will scroll up by action
  * @param driver
  */
 public void scrollUpAction(WebDriver driver)
 {
	 JavascriptExecutor jse = (JavascriptExecutor)driver;
	 jse.executeScript("window.scrollBy(0,-1000);", "");
 }
 /**
  * This method will handle and accept the alert pop-up
  */
 public void alertAcceptPopup(WebDriver driver)
 {
	driver.switchTo().alert().accept();	
 }
 /**
  * This method will Dismiss the alert pop up
  * @param driver
  */
 public void alertDismissPopup(WebDriver driver)
 {
	 driver.switchTo().alert().dismiss(); 	
 }
 /**
  * This method will handle the alert pop-up using get text
  * @param driver
  */
 public void getAlertText(WebDriver driver) 
 {
 driver.switchTo().alert().getText();
 }
 /**
  * This method will take screen shot and return the dst path
  * @param driver
  * @param screenshotName
  * @throws IOException
  */
 public String takeScrennShot(WebDriver driver,String screenshotName) throws IOException
 {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);//temporary location
	File dst = new File(".\\ScreenShots\\"+screenshotName+".png");
	Files.copy(src, dst);
	return dst.getAbsolutePath();
	
 }
 /**
  * This method will used to switch to parent to child and child to parent window based on title
  * @param driver
  * @param partialwindowtitle
  */
 
 public void switchToWindow(WebDriver driver,String partialwindowtitle)
 {
	 //step1:Get all the windows ids
	 Set<String> allwinids = driver.getWindowHandles();
	 
	 //step2:navigate through each window
	 for (String winid : allwinids) 
	 {
		//step3:switch to each wnidow and capture title
		 String actTitle = driver.switchTo().window(winid).getTitle();
		 //step4:compare act title with expected partial title
		 if (actTitle.contains(partialwindowtitle))
		 {
			break;
		}
	}
 }
}
