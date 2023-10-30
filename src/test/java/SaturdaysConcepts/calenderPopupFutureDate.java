package SaturdaysConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderPopupFutureDate
{

	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		act.moveByOffset(20, 10).perform();
		Thread.sleep(1000);
		act.moveByOffset(20, 10).click().perform();
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		for(;;)//1 2 3 4 5
		{
			try 
			{ //not visible - exception - visible - click()
				driver.findElement(By.xpath("//div[@aria-label='Wed Apr 17 2024']")).click(); // No such element exception
				break;
			} 
			catch (Exception e) 
			{//click on next month
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				Thread.sleep(1000);
			}
	}

	}
}
