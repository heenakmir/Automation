package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.ExcelSheetUtility;
import genericUtilities.JavaFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrgPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrgInfoPage;
import objectRepository.OrganisationPage;

public class CreateContactWithOrganisationTest
{
@Test()
public void CreateContactWithOrganisationTest() throws IOException, Throwable
{
	//Step1:create object
	ExcelSheetUtility eUtil = new ExcelSheetUtility();	
	JavaFileUtility jUtil = new JavaFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	WebDriver driver=null;
//Step2:Read the data
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);
	String ORGNAME = eUtil.readDataFromExcelSheet("Organisation", 1, 2)+jUtil.getrandomnumber();
	//Step3:open the browser
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
	//step4:load the URL
	driver.get(URL);
	//Step5:Login to application
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	//Step6:click on Organisation link
	HomePage hp = new HomePage(driver);
	Thread.sleep(3000);
	hp.clickOnOrgLink();
	//step7:click on organisation look up image
	OrganisationPage op = new OrganisationPage(driver);
	Thread.sleep(5000);
	op.clickOnOrgLookUpImg();
	//Step8:create new organisation with mandetory fileds
	CreateNewOrgPage cnp = new CreateNewOrgPage(driver);
	Thread.sleep(4000);
	cnp.createNewOrganisation(ORGNAME);
	//Step9:validation for organisation
	OrgInfoPage oip = new OrgInfoPage(driver);
	Thread.sleep(4000);
	String orgheader = oip.getHeaderText();
	Assert.assertTrue(orgheader.contains(ORGNAME));
	System.out.println(orgheader);
		
	//Step10:click on conatct link in home page
	hp.clickOnContactLink();
	
	//Step11:click on contact look up icon
	
	ContactPage cp = new ContactPage(driver);
	Thread.sleep(4000);
	cp.createNewContact();
	
	//Step12:create contact with organisation
	CreateNewContactPage cncp = new CreateNewContactPage(driver);
	cncp.createNewContact(driver, LASTNAME, ORGNAME);
	 //Step13: Validation
	ContactInfoPage cip = new ContactInfoPage(driver);
	String conHeader = cip.getContactHeaderText();
	if (conHeader.contains(LASTNAME)) 
	{
		System.out.println("PASS");
	} 
	else
	{
System.out.println("FAIL");
	}
	//Step14:Logout
	hp.logOutOfApp(driver);
	driver.quit();
	
}
}
