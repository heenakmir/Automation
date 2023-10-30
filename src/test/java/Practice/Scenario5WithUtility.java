package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelSheetUtility;
import genericUtilities.JavaFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class Scenario5WithUtility {

	public static void main(String[] args) throws Throwable {
		ExcelSheetUtility eUtil = new ExcelSheetUtility();	
		JavaFileUtility jUtil = new JavaFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver=null;
	
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);
		String ORGNAME = eUtil.readDataFromExcelSheet("Organisation", 1, 2)+jUtil.getrandomnumber();
		
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
		
		driver.get(URL);
		wUtil.maximiseWindow(driver);
		wUtil.WaitForPageLoad(driver);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		
		
		
		
	}
}
