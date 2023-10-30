package organisationsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class CreateOrganisationWithIndustryTest extends BaseClass
{
	@Test()
public void CreateOrganisationWithIndustryTest() throws IOException, Throwable
{
		
		String ORGNAME = eUtil.readDataFromExcelSheet("Organisation", 1, 2)+jUtil.getrandomnumber();
		String INDUSTRY = eUtil.readDataFromExcelSheet("Organisation",4,3);	
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		OrganisationPage op = new OrganisationPage(driver);
		Thread.sleep(5000);
		op.clickOnOrgLookUpImg();
		
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		Thread.sleep(6000);
		cnop.createNewOrganisation(ORGNAME, INDUSTRY);
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgheader = oip.getHeaderText();
		Assert.assertTrue(orgheader.contains(ORGNAME));
		System.out.println(orgheader);
	}	
}

