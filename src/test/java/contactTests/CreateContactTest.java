package contactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelSheetUtility;
import genericUtilities.JavaFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTest extends BaseClass
{

	@Test(groups="SmokeSuite")
	public void CreateContactTest() throws Throwable
	{
	
		ExcelSheetUtility eUtil = new ExcelSheetUtility();
		JavaFileUtility jUtil = new JavaFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL =  pUtil.readDataFromPropertyFile("url");
		String USERNAME =  pUtil.readDataFromPropertyFile("username");
		String PASSWORD =  pUtil.readDataFromPropertyFile("password");
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);
		WebDriver driver=null;
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
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickOnContactLink();
		Thread.sleep(2000);
		ContactPage cp = new ContactPage(driver);
		Thread.sleep(4000);
		cp.createNewContact();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		Thread.sleep(4000);
		cncp.createNewContact(LASTNAME);
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactheader = cip.getContactHeaderText();
		if (contactheader.contains(LASTNAME)) 
		{
			System.out.println("PASS");
		}
		else 
		{
System.out.println("FAIL");
		}
		Thread.sleep(4000);
		hp.logOutOfApp(driver);
		driver.quit();
	}

}
