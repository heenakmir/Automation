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
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2WithDDT {

	public static void main(String[] args) throws Throwable {
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
Properties prop = new Properties();
prop.load(file);
String BROWSER = prop.getProperty("browser");
String URL = prop.getProperty("url");
String USERNAME = prop.getProperty("username");
String PASSWORD = prop.getProperty("password");
FileInputStream file1 = new FileInputStream(".\\src\\test\\resources\\testdata.exe.xlsx");
Workbook b = WorkbookFactory.create(file1);
String Orgname = b.getSheet("Organisation").getRow(1).getCell(2).getStringCellValue();
WebDriver driver=null;
if (BROWSER.equalsIgnoreCase("firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	System.out.println(BROWSER+" launched");
}
else 
{
	System.out.println("invalid browser name");
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get(URL);
driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
Thread.sleep(1000);
WebElement text = driver.findElement(By.xpath("//input[@name='accountname']"));
text.sendKeys(Orgname);
driver.findElement(By.xpath("//input[@accesskey='S']")).click();

	}

}
