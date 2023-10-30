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
import objectRepository.LoginPage;

public class scenario1WithUtility {

	public static void main(String[] args) throws IOException, Throwable 
	{
		JavaFileUtility jUtil = new JavaFileUtility();
		ExcelSheetUtility eUtil = new ExcelSheetUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver=null;
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL =  pUtil.readDataFromPropertyFile("url");
		String USERNAME =  pUtil.readDataFromPropertyFile("username");
		String PASSWORD =  pUtil.readDataFromPropertyFile("password");
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);
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
		/*driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();*/
		
		//BY using Object repo
		/*LoginPage lp = new LoginPage(driver);
		lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getPassWordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();*/
		
		//By using business lib
		LoginPage LP = new LoginPage(driver);
		LP.loginToApp(USERNAME, PASSWORD);
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String CONHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (CONHEADER.contains(LASTNAME)) 
		{
			System.out.println(CONHEADER);
			System.out.println("PASS");
		}
		else 
		{
			System.out.println("FAIL");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		System.out.println("logout successful");
	}

}
