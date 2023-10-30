package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class Scenario1 {

	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		/*driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();*/
		
		//By usin Object repository
		
		LoginPage lp = new LoginPage(driver);
		lp.getUserNameEdt().sendKeys("admin");
		lp.getPassWordEdt().sendKeys("admin");
		lp.getLoginBtn().click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Heena Mir");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement img = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(img).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
		
		
	}

}
