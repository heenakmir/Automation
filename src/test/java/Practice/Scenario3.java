package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Thread.sleep(1000);
		WebElement text = driver.findElement(By.xpath("//input[@name='accountname']"));
		text.sendKeys("wipro 123");
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		 industry.click();
		Select sel = new Select( industry);
		sel.selectByVisibleText("Chemicals");
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		WebElement img = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(img).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
	}

}
