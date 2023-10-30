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
public class CreateOrganisationTest extends BaseClass
{

	@Test(groups="RegressionSuite")
	public void createOrganisationTest() throws Throwable
	{
		
				String ORGNAME = eUtil.readDataFromExcelSheet("Organisation", 1, 2)+jUtil.getrandomnumber();

				//click on organisation link in home page
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgLink();
				
				//click on organisation lookup image
				OrganisationPage op = new OrganisationPage(driver);
				Thread.sleep(6000);
				op.clickOnOrgLookUpImg();
				
				//create organisation with mandetory field
				CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
				Thread.sleep(6000);
				cnop.createNewOrganisation(ORGNAME);
				
				//validation
				OrgInfoPage oip = new OrgInfoPage(driver);
				String Orgheader = oip.getHeaderText();
				Thread.sleep(6000);
				Assert.assertTrue(Orgheader.contains(ORGNAME));
				System.out.println(Orgheader);
			
	}

}
