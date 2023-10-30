package SaturdaysConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableScenario2 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[1]")).click();
	}

}
