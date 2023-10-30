package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelSheetUtility;
import genericUtilities.JavaFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenarios4WithUtility {

	public static void main(String[] args) throws IOException, Throwable
	{
	ExcelSheetUtility eUtil = new ExcelSheetUtility();	
	JavaFileUtility jUtil = new JavaFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	WebDriver driver=null;
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	String ORGNAME = eUtil.readDataFromExcelSheet("Organisation", 1, 2)+jUtil.getrandomnumber();
	String INDUSTRY = eUtil.readDataFromExcelSheet("Organisation", 7, 3);
	String TYPE = eUtil.readDataFromExcelSheet("Organisation", 7, 4);
	if (BROWSER.equalsIgnoreCase("firefox")) 
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println(BROWSER+" launched");	
	} 
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		System.out.println(BROWSER+" launched");	
	}
	else 
	{
		System.out.println("invalid browser name");
	}
	wUtil.maximiseWindow(driver);
	wUtil.WaitForPageLoad(driver);
	driver.get(URL);
	driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//select[@name='industry']")).sendKeys(INDUSTRY);
	driver.findElement(By.xpath("//select[@name='accounttype']")).sendKeys(TYPE);
	driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	String ORGHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if (ORGHEADER.contains(ORGNAME))
	{
		System.out.println("ORGNAME");
		System.out.println("PASS");
	}
	else 
	{
        System.out.println("FAIL");
	}
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wUtil.mouseHoverAction(driver, ele);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	System.out.println("logout successful");
	}

}
