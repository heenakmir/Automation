package organisationsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelSheetUtility;
import genericUtilities.JavaFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrgPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrgInfoPage;
import objectRepository.OrganisationPage;
@Listeners(genericUtilities.ListenersImplementationClass.class)
public class CreateOrganisationWithIndustryAndTypeTest extends BaseClass
{
@Test
public void createOrganisationWithIndustryAndTypeTest() throws Throwable
{

	String ORGNAME = eUtil.readDataFromExcelSheet("Organisation", 1, 2)+jUtil.getrandomnumber();
	String INDUSTRY = eUtil.readDataFromExcelSheet("Organisation",7,3);
	String TYPE = eUtil.readDataFromExcelSheet("Organisation", 7, 4);
	
	HomePage hp = new HomePage(driver);
	hp.clickOnOrgLink();
	
	OrganisationPage op = new OrganisationPage(driver);
	Thread.sleep(4000);
	op.clickOnOrgLookUpImg();
	
	CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
	Thread.sleep(6000);
	cnop.createNewOrganisation(ORGNAME, INDUSTRY, TYPE);
	OrgInfoPage oip = new OrgInfoPage(driver);
	String orgheader = oip.getHeaderText();
	Assert.assertTrue(orgheader.contains(ORGNAME));
	System.out.println(orgheader);
	
}
	 

}
