package organisationsTests;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

public class CreateOrgWithMultipleIndustry extends BaseClass
{
	

	@Test(dataProvider = "getData")
	public void createMultipleOrg(String OrgName, String INDUSTRYNAME) throws Throwable 
	{
		
		

		String ORGNAME = OrgName+jUtil.getrandomnumber();


		// Step 6: click on Organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();

		// Step 7: Click on Create Organization look Up Image
		OrganisationPage op = new OrganisationPage(driver);
		Thread.sleep(5000);
		op.clickOnOrgLookUpImg();

		// Step 8: Create new Organization with Mandatory fields
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		Thread.sleep(6000);
		cnop.createNewOrganisation(ORGNAME, INDUSTRYNAME);
		

		// Step 9: Validate for Organization
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgheader = oip.getHeaderText();
		Assert.assertTrue(orgheader.contains(ORGNAME));
		System.out.println(orgheader);
		
		
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleData("MultipleOrganisation");
	}

}
