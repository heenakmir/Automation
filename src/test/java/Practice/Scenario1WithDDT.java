package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1WithDDT {

	public static void main(String[] args) throws Throwable {
		//step 1 read all the  necessary data
		 /*read data from property file-common data*/
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(file);
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		/*read data from excel-test data*/
		FileInputStream file1 = new FileInputStream(".\\src\\test\\resources\\testdata.exe.xlsx");
		Workbook wb = WorkbookFactory.create(file1);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		
		WebDriver driver=null;
		//Step 2: Launch the Browser // Run Time Polymorphism - driver
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Step 3:load the application
		driver.get(URL);
		//Step 4: Login to Application
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		//Step 5: Navigate to Contacts LInk
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//Step 6: Click on create conatct look up Image
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//Step 7: create conatct
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		//Step 8: Save
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//Step 9: Validate
		Thread.sleep(1000);
String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		//Step 10: Logout
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				Thread.sleep(1000);
				
				driver.findElement(By.linkText("Sign Out")).click();
				
				System.out.println("SignOut successful");
	}
	

}
