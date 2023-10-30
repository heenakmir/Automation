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

public class Scenario2WithUtility {
	public static void main(String[] args) throws IOException, Throwable {
		//step1:Create all the required objects
		JavaFileUtility jUtil = new JavaFileUtility();
		ExcelSheetUtility eUtil = new ExcelSheetUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
	WebDriver driver=null;
		
		//step2:Read the Required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String ORGNAME = eUtil.readDataFromExcelSheet("Organisation", 1, 2)+jUtil.getrandomnumber();

		//step3:Launch the browser
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
		
		//step4:Load the URL
		driver.get(URL);
		
		//step5:Login to application
		/*driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();*/
		
		//Using Object Repo
		/*LoginPage lp = new LoginPage(driver);
		lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getPassWordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();*/
		
		//Business Lib
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//step6:Navigate to Organization link
		Thread.sleep(1000);
		driver.findElement(By.linkText("Organizations")).click();
		
		//step7:click on create organization lookup imag
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//step8:create the organization with mandatory information
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		//step9:save
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		//step10:
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		//step111:validate
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		//step12:Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		System.out.println("logout successful");
	}
}
